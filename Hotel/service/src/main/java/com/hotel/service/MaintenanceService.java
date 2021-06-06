package com.hotel.service;


import com.hotel.api.dao.IMaintenanceDao;
import com.hotel.api.dao.IOrderDao;
import com.hotel.api.service.IMaintenanceService;
import com.hotel.exceptions.DaoException;
import com.hotel.exceptions.ServiceException;
import com.hotel.model.Maintenance;
import com.hotel.model.Order;
import com.hotel.model.Room;
import com.hotel.model.dto.MaintenanceDto;
import com.hotel.model.dto.OrderDto;
import com.hotel.model.dto.RoomDto;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MaintenanceService implements IMaintenanceService {
    private final IMaintenanceDao maintenanceDao;
    private final IOrderDao orderDao;
    private final ModelMapper mapper;

    private static final Logger LOGGER= LogManager.getLogger(GuestService.class.getName());

    @Override
    public Maintenance addService(String name, Integer price, OrderDto orderDto) {
        try {
            LOGGER.info(String.format("Adding of maintenance %s with price %d",name,price));
        Maintenance maintenance=new Maintenance();
        maintenance.setName(name);
        maintenance.setPrice(price);
        Order order=mapper.map(orderDto,Order.class);
        maintenance.setOrder(order);
        maintenanceDao.save(maintenance);
        return maintenance;
        }catch (DaoException e){
            LOGGER.warn("Adding of maintenance failed",e);
            throw new ServiceException("Adding of maintenance failed",e);
        }
    }

    @Override
    public List<MaintenanceDto> getAll() {
        List<Maintenance> maintenanceList=maintenanceDao.getAll();
        maintenanceList.sort(((o1, o2) -> o1.getPrice()- o2.getPrice()));
        List<MaintenanceDto> maintenanceDtos=new ArrayList<>();
        for(Maintenance maintenance:maintenanceList){
            MaintenanceDto maintenanceDto=mapper.map(maintenance,MaintenanceDto.class);
            maintenanceDtos.add(maintenanceDto);
        }
        return maintenanceDtos;
    }

    @Override
    public MaintenanceDto getById(Integer maintenanceId) {
        Maintenance maintenance=maintenanceDao.getByid(maintenanceId);
        return mapper.map(maintenance, MaintenanceDto.class);
    }

    @Override
    public void deleteMaintenance(Integer maintenanceId) {
        Maintenance maintenance=maintenanceDao.getByid(maintenanceId);
        maintenanceDao.delete(maintenance);
    }
}
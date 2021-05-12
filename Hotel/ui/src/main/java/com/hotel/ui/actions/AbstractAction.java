package com.hotel.ui.actions;

import com.hotel.config.CustomLogger;
import com.hotel.dao.util.EntityManagerUtil;
import com.hotel.facade.HotelFacade;
import com.hotel.injection.ApplicationContext;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class AbstractAction {

private ApplicationContext applicationContext=ApplicationContext.getInstance();

    protected HotelFacade hotelFacade=applicationContext.hotelFacade();
    protected BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
    protected Logger LOGGER= LogManager.getLogger(AbstractAction.class.getName());

    public HotelFacade getHotelFacade() {
        return hotelFacade;
    }

    public void setHotelFacade(HotelFacade hotelFacade) {
        this.hotelFacade = hotelFacade;
    }
}

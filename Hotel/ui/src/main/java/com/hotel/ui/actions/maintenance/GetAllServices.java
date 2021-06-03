package com.hotel.ui.actions.maintenance;

import com.hotel.model.Maintenance;
import com.hotel.ui.actions.AbstractAction;
import com.hotel.ui.actions.IAction;

import java.util.List;

public class GetAllServices extends AbstractAction implements IAction {
    @Override
    public void execute() {
        List<Maintenance> maintenances=hotelFacade.getAllServices();
        System.out.println(maintenances);
    }
}

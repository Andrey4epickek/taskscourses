package com.hotel.ui.actions;

import com.hotel.facade.HotelFacade;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class AbstractAction {


    protected HotelFacade hotelFacade;
    protected BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
    protected Logger LOGGER= LogManager.getLogger(AbstractAction.class.getName());

    public HotelFacade getHotelFacade() {
        return hotelFacade;
    }

    public void setHotelFacade(HotelFacade hotelFacade) {
        this.hotelFacade = hotelFacade;
    }
}

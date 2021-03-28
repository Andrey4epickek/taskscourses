package ui.actions;


import com.senlainc.config.CustomLogger;
import com.senlainc.facade.HotelFacade;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public abstract class AbstractAction {
    protected HotelFacade hotelFacade=HotelFacade.getInstance();
    protected BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
    protected Logger LOGGER=Logger.getLogger(CustomLogger.class.getName());
}

package ui.actions;

import com.config.CustomLogger;
import com.facade.HotelFacade;
import com.injection.ApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public abstract class AbstractAction {

private ApplicationContext applicationContext=ApplicationContext.getInstance();

    protected HotelFacade hotelFacade=applicationContext.hotelFacade();
    protected BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
    protected Logger LOGGER=Logger.getLogger(CustomLogger.class.getName());

    public HotelFacade getHotelFacade() {
        return hotelFacade;
    }

    public void setHotelFacade(HotelFacade hotelFacade) {
        this.hotelFacade = hotelFacade;
    }
}

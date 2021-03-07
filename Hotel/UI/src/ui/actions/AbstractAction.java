package ui.actions;


import com.senlainc.facade.HotelFacade;

public abstract class AbstractAction {
    protected HotelFacade hotelFacade=HotelFacade.getInstance();
}

package hotel.ui.actions;


import facade.HotelFacade;

public abstract class AbstractAction {
    protected HotelFacade hotelFacade=HotelFacade.getInstance();
}

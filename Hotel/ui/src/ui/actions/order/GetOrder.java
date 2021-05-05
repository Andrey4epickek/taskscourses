package ui.actions.order;

import ui.actions.AbstractAction;
import ui.actions.IAction;
import com.model.Order;
import java.util.logging.Level;


public class GetOrder extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            System.out.println("Введите Id заказа");
            String orderIdString =reader.readLine();
            Integer orderId=Integer.parseInt(orderIdString);
            Order order= hotelFacade.getOrder(orderId);
            System.out.println(order);
        }catch (Exception e){
            LOGGER.log(Level.WARNING,e.getLocalizedMessage(),e);
        }
    }
}

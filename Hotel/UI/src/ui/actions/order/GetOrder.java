package ui.actions.order;

import ui.actions.AbstractAction;
import ui.actions.IAction;
import com.senlainc.model.Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetOrder extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите Id заказа");
            String orderIdString =reader.readLine();
            Integer orderId=Integer.parseInt(orderIdString);
            Order order= hotelFacade.getOrder(orderId);
            System.out.println(order);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}

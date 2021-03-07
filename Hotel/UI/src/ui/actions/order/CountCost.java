package ui.actions.order;

import ui.actions.AbstractAction;
import ui.actions.IAction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountCost extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите Id заказа");
            String orderIdString= reader.readLine();
            Integer orderId=Integer.parseInt(orderIdString);
            int cost= hotelFacade.countCost(orderId);
            System.out.println(cost);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}

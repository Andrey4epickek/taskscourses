package ui.actions.maintenance;

import com.model.Maintenance;
import ui.actions.AbstractAction;
import ui.actions.IAction;

import java.util.List;

public class GetAllServices extends AbstractAction implements IAction {
    @Override
    public void execute() {
        List<Maintenance> maintenances=hotelFacade.getAllServices();
        System.out.println(maintenances);
    }
}

package com.library.ui.menu;


import com.library.ui.actions.acceptance.AddAcceptance;
import com.library.ui.actions.acceptance.DeleteAcceptance;
import com.library.ui.actions.acceptance.GetAcceptance;
import com.library.ui.actions.acceptance.GetAllAcceptance;
import com.library.ui.actions.book.AddBook;
import com.library.ui.actions.book.DeleteBook;
import com.library.ui.actions.book.GetAllBooks;
import com.library.ui.actions.book.GetBook;
import com.library.ui.actions.issuance.AddIssuance;
import com.library.ui.actions.issuance.DeleteIssuance;
import com.library.ui.actions.issuance.GetAllIssuance;
import com.library.ui.actions.issuance.GetIssuance;
import com.library.ui.actions.reader.AddReader;
import com.library.ui.actions.reader.DeleteReader;
import com.library.ui.actions.reader.GetAllReaders;
import com.library.ui.actions.reader.GetReader;
import com.library.ui.actions.worker.AddWorker;
import com.library.ui.actions.worker.DeleteWorker;
import com.library.ui.actions.worker.GetAllWorkers;
import com.library.ui.actions.worker.GetWorker;

public class MenuBuilderFactory {
    private static final String BACK_TO_PREVIOUS ="Back to previous menu";

    public Menu mainMenu(Menu rootMenu,Menu previousMenu){
        return new MenuBuilder(rootMenu)
                .addItem(new MenuItem("Reader actions",null,readerMenu(new Menu(),rootMenu)))
                .addItem(new MenuItem("Worker actions",null,workerMenu(new Menu(),rootMenu)))
                .addItem(new MenuItem("Book actions",null,bookMenu(new Menu(),rootMenu)))
                .addItem(new MenuItem("Issuance actions",null,issuanceMenu(new Menu(),rootMenu)))
                .addItem(new MenuItem("Acceptance actions",null,acceptanceMenu(new Menu(),rootMenu)))
                .addItem(previousMenu==null?null:new MenuItem(BACK_TO_PREVIOUS,null,previousMenu))
                .build("Hotel Application menu (0-Exit)");

    }

    public Menu readerMenu(Menu rootMenu,Menu previousMenu){
        return new MenuBuilder(rootMenu)
                .addItem(new MenuItem("Add reader",new AddReader(),rootMenu))
                .addItem(new MenuItem("Get reader",new GetReader(),rootMenu))
                .addItem(new MenuItem("Get all readers",new GetAllReaders(),rootMenu))
                .addItem(new MenuItem("Delete reader",new DeleteReader(),rootMenu))
                .addItem(previousMenu==null?null:new MenuItem(BACK_TO_PREVIOUS,null,previousMenu))
                .build("Hotel Application menu (0-Exit)");
    }

    public Menu workerMenu(Menu rootMenu,Menu previousMenu){
        return new MenuBuilder(rootMenu)
                .addItem(new MenuItem("Add worker",new AddWorker(),rootMenu))
                .addItem(new MenuItem("Get worker",new GetWorker(),rootMenu))
                .addItem(new MenuItem("Get all workers",new GetAllWorkers(),rootMenu))
                .addItem(new MenuItem("Delete worker",new DeleteWorker(),rootMenu))
                .addItem(previousMenu==null?null:new MenuItem(BACK_TO_PREVIOUS,null,previousMenu))
                .build("Hotel Application menu (0-Exit)");
    }

    public Menu bookMenu(Menu rootMenu,Menu previousMenu){
        return new MenuBuilder(rootMenu)
                .addItem(new MenuItem("Add book",new AddBook(),rootMenu))
                .addItem(new MenuItem("Get book",new GetBook(),rootMenu))
                .addItem(new MenuItem("Get all books",new GetAllBooks(),rootMenu))
                .addItem(new MenuItem("Delete book",new DeleteBook(),rootMenu))
                .addItem(previousMenu==null?null:new MenuItem(BACK_TO_PREVIOUS,null,previousMenu))
                .build("Hotel Application menu (0-Exit)");
    }

    public Menu issuanceMenu(Menu rootMenu,Menu previousMenu){
        return new MenuBuilder(rootMenu)
                .addItem(new MenuItem("Add issuance",new AddIssuance(),rootMenu))
                .addItem(new MenuItem("Get issuance",new GetIssuance(),rootMenu))
                .addItem(new MenuItem("Get all issuance",new GetAllIssuance(),rootMenu))
                .addItem(new MenuItem("Delete issuance",new DeleteIssuance(),rootMenu))
                .addItem(previousMenu==null?null:new MenuItem(BACK_TO_PREVIOUS,null,previousMenu))
                .build("Hotel Application menu (0-Exit)");
    }

    public Menu acceptanceMenu(Menu rootMenu,Menu previousMenu){
        return new MenuBuilder(rootMenu)
                .addItem(new MenuItem("Add acceptance",new AddAcceptance(),rootMenu))
                .addItem(new MenuItem("Get acceptance",new GetAcceptance(),rootMenu))
                .addItem(new MenuItem("Get all acceptance",new GetAllAcceptance(),rootMenu))
                .addItem(new MenuItem("Delete acceptance",new DeleteAcceptance(),rootMenu))
                .addItem(previousMenu==null?null:new MenuItem(BACK_TO_PREVIOUS,null,previousMenu))
                .build("Hotel Application menu (0-Exit)");
    }

}

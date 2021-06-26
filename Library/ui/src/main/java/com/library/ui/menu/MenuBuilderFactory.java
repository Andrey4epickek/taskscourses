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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuBuilderFactory {
    private static final String BACK_TO_PREVIOUS ="Back to previous menu";

    ApplicationContext context=new ClassPathXmlApplicationContext("appContext.xml");

    public Menu mainMenu(Menu rootMenu,Menu previousMenu){
        return new MenuBuilder(rootMenu)
                .addItem(new MenuItem("Reader actions",null,readerMenu(new Menu(),rootMenu)))
                .addItem(new MenuItem("Worker actions",null,workerMenu(new Menu(),rootMenu)))
                .addItem(new MenuItem("Book actions",null,bookMenu(new Menu(),rootMenu)))
                .addItem(new MenuItem("Issuance actions",null,issuanceMenu(new Menu(),rootMenu)))
                .addItem(new MenuItem("Acceptance actions",null,acceptanceMenu(new Menu(),rootMenu)))
                .addItem(previousMenu==null?null:new MenuItem(BACK_TO_PREVIOUS,null,previousMenu))
                .build("Library Application menu (0-Exit)");

    }

    public Menu readerMenu(Menu rootMenu,Menu previousMenu){
        return new MenuBuilder(rootMenu)
                .addItem(new MenuItem("Add reader",context.getBean(AddReader.class),rootMenu))
                .addItem(new MenuItem("Get reader",context.getBean(GetReader.class),rootMenu))
                .addItem(new MenuItem("Get all readers",context.getBean(GetAllReaders.class),rootMenu))
                .addItem(new MenuItem("Delete reader",context.getBean(DeleteReader.class),rootMenu))
                .addItem(previousMenu==null?null:new MenuItem(BACK_TO_PREVIOUS,null,previousMenu))
                .build("Library Application menu (0-Exit)");
    }

    public Menu workerMenu(Menu rootMenu,Menu previousMenu){
        return new MenuBuilder(rootMenu)
                .addItem(new MenuItem("Add worker",context.getBean(AddWorker.class),rootMenu))
                .addItem(new MenuItem("Get worker",context.getBean(GetWorker.class),rootMenu))
                .addItem(new MenuItem("Get all workers",context.getBean(GetAllWorkers.class),rootMenu))
                .addItem(new MenuItem("Delete worker",context.getBean(DeleteWorker.class),rootMenu))
                .addItem(previousMenu==null?null:new MenuItem(BACK_TO_PREVIOUS,null,previousMenu))
                .build("Library Application menu (0-Exit)");
    }

    public Menu bookMenu(Menu rootMenu,Menu previousMenu){
        return new MenuBuilder(rootMenu)
                .addItem(new MenuItem("Add book",context.getBean(AddBook.class),rootMenu))
                .addItem(new MenuItem("Get book",context.getBean(GetBook.class),rootMenu))
                .addItem(new MenuItem("Get all books",context.getBean(GetAllBooks.class),rootMenu))
                .addItem(new MenuItem("Delete book",context.getBean(DeleteBook.class),rootMenu))
                .addItem(previousMenu==null?null:new MenuItem(BACK_TO_PREVIOUS,null,previousMenu))
                .build("Library Application menu (0-Exit)");
    }

    public Menu issuanceMenu(Menu rootMenu,Menu previousMenu){
        return new MenuBuilder(rootMenu)
                .addItem(new MenuItem("Add issuance",context.getBean(AddIssuance.class),rootMenu))
                .addItem(new MenuItem("Get issuance",context.getBean(GetIssuance.class),rootMenu))
                .addItem(new MenuItem("Get all issuance",context.getBean(GetAllIssuance.class),rootMenu))
                .addItem(new MenuItem("Delete issuance",context.getBean(DeleteIssuance.class),rootMenu))
                .addItem(previousMenu==null?null:new MenuItem(BACK_TO_PREVIOUS,null,previousMenu))
                .build("Library Application menu (0-Exit)");
    }

    public Menu acceptanceMenu(Menu rootMenu,Menu previousMenu){
        return new MenuBuilder(rootMenu)
                .addItem(new MenuItem("Add acceptance", context.getBean(AddAcceptance.class),rootMenu))
                .addItem(new MenuItem("Get acceptance",context.getBean(GetAcceptance.class),rootMenu))
                .addItem(new MenuItem("Get all acceptance",context.getBean(GetAllAcceptance.class),rootMenu))
                .addItem(new MenuItem("Delete acceptance",context.getBean(DeleteAcceptance.class),rootMenu))
                .addItem(previousMenu==null?null:new MenuItem(BACK_TO_PREVIOUS,null,previousMenu))
                .build("Library Application menu (0-Exit)");
    }

}

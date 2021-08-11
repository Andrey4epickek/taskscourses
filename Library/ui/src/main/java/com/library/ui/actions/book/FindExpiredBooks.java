package com.library.ui.actions.book;

import com.library.facade.LibraryFacade;
import com.library.model.Book;
import com.library.ui.actions.AbstractAction;
import com.library.ui.actions.IAction;
import com.library.ui.actions.reader.AddReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class FindExpiredBooks extends AbstractAction implements IAction {

    protected Logger LOGGER=Logger.getLogger(AddReader.class.getName());
    private LibraryFacade libraryFacade;

    @Autowired
    public void setLibraryFacade(LibraryFacade libraryFacade){
        this.libraryFacade=libraryFacade;
    }

    @Override
    public void execute() {
        try{
            List<Book> bookList=libraryFacade.findExpiredBooks();
            System.out.println(bookList);
        }catch (Exception e){
            LOGGER.log(Level.WARNING,e.getLocalizedMessage(),e);
        }
    }
}
package com.library.ui.actions.acceptance;

import com.library.facade.LibraryFacade;
import com.library.model.*;
import com.library.model.dto.BookDto;
import com.library.model.dto.ReaderDto;
import com.library.model.dto.WorkerDto;
import com.library.ui.actions.AbstractAction;
import com.library.ui.actions.IAction;
import com.library.ui.actions.reader.AddReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class AddAcceptance extends AbstractAction implements IAction {

    protected Logger LOGGER=Logger.getLogger(AddReader.class.getName());
    private LibraryFacade libraryFacade;

    @Autowired
    public void setLibraryFacade(LibraryFacade libraryFacade){
        this.libraryFacade=libraryFacade;
    }

    @Override
    public void execute() {
        try{
            System.out.println("Введите id рабочего");
            String workerIdString=bufferedReader.readLine();
            Integer workerIdInteger=Integer.parseInt(workerIdString);
            Worker worker=libraryFacade.getWorker(workerIdInteger);
            WorkerDto workerDto=mapper.map(worker,WorkerDto.class);
            System.out.println("Введите id читателя");
            String readerIdString=bufferedReader.readLine();
            Integer readerIdInteger=Integer.parseInt(readerIdString);
            Reader reader=libraryFacade.getReader(readerIdInteger);
            ReaderDto readerDto=mapper.map(reader,ReaderDto.class);
            System.out.println("Введите id книги");
            String bookIdString=bufferedReader.readLine();
            Integer bookIdInteger=Integer.parseInt(bookIdString);
            Book book=libraryFacade.getBook(bookIdInteger);
            BookDto bookDto=mapper.map(book,BookDto.class);
            System.out.println("Введите количество книг");
            String bookSumString=bufferedReader.readLine();
            Integer bookSumInteger=Integer.parseInt(bookSumString);
            System.out.println("Введите дату выдачи книг");
            String dataString=bufferedReader.readLine();
            LocalDate data = LocalDate.parse(dataString);
            Acceptance acceptance=libraryFacade.addAcceptance(workerDto,readerDto,bookDto,bookSumInteger,data);
            System.out.println(acceptance);
        }catch (Exception e){
            LOGGER.log(Level.WARNING,e.getLocalizedMessage(),e);
        }
    }
}

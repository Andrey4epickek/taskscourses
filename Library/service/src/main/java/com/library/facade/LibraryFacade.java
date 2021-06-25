package com.library.facade;

import com.hotel.api.service.*;
import com.library.model.*;
import com.library.model.dto.*;
import com.library.service.IssuanceService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryFacade {


    private final IReaderService readerService;
    private final IWorkerService workerService;
    private final IBookService bookService;
    private final IIssuanceService issuanceService;
    private final IAcceptanceService acceptanceService;
    private final ModelMapper mapper;

    public LibraryFacade(IReaderService readerService,IWorkerService workerService,IBookService bookService,IssuanceService issuanceService,IAcceptanceService acceptanceService,ModelMapper mapper){
        this.readerService=readerService;
        this.workerService=workerService;
        this.bookService=bookService;
        this.issuanceService=issuanceService;
        this.acceptanceService=acceptanceService;
        this.mapper=mapper;
    }

    /**
     *Reader
     */
    public Reader addReader(String lastName,String firstName,String patronymic, Integer age, LocalDate data){
        Reader reader=readerService.addReader(lastName,firstName,patronymic,age,data);
        return reader;
    }

    public void deleteReader(Integer readerId){
        readerService.deleteReader(readerId);
    }

    public Reader getReader(Integer readerId){
        ReaderDto readerDto=readerService.getById(readerId);
        return mapper.map(readerDto,Reader.class);
    }

    public List<Reader> getAllReaders(){
        List<ReaderDto> readerDtoList=readerService.getAll();
        List<Reader> readerList=new ArrayList<>();
        for(ReaderDto readerDto:readerDtoList){
            Reader reader=mapper.map(readerDto,Reader.class);
            readerList.add(reader);
        }
        return readerList;
    }

    /**
     *Worker
     */
    public Worker addWorker(String lastName, String firstName, String patronymic, LocalDate data){
        Worker worker=workerService.addWorker(lastName,firstName,patronymic,data);
        return worker;
    }

    public void deleteWorker(Integer workerId){
        workerService.deleteWorker(workerId);
    }

    public Worker getWorker(Integer workerId){
        WorkerDto workerDto=workerService.getById(workerId);
        return mapper.map(workerDto,Worker.class);
    }

    public List<Worker> getAllWorkers(){
        List<WorkerDto> workerDtoList=workerService.getAll();
        List<Worker> workerList=new ArrayList<>();
        for(WorkerDto workerDto:workerDtoList){
            Worker worker=mapper.map(workerDto,Worker.class);
            workerList.add(worker);
        }
        return workerList;
    }

    /**
     *Book
     */
    public Book addBook(String title, LocalDate data, String author, Integer god, String genre, Integer sum){
        Book book=bookService.addBook(title,data,author,god,genre,sum);
        return book;
    }

    public void deleteBook(Integer bookId){
        bookService.deleteBook(bookId);
    }

    public Book getBook(Integer bookId){
        BookDto bookDto=bookService.getById(bookId);
        return mapper.map(bookDto,Book.class);
    }

    public List<Book> getAllBooks(){
        List<BookDto> bookDtoList=bookService.getAll();
        List<Book> bookList=new ArrayList<>();
        for(BookDto bookDto:bookDtoList){
            Book book=mapper.map(bookDto,Book.class);
            bookList.add(book);
        }
        return bookList;
    }

    /**
     *Issuance
     */
    public Issuance addIssuance(WorkerDto workerDto, ReaderDto readerDto, BookDto bookDto, Integer sum, Integer time,LocalDate data){
        Issuance issuance=issuanceService.addIssuance(workerDto,readerDto,bookDto,sum,time,data);
        return issuance;
    }

    public void deleteIssuance(Integer issuanceId){
        issuanceService.deleteIssuance(issuanceId);
    }

    public Issuance getIssuance(Integer issuanceId){
        IssuanceDto issuanceDto=issuanceService.getById(issuanceId);
        return mapper.map(issuanceDto,Issuance.class);
    }

    public List<Issuance> getAllIssuance(){
        List<IssuanceDto> issuanceDtoList=issuanceService.getAll();
        List<Issuance> issuanceList=new ArrayList<>();
        for(IssuanceDto issuanceDto:issuanceDtoList){
            Issuance issuance=mapper.map(issuanceDto,Issuance.class);
            issuanceList.add(issuance);
        }
        return issuanceList;
    }

    /**
     *Acceptance
     */
    public Acceptance addAcceptance(WorkerDto workerDto, ReaderDto readerDto, BookDto bookDto, Integer sum ,LocalDate data){
        Acceptance acceptance=acceptanceService.addAcceptance(workerDto,readerDto,bookDto,sum,data);
        return acceptance;
    }

    public void deleteAcceptance(Integer acceptanceId){
        acceptanceService.deleteAcceptance(acceptanceId);
    }

    public Acceptance getAcceptance(Integer acceptanceId){
        AcceptanceDto acceptanceDto=acceptanceService.getById(acceptanceId);
        return mapper.map(acceptanceDto,Acceptance.class);
    }

    public List<Acceptance> getAllAcceptance(){
        List<AcceptanceDto> acceptanceDtoList=acceptanceService.getAll();
        List<Acceptance> acceptanceList=new ArrayList<>();
        for(AcceptanceDto acceptanceDto:acceptanceDtoList){
            Acceptance acceptance=mapper.map(acceptanceDto,Acceptance.class);
            acceptanceList.add(acceptance);
        }
        return acceptanceList;
    }
}

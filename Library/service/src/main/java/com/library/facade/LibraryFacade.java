package com.library.facade;

import com.hotel.api.service.IReaderService;
import com.library.model.Reader;

import java.time.LocalDate;

public class LibraryFacade {

     IReaderService readerService;
    public Reader addReader(String lastName,String firstName,String patronymic, Integer age, LocalDate data){
        Reader reader=readerService.addReader(lastName,firstName,patronymic,age,data);
        return reader;
    }
}

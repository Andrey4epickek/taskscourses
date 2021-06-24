package com.library.facade;

import com.library.model.Reader;
import com.library.service.ReaderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;

@ComponentScan({"com.library.dao","com.library.service"})
public class LibraryFacade {
    ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
    ReaderService readerService= context.getBean(ReaderService.class);
    public Reader addReader(String lastName,String firstName,String patronymic, Integer age, LocalDate data){
        Reader reader=readerService.addReader(lastName,firstName,patronymic,age,data);
        return reader;
    }
}

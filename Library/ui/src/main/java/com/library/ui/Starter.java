package com.library.ui;

import com.library.facade.JavaConfig;
import com.library.facade.LibraryFacade;
import com.library.ui.menu.MenuController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

public class Starter {

    public static void main(String[] args) {
//        ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
//        LibraryFacade libraryFacade=context.getBean(LibraryFacade.class);
//
//        libraryFacade.addReader("pupkin","ivan","petrovich",20, LocalDate.of(2021,06,24));
         MenuController.getInstance().run();
    }
}

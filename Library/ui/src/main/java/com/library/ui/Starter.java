package com.library.ui;

import com.library.ui.menu.MenuController;

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

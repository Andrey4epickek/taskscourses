package com.library.ui;

import com.library.facade.LibraryFacade;

import java.time.LocalDate;

public class Starter {

    public static void main(String[] args) {

        LibraryFacade libraryFacade=new LibraryFacade();

        libraryFacade.addReader("pupkin","ivan","petrovich",20, LocalDate.of(2021,06,24));
//         MenuController.getInstance().run();
    }
}

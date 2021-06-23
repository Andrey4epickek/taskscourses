package com.library.ui.actions;

import com.library.facade.LibraryFacade;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class AbstractAction {
    protected BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
    protected LibraryFacade libraryFacade=new LibraryFacade();
}

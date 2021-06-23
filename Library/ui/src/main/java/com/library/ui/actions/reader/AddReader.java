package com.library.ui.actions.reader;

import com.hotel.api.service.IReaderService;
import com.library.model.Reader;
import com.library.ui.actions.AbstractAction;
import com.library.ui.actions.IAction;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddReader extends AbstractAction implements IAction {
    protected Logger LOGGER=Logger.getLogger(AddReader.class.getName());

    @Override
    public void execute() {
        try{
            System.out.println("Введите фамилию");
            String readerLastName=reader.readLine();
            System.out.println("Введите имя");
            String readerFirstName=reader.readLine();
            System.out.println("Введите отчество");
            String readerPatronymic=reader.readLine();
            System.out.println("Введите возраст");
            String readerAgeString=reader.readLine();
            Integer readerAgeInteger=Integer.parseInt(readerAgeString);
            System.out.println("Введите дату регистрации");
            String readerDataString=reader.readLine();
            LocalDate readerData = LocalDate.parse(readerDataString);
            Reader reader=libraryFacade.addReader(readerLastName,readerFirstName,readerPatronymic,readerAgeInteger,readerData);
            System.out.println(reader);
        }catch (Exception e){
            LOGGER.log(Level.WARNING,e.getLocalizedMessage(),e);
        }
    }
}

package com.hotel.api.service;

import com.library.model.Reader;
import com.library.model.dto.ReaderDto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IReaderService {
    Reader addReader( String lastName,String firstName,String patronymic, Integer age, LocalDate data);
    ReaderDto getById(Integer readerId);
    List<ReaderDto> getAll();
    void deleteReader(Integer readerId);
}

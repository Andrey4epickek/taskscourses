package com.hotel.api.service;

import com.library.model.Acceptance;
import com.library.model.dto.AcceptanceDto;
import com.library.model.dto.BookDto;
import com.library.model.dto.ReaderDto;
import com.library.model.dto.WorkerDto;

import java.util.Date;
import java.util.List;

public interface IAcceptanceService {
    Acceptance addAcceptance(WorkerDto workerDto, ReaderDto readerDto, BookDto bookDto, Integer sum, Date data);
    AcceptanceDto getById(Integer acceptanceId);
    List<AcceptanceDto> getAll();
    void deleteAcceptance(Integer acceptanceId);
}

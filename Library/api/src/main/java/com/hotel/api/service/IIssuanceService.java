package com.hotel.api.service;

import com.library.model.Issuance;
import com.library.model.dto.BookDto;
import com.library.model.dto.IssuanceDto;
import com.library.model.dto.ReaderDto;
import com.library.model.dto.WorkerDto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IIssuanceService {
    Issuance addIssuance(WorkerDto workerDto, ReaderDto readerDto, BookDto bookDto, Integer sum,Integer time, LocalDate data);
    IssuanceDto getById(Integer issuanceId);
    Issuance getByIdUi(Integer issuanceId);
    void updateIssuance(Integer issuanceId,Issuance issuance);
    List<IssuanceDto> getAll();
    void deleteIssuance(Integer issuanceId);
}

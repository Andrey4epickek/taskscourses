package com.library.model.dto;

import lombok.Data;

import java.util.Date;
@Data
public class AcceptanceDto {
    private WorkerDto workerDto;
    private ReaderDto readerDto;
    private BookDto bookDto;
    private Integer sum;
    private Date data;
}

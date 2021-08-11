package com.library.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
@Data
public class AcceptanceDto {
    private Integer id;
    private WorkerDto worker;
    private ReaderDto reader;
    private BookDto book;
    private Integer sum;
    private LocalDate data;
}

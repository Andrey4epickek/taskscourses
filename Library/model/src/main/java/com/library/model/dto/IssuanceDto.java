package com.library.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IssuanceDto {
    private Integer id;
    private WorkerDto worker;
    private ReaderDto reader;
    private BookDto book;
    private Integer sum;
    private Integer time;
    private LocalDate data;
}

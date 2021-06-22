package com.library.model.dto;

import lombok.Data;
import java.util.Date;

@Data
public class BookDto {
    private String title;
    private Date data;
    private String author;
    private Integer god;
    private String genre;
    private Integer sum;
}

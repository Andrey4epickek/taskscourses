package com.library.model.dto;

import lombok.Data;
import java.util.Date;

@Data
public class ReaderDto {
    private String name;
    private String firstName;
    private String lastName;
    private Integer age;
    private Date data;
}

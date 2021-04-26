package com.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
public class Maintenance extends AEntity implements Serializable {
    private Integer id;
    private String name;
    private Integer price;

    public Maintenance(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Maintenance(){}

}

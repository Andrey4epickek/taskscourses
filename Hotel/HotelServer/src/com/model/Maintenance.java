package com.model;

import java.io.Serializable;
import java.util.List;

public class Maintenance extends AEntity implements Serializable {
    private Integer id;
    private String name;
    private Integer price;

    public Maintenance(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Maintenance(){}

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Maintenance{"+" id="+getId()+", name="+name+", price="+price+'}';
    }
}

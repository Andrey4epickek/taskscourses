package com.hotel.model;


import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "maintenances")
@Data
public class Maintenance extends AEntity implements Serializable {
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Integer price;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_id")
    private Order order;


    public Maintenance(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Maintenance(){}

}

package com.hotel.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "maintenances")
@Data
@AllArgsConstructor
public class Maintenance extends AEntity implements Serializable {
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Integer price;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "order_id")
    private Order order;


    public Maintenance(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Maintenance(){}

    public String toString() {
        return "Maintenance [name=" + name + ", price="+price+"]";
    }
}

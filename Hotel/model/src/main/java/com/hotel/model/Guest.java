package com.hotel.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "guests")
public class Guest extends AEntity implements Serializable {

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private  Integer age;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "room_id")
    private Room room;

    @Override
    public String toString() {
        return "Guest{id=" +getId()+
                ", name=" + name +
                ", age=" + age +
                "}";
    }
}

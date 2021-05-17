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

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "room_id")
    private Room room;

    public String toString() {
        return "Guest [id="+getId()+", name=" + name + ", age="+age+"]";
    }

}

package com.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}

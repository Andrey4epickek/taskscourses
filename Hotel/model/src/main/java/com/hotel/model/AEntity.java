package com.hotel.model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class AEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

}

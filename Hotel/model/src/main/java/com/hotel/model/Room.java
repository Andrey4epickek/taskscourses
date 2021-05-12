package com.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rooms")
public class Room extends AEntity implements Serializable {
    @Column(name = "number")
    private Integer number;
    @Column(name = "capacity")
    private Integer capacity;
    @Column(name = "price")
    private Integer price;
//    @Column(name = "status")
//    private RoomStatus status;
    @Column(name = "stars")
    private Integer stars;
    @OneToMany(mappedBy = "room",fetch = FetchType.LAZY)
    private List<Guest> guests;

}

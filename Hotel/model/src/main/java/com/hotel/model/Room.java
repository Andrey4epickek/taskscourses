package com.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Data

public class Room extends AEntity implements Serializable {
    private Integer id;
    private Integer number;
    private Integer capacity;
    private Integer price;
    private RoomStatus status;
    private Integer stars;
    private List<Guest> guests;



    public Room(Integer number, Integer capacity, Integer price, RoomStatus status, Integer stars, List<Guest> guests) {
        this.number = number;
        this.capacity = capacity;
        this.price = price;
        this.status = status;
        this.stars = stars;
        this.guests = guests;
    }

    public Room() {
    }

}

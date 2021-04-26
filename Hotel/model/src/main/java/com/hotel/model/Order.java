package com.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Data
public class Order extends AEntity implements Serializable {
    private Integer id;
    private Room room;
    private Guest guest;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer cost;
    private List<Maintenance> maintenances=new ArrayList<>();

    public Order(Room room, Guest guest, LocalDate checkInDate, LocalDate checkOutDate, List<Maintenance> maintenances) {
        this.room = room;
        this.guest = guest;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.maintenances = maintenances;
    }

    public Order() {
    }

    public Order(Integer id, Room room, Guest guest) {
        this.id = id;
        this.room = room;
        this.guest = guest;
    }


}

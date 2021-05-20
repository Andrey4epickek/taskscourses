package com.hotel.model;


import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
@Data
@Entity
@Table(name = "orders")
public class Order extends AEntity implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "room_id")
    private Room room;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "guest_id")
    private Guest guest;
    @Column(name = "checkInDate")
    private LocalDate checkInDate;
    @Column(name = "checkOutDate")
    private LocalDate checkOutDate;
    private Integer cost;
    @OneToMany(mappedBy = "order",fetch = FetchType.EAGER)
    private List<Maintenance> maintenances;

    public Order(Room room, Guest guest, LocalDate checkInDate, LocalDate checkOutDate) {
        this.room = room;
        this.guest = guest;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Order() {
    }

    public Order( Room room, Guest guest) {
        this.room = room;
        this.guest = guest;
    }


    @Override
    public String toString() {
        return "Order{id=" +getId()+
                ", room=" + room +
                ", guest=" + guest +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", maintenances=" + maintenances +
                "}";
    }
}

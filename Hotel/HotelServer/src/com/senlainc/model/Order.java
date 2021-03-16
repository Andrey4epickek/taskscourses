package com.senlainc.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate cgeckOutDate) {
        this.checkOutDate = cgeckOutDate;
    }

    public List<Maintenance> getMaintenances() {
        return maintenances;
    }

    public void setMaintenances(List<Maintenance> maintenances) {
        this.maintenances = maintenances;
    }

    @Override
    public String toString() {
        return "Order{" +"id="+getId()+
                ", room=" + room +
                ", guest=" + guest +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", maintenances=" + maintenances +
                '}';
    }
}

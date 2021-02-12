package model;

import java.util.List;

public class Room extends AEntity{
    private Integer number;
    private Integer capacity;
    private Integer price;
    private RoomStatus status;

    private List<Guest> guests;

    public Room(Integer number, Integer capacity,Integer price,RoomStatus status,List<Guest> guests) {
        this.number = number;
        this.capacity = capacity;
        this.guests=guests;
        this.price=price;
        this.status=status;
    }


    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }


    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    @Override
    public String toString() {
        return "Room{"+"id="+getId()+", number="+number+", capacity="+capacity+", price="+price+", status="+status+", guests="+guests+'}';
    }
}

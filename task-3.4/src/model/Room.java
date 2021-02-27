package model;

import java.util.List;

public class Room extends AEntity{
    private Integer number;
    private Integer capacity;
    private Integer price;
    private RoomStatus status;
    private Integer stars;
    private List<Guest> guests;
    private List<Order> orders;

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

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
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
        return "Room{"+"id="+getId()+", number="+number+", capacity="+capacity+", price="+price+", status="+status+", stars="+stars+", guests="+guests+'}';
    }
}

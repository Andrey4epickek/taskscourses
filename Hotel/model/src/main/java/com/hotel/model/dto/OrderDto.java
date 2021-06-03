package com.hotel.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDto {
    private Integer id;
    private RoomDto room;
    private GuestDto guest;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}

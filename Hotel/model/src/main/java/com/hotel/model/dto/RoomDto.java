package com.hotel.model.dto;

import lombok.Data;

@Data
public class RoomDto {
    private Integer id;
    private Integer number;
    private Integer capacity;
    private Integer price;
//    private RoomStatus status;
    private Integer stars;
}

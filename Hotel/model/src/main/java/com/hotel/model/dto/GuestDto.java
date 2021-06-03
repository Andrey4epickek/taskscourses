package com.hotel.model.dto;

import lombok.Data;

@Data
public class GuestDto {

    private Integer id;
    private String name;
    private Integer age;
    private RoomDto room;
}

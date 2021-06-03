package com.hotel.model.dto;

import lombok.Data;

@Data
public class MaintenanceDto {
    private Integer id;
    private String name;
    private Integer price;
    private OrderDto order;
}

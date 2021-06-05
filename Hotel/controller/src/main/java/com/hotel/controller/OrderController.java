package com.hotel.controller;

import com.hotel.api.service.IOrderService;
import com.hotel.model.dto.MaintenanceDto;
import com.hotel.model.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j
@RestController
@RequestMapping( "/orders")
@RequiredArgsConstructor
public class OrderController {

    private final IOrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getById(@PathVariable Integer id){
        log.info("received request: /orders/"+id);
        OrderDto dto= orderService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> createOrder(@RequestBody OrderDto orderDto){
        log.info("received request: /add/"+orderDto);

        orderService.create(orderDto.getRoom(),orderDto.getGuest(),orderDto.getCheckInDate(),orderDto.getCheckOutDate());
        return ResponseEntity.noContent().build();
    }
}

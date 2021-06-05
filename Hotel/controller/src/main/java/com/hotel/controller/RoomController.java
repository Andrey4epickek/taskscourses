package com.hotel.controller;

import com.hotel.api.service.IRoomService;
import com.hotel.model.RoomStatus;
import com.hotel.model.dto.GuestDto;
import com.hotel.model.dto.RoomDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j
@RestController
@RequestMapping( "/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final IRoomService roomService;

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> getById(@PathVariable Integer id){
        log.info("received request: /rooms/"+id);
        RoomDto dto= roomService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> createRoom(@RequestBody RoomDto roomDto){
        log.info("received request: /add/"+roomDto);

        roomService.addRoom(roomDto.getNumber(),roomDto.getCapacity(),roomDto.getPrice(),roomDto.getStars(), RoomStatus.OPEN);
        return ResponseEntity.noContent().build();
    }
}

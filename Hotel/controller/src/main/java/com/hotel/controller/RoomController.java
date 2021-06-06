package com.hotel.controller;

import com.hotel.api.service.IRoomService;
import com.hotel.model.RoomStatus;
import com.hotel.model.dto.RoomDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<RoomDto>> getAll(){
        log.info("received request: /rooms/");
        List<RoomDto> roomDtoList=roomService.getAll();
        return ResponseEntity.ok(roomDtoList);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> createRoom(@RequestBody RoomDto roomDto){
        log.info("received request: /add/"+roomDto);

        roomService.addRoom(roomDto.getNumber(),roomDto.getCapacity(),roomDto.getPrice(),roomDto.getStars(), RoomStatus.OPEN);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<RoomDto> delete(@RequestParam (name = "id") Integer id){
        log.info("received request: /delete/"+id);
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/update")
    public ResponseEntity<RoomDto> update(@RequestBody RoomDto roomDto,@RequestParam (name = "id") Integer id,@RequestParam(name = "price") Integer price){
        log.info("received request: /update/"+roomDto);
        roomService.changePrice(id,price);
        return ResponseEntity.noContent().build();
    }
}

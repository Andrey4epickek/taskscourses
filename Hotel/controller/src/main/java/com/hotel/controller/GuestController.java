package com.hotel.controller;

import com.hotel.api.service.IGuestService;
import com.hotel.model.dto.GuestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Log4j
@RestController
@RequestMapping( "/guests")
@RequiredArgsConstructor
public class GuestController {

    private final IGuestService guestService;

    @GetMapping("/{id}")
    public ResponseEntity<GuestDto> getById(@PathVariable Integer id){
        log.info("received request: /guests/"+id);
        GuestDto dto= guestService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GuestDto>> getAll(){
        log.info("received request: /guests/");
        List<GuestDto> guestDtoList=guestService.getAll();
        return ResponseEntity.ok(guestDtoList);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> createGuest(@RequestBody GuestDto guestDto){
        log.info("received request: /add/"+guestDto);
        guestService.addGuest(guestDto.getName(),guestDto.getAge(),guestDto.getRoom());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<GuestDto> delete(@RequestParam (name = "id") Integer id){
        log.info("received request: /delete/"+id);
        guestService.deleteGuest(id);
        return ResponseEntity.noContent().build();
    }
}

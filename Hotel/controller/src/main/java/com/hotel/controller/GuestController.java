package com.hotel.controller;

import com.hotel.api.service.IGuestService;
import com.hotel.model.dto.GuestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public ResponseEntity<Void> createGuest(@RequestBody GuestDto guestDto){
        log.info("received request: /add/"+guestDto);

        guestService.addGuest(guestDto.getName(),guestDto.getAge(),guestDto.getRoom());
        return ResponseEntity.noContent().build();
    }
}

package com.hotel.controller;

import com.hotel.model.dto.GuestDto;
import com.hotel.service.GuestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j
@RestController
@RequestMapping("/guests")
@RequiredArgsConstructor
public class GuestController {

    private final GuestService guestService;

    @GetMapping("/{id}")
    public ResponseEntity<GuestDto> getById(@PathVariable Integer id){
        log.info("received request: /guest"+id);
        return ResponseEntity.ok(guestService.getById(id));
    }
}

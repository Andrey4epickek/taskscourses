package com.hotel.controller;

import com.hotel.api.service.IMaintenanceService;
import com.hotel.model.dto.MaintenanceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j
@RestController
@RequestMapping( "/maintenances")
@RequiredArgsConstructor
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceDto> getById(@PathVariable Integer id){
        log.info("received request: /maintenances/"+id);
        MaintenanceDto dto= maintenanceService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> createMaintenance(@RequestBody MaintenanceDto maintenanceDto){
        log.info("received request: /add/"+maintenanceDto);

        maintenanceService.addService(maintenanceDto.getName(),maintenanceDto.getPrice(),maintenanceDto.getOrder().getId());
        return ResponseEntity.noContent().build();
    }
}

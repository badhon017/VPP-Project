package com.project.roy.vpp.controller;

import com.project.roy.vpp.dto.BatteryDTO;
import com.project.roy.vpp.dto.BatteryResponse;
import com.project.roy.vpp.entity.Battery;
import com.project.roy.vpp.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/batteries")
public class BatteryController {

    @Autowired
    private BatteryService batteryService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<String> addBatteries(@RequestBody List<BatteryDTO> batteryDTOS) {
        batteryService.saveBatteries(batteryDTOS);
        return ResponseEntity.ok("Batteries added successfully");
    }

    @GetMapping
    public ResponseEntity<?> getBatteries(
            @RequestParam int minPostcode,
            @RequestParam int maxPostcode,
            @RequestParam(required = false) Integer minWattCapacity,
            @RequestParam(required = false) Integer maxWattCapacity) {

        List<Battery> batteries = batteryService.findBatteries(minPostcode, maxPostcode, minWattCapacity, maxWattCapacity);
        List<String> names = batteries.stream()
                .map(Battery::getName)
                .sorted()
                .collect(Collectors.toList());

        int totalCapacity = batteries.stream().mapToInt(Battery::getWattCapacity).sum();
        double averageCapacity = batteries.isEmpty() ? 0 : (double) totalCapacity / batteries.size();

        return ResponseEntity.ok(new BatteryResponse(names, totalCapacity, averageCapacity));
    }
    }
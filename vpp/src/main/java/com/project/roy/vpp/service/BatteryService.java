package com.project.roy.vpp.service;

import com.project.roy.vpp.dto.BatteryDTO;
import com.project.roy.vpp.entity.Battery;
import com.project.roy.vpp.repository.BatteryRepository;
import com.project.roy.vpp.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatteryService {

    @Autowired
    private BatteryRepository batteryRepository;

    public void saveBatteries(List<BatteryDTO> batteryDTOS) {
        List<Battery> batteries = batteryDTOS.stream().map(Converter::toBatteryEntity)
                .collect(Collectors.toList());
        batteryRepository.saveAll(batteries);
    }

    public List<Battery> findBatteries(int minPostcode, int maxPostcode, Integer minWattCapacity, Integer maxWattCapacity) {
        return batteryRepository.findByPostcodeBetweenAndWattCapacityBetween(
                minPostcode, maxPostcode,
                minWattCapacity != null ? minWattCapacity : Integer.MIN_VALUE,
                maxWattCapacity != null ? maxWattCapacity : Integer.MAX_VALUE);
    }
}
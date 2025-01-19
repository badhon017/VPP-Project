package com.project.roy.vpp.util;

import com.project.roy.vpp.dto.BatteryDTO;
import com.project.roy.vpp.entity.Battery;

public class Converter {
    public Converter() {
    }

    public static Battery toBatteryEntity(BatteryDTO batteryDTO) {
        Battery battery = new Battery();
        battery.setName(batteryDTO.getName());
        battery.setPostcode(Integer.parseInt(batteryDTO.getPostcode()));
        battery.setWattCapacity(batteryDTO.getCapacity());
        return battery;
    }

    public static BatteryDTO toBatteryDTO(Battery battery) {
        BatteryDTO batteryDTO = new BatteryDTO();
        batteryDTO.setName(battery.getName());
        batteryDTO.setPostcode(String.valueOf(battery.getPostcode()));
        batteryDTO.setCapacity(battery.getWattCapacity());
        return batteryDTO;
    }
}

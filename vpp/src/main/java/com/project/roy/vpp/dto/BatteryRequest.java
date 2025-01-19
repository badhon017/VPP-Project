package com.project.roy.vpp.dto;

import java.util.List;

public class BatteryRequest {
    private List<BatteryDTO> batteries;

    public List<BatteryDTO> getBatteries() {
        return batteries;
    }

    public void setBatteries(List<BatteryDTO> batteries) {
        this.batteries = batteries;
    }
}

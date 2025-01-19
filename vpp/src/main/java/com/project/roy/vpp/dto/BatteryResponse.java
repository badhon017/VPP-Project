package com.project.roy.vpp.dto;

import java.util.List;

public class BatteryResponse {
    private List<String> names;
    private int totalCapacity;
    private double averageCapacity;

    public BatteryResponse(List<String> names, int totalCapacity, double averageCapacity) {
        this.names = names;
        this.totalCapacity = totalCapacity;
        this.averageCapacity = averageCapacity;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public double getAverageCapacity() {
        return averageCapacity;
    }

    public void setAverageCapacity(double averageCapacity) {
        this.averageCapacity = averageCapacity;
    }
}

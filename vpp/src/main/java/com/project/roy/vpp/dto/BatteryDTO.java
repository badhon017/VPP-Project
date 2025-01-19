package com.project.roy.vpp.dto;

public class BatteryDTO {
    private String name;
    private String postcode;
    private int capacity;

    public BatteryDTO() {
    }

    public BatteryDTO(String name, String postcode, int capacity) {
        this.name = name;
        this.postcode = postcode;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

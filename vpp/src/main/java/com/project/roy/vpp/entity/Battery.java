package com.project.roy.vpp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "battery")
public class Battery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(name = "post_code")
    private int postcode;
    @Column(name = "watt_capacity")
    private int wattCapacity;

    // Getters and setters

    public Battery() {
    }

    public Battery(String name, int postcode, int wattCapacity) {
        this.name = name;
        this.postcode = postcode;
        this.wattCapacity = wattCapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public int getWattCapacity() {
        return wattCapacity;
    }

    public void setWattCapacity(int wattCapacity) {
        this.wattCapacity = wattCapacity;
    }
}

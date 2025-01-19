package com.project.roy.vpp.repository;

import com.project.roy.vpp.entity.Battery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatteryRepository extends JpaRepository<Battery, Long> {
    List<Battery> findByPostcodeBetweenAndWattCapacityBetween(
            int minPostcode, int maxPostcode, int minWattCapacity, int maxWattCapacity);
}

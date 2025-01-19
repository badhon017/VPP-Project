package com.project.roy.vpp;

import com.project.roy.vpp.entity.Battery;
import com.project.roy.vpp.repository.BatteryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class BatteryRepositoryTest {

    @Autowired
    private BatteryRepository batteryRepository;

    @Test
    void testFindByPostCodeBetween() {
        Battery battery1 = new Battery("Battery1", 1000, 500);
        Battery battery2 = new Battery("Battery2", 1500, 300);
        Battery battery3 = new Battery("Battery3", 2000, 700);

        batteryRepository.saveAll(List.of(battery1, battery2, battery3));

        List<Battery> result = batteryRepository.findByPostcodeBetweenAndWattCapacityBetween(1000, 1800, 500, 700);

        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(b -> b.getName().equals("Battery1")));
        assertTrue(result.stream().anyMatch(b -> b.getName().equals("Battery2")));
    }
}
package com.project.roy.vpp;

import com.project.roy.vpp.dto.BatteryDTO;
import com.project.roy.vpp.entity.Battery;
import com.project.roy.vpp.repository.BatteryRepository;
import com.project.roy.vpp.service.BatteryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BatteryServiceTest {

    @InjectMocks
    private BatteryService batteryService;

    @Mock
    private BatteryRepository batteryRepository;

    @Test
    void testAddBatteries() {
        List<BatteryDTO> batteries = List.of(
                new BatteryDTO("Battery1", "1000", 500),
                new BatteryDTO("Battery2", "2000", 300)
        );

        batteryService.saveBatteries(batteries);
        verify(batteryRepository, times(1)).saveAll(anyList());
    }

    @Test
    void testGetBatteriesInPostcodeRange() {
        List<Battery> batteries = List.of(
                new Battery("Battery1", 1000, 500),
                new Battery("Battery2", 1200, 600)
        );

        when(batteryRepository.findByPostcodeBetweenAndWattCapacityBetween(1000, 1500,700,800)).thenReturn(batteries);

        List<Battery> result = batteryService.findBatteries(1000, 1500, 700, 800);

        assertEquals(2, result.size());
        assertEquals("Battery1", result.get(0).getName());
    }
}
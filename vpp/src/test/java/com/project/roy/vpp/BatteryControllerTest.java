package com.project.roy.vpp;

import com.project.roy.vpp.entity.Battery;
import com.project.roy.vpp.service.BatteryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BatteryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private BatteryService batteryService;

    @Test
    void testAddBatteries() throws Exception {
        String requestBody = """
                [
                    {"name": "Battery1", "postCode": 1000, "wattCapacity": 500},
                    {"name": "Battery2", "postCode": 2000, "wattCapacity": 300}
                ]
                """;

        mockMvc.perform(post("/api/batteries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().string("Batteries added successfully!"));
    }

    @Test
    void testGetBatteriesByPostCodeRange() throws Exception {
        List<Battery> batteries = List.of(
                new Battery("Battery1", 1000, 500),
                new Battery("Battery2", 1100, 600)
        );

        when(batteryService.findBatteries(1000, 1500,700, 800))
                .thenReturn(batteries);

        mockMvc.perform(get("/api/batteries/range")
                        .param("minPostCode", "1000")
                        .param("maxPostCode", "1500"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.batteries[0].name").value("Battery1"))
                .andExpect(jsonPath("$.batteries[1].name").value("Battery2"))
                .andExpect(jsonPath("$.totalWattCapacity").value(1100))
                .andExpect(jsonPath("$.averageWattCapacity").value(550.0));
    }
}
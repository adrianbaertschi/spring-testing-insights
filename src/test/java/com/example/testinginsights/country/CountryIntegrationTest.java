package com.example.testinginsights.country;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc // Prepares the MockMvc bean
public class CountryIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void end2endTesting() throws Exception {
        mockMvc.perform(get("/countries/CH"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Switzerland"));
    }
}

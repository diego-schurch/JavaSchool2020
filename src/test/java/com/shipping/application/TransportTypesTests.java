package com.shipping.application;

import com.shipping.application.controller.TransportTypeController;
import com.shipping.application.service.TransportTypeService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TransportTypeController.class)
public class TransportTypesTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TransportTypeService transportTypeService;

    @Test
    public void getAllTransportTypes() throws Exception {

        List<String> testData = Arrays.asList("Land");

        when(transportTypeService.getTransportTypes("Medium")).thenReturn(testData.stream());

        mvc.perform( MockMvcRequestBuilders
                .get("/transport/Medium")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*]").isNotEmpty());
    }
}

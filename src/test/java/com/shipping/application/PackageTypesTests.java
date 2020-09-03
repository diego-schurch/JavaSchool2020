package com.shipping.application;

import com.shipping.application.controller.PackageTypeController;
import com.shipping.application.service.PackageTypeService;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = PackageTypeController.class)
public class PackageTypesTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PackageTypeService packageTypeService;

    @Test
    public void getAllPackageTypes() throws Exception {

        List<String> testData = Arrays.asList("Box", "Envelop");

        when(packageTypeService.getPackageTypes()).thenReturn(testData);

        mvc.perform( MockMvcRequestBuilders
                .get("/type")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*]").isNotEmpty());
    }
}

package com.shipping.application;

import com.shipping.application.controller.PackageSizeController;
import com.shipping.application.service.PackageSizeService;

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

@WebMvcTest(controllers = PackageSizeController.class)
public class PackageSizesTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PackageSizeService packageSizeService;

    @Test
    public void getAllPackageSizes() throws Exception {

        List<String> testData = Arrays.asList("Small", "Medium", "Large");

        when(packageSizeService.getPackageSizes()).thenReturn(testData);

        mvc.perform( MockMvcRequestBuilders
                .get("/package/sizes")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*]").isNotEmpty());
    }
}

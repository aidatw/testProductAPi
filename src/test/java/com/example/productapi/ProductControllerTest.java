
package com.example.productapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.example.productapi.repository.ProductRepository;
import com.example.productapi.controller.ProductController; // Add this import statement
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void searchByKeyword_WithValidParameters_ShouldReturnOk() throws Exception {
        mockMvc.perform(get("/products")
                .param("keyword", "test")
                .param("page", "1")
                .param("size", "10"))
                .andExpect(status().isOk());
    }

    @Test
    public void searchByKeyword_WithNoParameters_ShouldReturnOk() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk());
    }
}
package com.v1lladev.ecommerce;

import com.v1lladev.ecommerce.domain.model.contants.PriceConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PriceIntegrationTests {

    @LocalServerPort
    private int port;

    String baseUrl = "http://localhost:";

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        baseUrl = baseUrl + port;
    }

    @ParameterizedTest(name = "Testing prices resource with: date {0}, productId {1}, brandId {2}, result expected: {3}")
    @MethodSource("providedTestUsecases")
    @DisplayName("Testing get prices by date, productId and brandId")
    void statementUsestests(LocalDateTime date, Long productId, Long brandId, Double priceExpected) throws Exception {

        String path = getFullPath(baseUrl, "date="+ date, "productId="+ productId, "brandId= "+ brandId);

        mockMvc.perform(MockMvcRequestBuilders.get(baseUrl + "/api/v1/prices" + path))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", equalTo(priceExpected)));
    }

    @Test
    @DisplayName("Testing invalid parameter")
    void invalidParameterExceptionTest() throws Exception {
        String expectedMessage = String.format(PriceConstants.VALIDATION_PARAMETER_ERROR,"productId", "test");

        String path = getFullPath(baseUrl, "date=2020-06-14T00:00:00", "productId=test", "brandId=1");

        mockMvc.perform(MockMvcRequestBuilders.get(baseUrl + "/api/v1/prices" + path))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error", equalTo(expectedMessage)));
    }

    @Test
    @DisplayName("Testing missing parameter")
    void missingParameterExceptionTest() throws Exception {
        String expectedMessage = "Required request parameter 'productId' for method parameter type Long is not present";

        String path = getFullPath(baseUrl, "date=2020-06-14T00:00:00", "", "brandId=1");

        mockMvc.perform(MockMvcRequestBuilders.get(baseUrl + "/api/v1/prices" + path))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error", equalTo(expectedMessage)));
    }

    private String getFullPath(String baseUrl, String... pathParameters){
        return String.format("?%s&%s&%s", pathParameters[0], pathParameters[1], pathParameters[2]);
    }

    private static Stream<Arguments> providedTestUsecases() {
        return Stream.of(
                Arguments.of(LocalDateTime.of(2020,6,14,10,0,0), 35455L, 1L, 35.50),
                Arguments.of(LocalDateTime.of(2020,6,14,16,0,0), 35455L, 1L, 25.45),
                Arguments.of(LocalDateTime.of(2020,6,14,21,0,0), 35455L, 1L, 35.50),
                Arguments.of(LocalDateTime.of(2020,6,15,10,0,0), 35455L, 1L, 30.50),
                Arguments.of(LocalDateTime.of(2020,6,16,21,0,0), 35455L, 1L, 38.95)
        );
    }
}

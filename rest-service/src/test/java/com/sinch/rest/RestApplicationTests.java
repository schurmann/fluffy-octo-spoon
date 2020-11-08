package com.sinch.rest;

import com.sinch.rest.exception.ServerException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class RestApplicationTests {

    @Autowired
    private PolishNotationRestService restService;

    @Test
    public void contextLoads() {
        assertNotNull(restService);
    }

    @Test
    public void shouldReturnResponse() {
        List<String> response = restService.evalutePolishNotation(List.of("+ 1 2"));
        assertEquals(1, response.size());
        assertEquals("3.00", response.get(0));
    }

    @Test
    public void shouldThrowExeptionWhenMalformedInput() {
        assertThrows(ServerException.class, () -> restService.evalutePolishNotation(List.of(". 1 2")));
    }

}

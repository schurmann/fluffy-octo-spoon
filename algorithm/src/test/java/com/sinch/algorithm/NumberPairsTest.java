package com.sinch.algorithm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Jonathan Schurmann on 11/7/20.
 */
class NumberPairsTest {

    private final NumberPairs numberPairs = new NumberPairs();

    private static Stream<Arguments> solveInput() {
        return Stream.of(
                Arguments.of(1, Integer.MAX_VALUE, List.of(Integer.MAX_VALUE - 1, 1)),
                Arguments.of(1, Integer.MIN_VALUE, List.of(Integer.MIN_VALUE + 1, -1)),
                Arguments.of(2, 6, List.of(2, 1, 4, 5, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("solveInput")
    void shouldHandleInput(long expected, int k, List<Integer> a) {
        long count = numberPairs.solve(k, a);
        assertEquals(expected, count);
    }

    @Test
    void shouldParseLines() {
        String input = "6\n" +
                "2\n" +
                "1\n" +
                "4\n" +
                "5\n" +
                "3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        List<Integer> parsedInput = numberPairs.parseInput(in);
        assertEquals(6, parsedInput.size());
    }

    @Test
    void shouldSkipBlankLines() {
        String input = "6\n" +
                "\n" +
                "5\n" +
                "3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        List<Integer> parsedInput = numberPairs.parseInput(in);
        assertEquals(3, parsedInput.size());
    }
}

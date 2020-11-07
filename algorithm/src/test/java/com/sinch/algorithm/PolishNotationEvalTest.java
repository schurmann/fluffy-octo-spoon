package com.sinch.algorithm;

import com.sinch.algorithm.exception.PolishNotationException;
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
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by Jonathan Schurmann on 11/7/20.
 */
class PolishNotationEvalTest {
    private final PolishNotationEval notationEval = new PolishNotationEval();

    private static Stream<Arguments> validInput() {
        return Stream.of(
                Arguments.of(42, "+ + 0.5 1.5 * 4 10"),
                Arguments.of(1337, "- 2e3 - 700 + 7 * 2 15"),
                Arguments.of(-12.50f, "- -1.5 * 3.1415 / -7 -2"),
                Arguments.of(100500, "100500")
        );
    }

    private static Stream<Arguments> invalidInput() {
        return Stream.of(
                Arguments.of("1 2"),
                Arguments.of("+ 1"));
    }


    @ParameterizedTest
    @MethodSource("validInput")
    void shouldSolveInput(float expected, String expression) {
        float result = notationEval.solve(expression);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("invalidInput")
    void shouldThrowException(String expression) {
        assertThrows(PolishNotationException.class, () -> notationEval.solve(expression));
    }

    @Test
    void shouldParseLines() {
        String input = "+ + 0.5 1.5 * 4 10\n" +
                "- 2e3 - 700 + 7 * 2 15\n" +
                "- -1.5 * 3.1415 / -7 -2\n" +
                "100500\n" +
                "1 2\n" +
                "+ 1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        List<String> parsedInput = notationEval.parseInput(in);
        assertEquals(6, parsedInput.size());
    }

    @Test
    void shouldSkipBlankLines() {
        String input = "6\n" +
                "\n" +
                "5\n" +
                "3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        List<String> parsedInput = notationEval.parseInput(in);
        assertEquals(3, parsedInput.size());
    }
}

package com.sinch.algorithm;

import com.sinch.algorithm.exception.PolishNotationException;
import com.sinch.algorithm.operation.Addition;
import com.sinch.algorithm.operation.Division;
import com.sinch.algorithm.operation.Multiplication;
import com.sinch.algorithm.operation.Operation;
import com.sinch.algorithm.operation.Subtraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by Jonathan Schurmann on 11/7/20.
 */
public class PolishNotationEval implements InputReader<List<String>> {
    private static final DecimalFormat df = new DecimalFormat("##.00");
    private static final Map<String, Operation<Double>> SUPPORTED_OPERATIONS = Map.of(
            "+", new Addition(),
            "-", new Subtraction(),
            "*", new Multiplication(),
            "/", new Division());


    public String solve(String expression) throws PolishNotationException {
        String[] tokens = expression.split(" ");
        Deque<Double> operands = new ArrayDeque<>();

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            Operation<Double> operation = SUPPORTED_OPERATIONS.get(token);
            if (operation != null) {
                try {
                    double op1 = operands.pop();
                    double op2 = operands.pop();
                    operands.push(operation.op(op1, op2));
                } catch (NoSuchElementException e) {
                    throw new PolishNotationException("Invalid input: " + expression);
                }
            } else {
                try {
                    operands.push(Double.parseDouble(token));
                } catch (NumberFormatException | NullPointerException e) {
                    throw new PolishNotationException(String.format("Invalid token: %s", token), e);
                }
            }
        }
        if (operands.size() > 1) {
            throw new PolishNotationException("Invalid input: " + expression);
        }
        return df.format(operands.pop());
    }

    @Override
    public List<String> parseInput(InputStream in) {
        List<String> inputArray = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
                inputArray.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputArray;
    }
}

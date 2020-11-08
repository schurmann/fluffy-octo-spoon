package com.sinch.algorithm.operation;

/**
 * Created by Jonathan Schurmann on 11/7/20.
 */
public class Multiplication implements Operation<Double> {
    @Override
    public Double op(Double op1, Double op2) {
        return op1 * op2;
    }
}

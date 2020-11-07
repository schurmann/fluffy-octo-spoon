package com.sinch.algorithm.operation;

/**
 * Created by Jonathan Schurmann on 11/7/20.
 */
public class Multiplication implements Operation<Float> {
    @Override
    public Float op(Float op1, Float op2) {
        return op1 * op2;
    }
}

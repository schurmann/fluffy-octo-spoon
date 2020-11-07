package com.sinch.algorithm.operation;

/**
 * Created by Jonathan Schurmann on 11/7/20.
 */
public interface Operation<T extends Number> {
    T op(T op1, T op2) throws ArithmeticException;
}

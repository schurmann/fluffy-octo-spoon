package com.sinch.algorithm;

import java.io.InputStream;

/**
 * Created by Jonathan Schurmann on 11/7/20.
 */
public interface InputReader<T> {
    T parseInput(InputStream in);
}

package com.sinch.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Jonathan Schurmann on 11/7/20.
 */
public class NumberPairs implements InputReader<List<Integer>> {
    public int solve(int k, List<Integer> a) {
        int count = 0;
        final var complements = new HashSet<>(a.size());
        for (int i : a) {
            if (complements.contains(i)) {
                count++;
            } else {
                complements.add(k - i);
            }
        }
        return count;
    }

    @Override
    public List<Integer> parseInput(InputStream in) {
        List<Integer> inputArray = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
                inputArray.add(Integer.parseInt(line));
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return inputArray;
    }
}

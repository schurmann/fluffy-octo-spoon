package com.sinch.algorithm;


import com.sinch.algorithm.exception.PolishNotationException;

import java.util.List;

/**
 * Created by Jonathan Schurmann on 11/7/20.
 */
public class Main {
    private static final String N_PAIRS = "n-pairs";
    private static final String POLISH_NOTATION = "polish";

    public static void main(String[] args) {
        if (args.length == 0) {
            printUsage();
        }
        String operation = args[0];
        if (!(operation.equals(N_PAIRS) || operation.equals(POLISH_NOTATION))) {
            printUsage();
        }
        if (operation.equals(N_PAIRS)) {
            NumberPairs numberPairs = new NumberPairs();
            List<Integer> input = numberPairs.parseInput(System.in);
            long count = numberPairs.solve(input.get(0), input.subList(1, input.size()));
            System.out.println(count);
        } else if (operation.equals(POLISH_NOTATION)) {
            PolishNotationEval notationEval = new PolishNotationEval();
            List<String> input = notationEval.parseInput(System.in);
            input.forEach(s -> {
                try {
                    var res = notationEval.solve(s);
                    System.out.println(res);
                } catch (PolishNotationException e) {
                    System.out.println("error");
                }
            });
        }
        System.exit(0);
    }

    private static void printUsage() {
        System.out.println(String.format("Usage: java -jar <jar> <%s|%s>", N_PAIRS, POLISH_NOTATION));
        System.exit(0);
    }

}

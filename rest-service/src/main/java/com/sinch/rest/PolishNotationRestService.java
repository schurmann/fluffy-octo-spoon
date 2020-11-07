package com.sinch.rest;

import com.sinch.algorithm.PolishNotationEval;
import com.sinch.algorithm.exception.PolishNotationException;
import com.sinch.rest.exception.ServerException;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jonathan Schurmann on 11/7/20.
 */
@RestController
public class PolishNotationRestService {
    private final Logger logger;

    public PolishNotationRestService(Logger logger) {
        this.logger = logger;
    }

    @GetMapping("/eval")
    public List<Float> evalutePolishNotation(@RequestParam(value = "expression") List<String> expressions) {
        PolishNotationEval notationEval = new PolishNotationEval();
        return expressions.stream().map(s -> {
                    try {
                        return notationEval.solve(s);
                    } catch (PolishNotationException e) {
                        logger.warn(e.getMessage());
                        throw new ServerException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
                    }
                }
        ).collect(Collectors.toList());
    }
}

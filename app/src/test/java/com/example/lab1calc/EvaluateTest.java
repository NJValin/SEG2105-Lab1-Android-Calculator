package com.example.lab1calc;

import static org.junit.Assert.*;

import org.junit.Test;

import javax.script.ScriptException;

public class EvaluateTest {

    @Test
    public void evaluate_add() throws ScriptException {
        Evaluate e = new Evaluate();
        double value = e.evaluate("8+8").doubleValue();
        double expectedValue = 16;
        assertEquals( "test addition failed",expectedValue,value, 1e-3);
    }

    @Test
    public void evaluate_Division() throws ScriptException {
        Evaluate e = new Evaluate();
        double value = e.evaluate("8/8").doubleValue();
        double expectedValue = 16;
        assertEquals( "test division failed",expectedValue,value, 1e-3);
    }

}

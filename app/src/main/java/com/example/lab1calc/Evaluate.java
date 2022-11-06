package com.example.lab1calc;

import org.mozilla.javascript.Script;

import java.math.BigDecimal;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Evaluate {
    private ScriptEngine script;
    Evaluate() {
        script = new ScriptEngineManager().getEngineByName("rhino");
    }

    public BigDecimal evaluate(String x) throws ScriptException {
        return new BigDecimal(script.eval(x).toString());
    }
}

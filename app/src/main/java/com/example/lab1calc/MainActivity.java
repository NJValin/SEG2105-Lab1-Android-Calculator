package com.example.lab1calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonAdd, buttonSub, buttonDiv, buttonClr, buttonEql, buttonMulti, buttonDec;
    TextView text_input_display;
    ScriptEngine script;
    boolean isDouble = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        script = new ScriptEngineManager().getEngineByName("rhino");
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button0 = (Button) findViewById(R.id.button0);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonSub = (Button) findViewById(R.id.buttonSub);
        buttonMulti = (Button) findViewById(R.id.buttonMulti);
        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonClr = (Button) findViewById(R.id.buttonClr);
        buttonDec = (Button) findViewById(R.id.buttonDec);
        buttonEql = (Button) findViewById(R.id.buttonEql);


        text_input_display = (TextView) findViewById(R.id.text_input_display);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMulti.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonDec.setOnClickListener(this);
        buttonClr.setOnClickListener(this);
        buttonEql.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                addNumber("1");
                //toCalculate.append("1");
                break;
            case R.id.button2:
                addNumber("2");
                //toCalculate.append("2");
                break;
            case R.id.button3:
                addNumber("3");
                //toCalculate.append("3");
                break;
            case R.id.button4:
                addNumber("4");
                //toCalculate.append("4");
                break;
            case R.id.button5:
                addNumber("5");
                //toCalculate.append("5");
                break;
            case R.id.button6:
                addNumber("6");
                //toCalculate.append("6");
                break;
            case R.id.button7:
                addNumber("7");
                //toCalculate.append("7");
                break;
            case R.id.button8:
                addNumber("8");
                //toCalculate.append("8");
                break;
            case R.id.button9:
                addNumber("9");
                //toCalculate.append("9");
                break;
            case R.id.button0:
                addNumber("0");
                break;
            case R.id.buttonAdd:
                addNumber("+");

                break;
            case R.id.buttonSub:
                addNumber("-");

                break;
            case R.id.buttonMulti:
                addNumber("*");
                break;
            case R.id.buttonDiv:
                addNumber("/");
                isDouble = true;
                break;
            case R.id.buttonDec:
                addNumber(".");
                isDouble = true;
                break;
            case R.id.buttonClr:
                Clear();
                break;
            case R.id.buttonEql:
                String x = (String)text_input_display.getText();


                try {
                    if (isDouble) {
                        Clear();
                        addNumber(evaluate(x));
                        break;
                    }
                    else {
                        Clear();
                        String temp = evaluate(x);
                        addNumber(temp.substring(0, temp.length()-2));
                    }
                }
                catch (ScriptException e) {
                    addNumber("Input Error");
                }
                break;
        }
    }
    private String evaluate(String toEval) throws ScriptException {
        return script.eval(toEval).toString();
    }

    private void addNumber(String number){
        text_input_display.setText(text_input_display.getText()+number);
    }

    private void Clear(){
        text_input_display.setText("");
        isDouble = false;
    }
}
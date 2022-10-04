package com.example.lab1calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonAdd, buttonSub, buttonDiv, buttonClr, buttonEql, buttonMulti, buttonDec;
    TextView text_input_display;
    String[] toEval = new String[25];

    private static String[] convertToPostfix(String[] in) {
        Stack<String> operators = new Stack<>();
        String[] pstFix = new String[25];
        int count =0;
        for (int i =0; i< in.length; i++) {
            if (in[i]==null) {
                break;
            }
            if (!(in[i].equals("*")) && !(in[i].equals("/")) && !(in[i].equals("+")) && !(in[i].equals("-"))) {
                pstFix[count++] = in[i];
            }
            else {
                if (operators.isEmpty()) {
                    operators.push(in[i]);
                }
                else if ((in[i].equals("+")|| in[i].equals("-")) && (operators.peek().equals("*") || operators.peek().equals("*"))) {
                    while (operators.isEmpty()==false) {
                        pstFix[count++] = operators.pop();
                    }
                    operators.push(in[i]);
                }
                else {
                    while (((in[i].equals("+")||in[i].equals("-")) && (operators.peek().equals("+")|| operators.peek().equals("-")))
                            || ((in[i].equals("*") || in[i].equals("/"))&& (operators.peek().equals("*")||
                            operators.peek().equals("/")))) {
                        pstFix[count++] = operators.pop();
                    }
                    operators.push(in[i]);
                }
            }
        }
        while (operators.isEmpty()==false) {
            pstFix[count++] = operators.pop();
        }
        return pstFix;
    }
    private static double evaluate(String[] expression) {
        String[] pstFix = convertToPostfix(expression);
        return 0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                addNumber("hi");
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
                //toCalculate.append("0");
                break;
            case R.id.buttonAdd:
                addNumber("+");
                //toCalculate.append("+");
                break;
            case R.id.buttonSub:
                addNumber("-");
                //toCalculate.append("-");
                break;
            case R.id.buttonMulti:
                addNumber("\u00D7");
                //toCalculate.append("*");
                break;
            case R.id.buttonDiv:
                addNumber("\u00F7");
                //toCalculate.append("/");
                break;
            case R.id.buttonDec:
                addNumber(".");
                break;
            case R.id.buttonClr:
                Clear();
                break;
            case R.id.buttonEql:
                addNumber("=");
                break;
        }
    }


    private void addNumber(String number){
        text_input_display.setText(text_input_display.getText()+number);
    }

    private void Clear(){
        text_input_display.setText("");
    }
}
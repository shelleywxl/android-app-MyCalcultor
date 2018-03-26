package com.example.android.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonAdd, buttonSub, buttonMul, buttonDiv;
    private TextView textViewResult;
    private EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        buttonAdd =(Button)findViewById(R.id.buttonAdd);
        buttonSub = (Button)findViewById(R.id.buttonSub);
        buttonMul = (Button)findViewById(R.id.buttonMul);
        buttonDiv = (Button)findViewById(R.id.buttonDiv);
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 =(EditText)findViewById(R.id.editText2);
        textViewResult = (TextView)findViewById(R.id.textViewResult);

        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String num1 = editText1.getText().toString();
        String num2 = editText2.getText().toString();

        switch(view.getId()){
            case R.id.buttonAdd:
                if (num1==null || num1.trim().equals("") || num2==null || num2.trim().equals("")) {
                    textViewResult.setText("Error! Need two numbers to do operation.");
                } else {
                    float addition = Float.parseFloat(num1) + Float.parseFloat(num2);
                    //textViewResult.setText(String.valueOf(addition));
                    textViewResult.setText(String.format("%.2f", addition));
                }
                break;

            case R.id.buttonSub:
                if (num1.length() == 0 || num2.length() == 0) {
                    textViewResult.setText("Error! Need two numbers to do operation.");
                } else {
                    float subtraction = Float.parseFloat(num1) - Float.parseFloat(num2);
                    //textViewResult.setText(String.valueOf(subtraction));
                    textViewResult.setText(String.format("%.2f", subtraction));
                }
                break;

            case R.id.buttonMul:
                if (num1.length() == 0 || num2.length() == 0) {
                    textViewResult.setText("Error! Need two numbers to do operation.");
                } else {
                    float multiply = Float.parseFloat(num1) * Float.parseFloat(num2);
                    //textViewResult.setText(String.valueOf(multiply));
                    textViewResult.setText(String.format("%.2f", multiply));
                }
                break;

            case R.id.buttonDiv:
                if (num1.length() == 0 || num2.length() == 0) {
                    textViewResult.setText("Error! Need two numbers to do operation.");
                } else { //return "Infinity" as a float value. If the data type is integer, it will return error.
                    try {
                        float division = Float.parseFloat(num1) / Float.parseFloat(num2);
                        //textViewResult.setText(String.valueOf(division));
                        textViewResult.setText(String.format("%.2f", division));
                    } catch (Exception e) {
                        textViewResult.setText("Error! Cannot divide.");
                    }
                }
                break;

        }
    }
}

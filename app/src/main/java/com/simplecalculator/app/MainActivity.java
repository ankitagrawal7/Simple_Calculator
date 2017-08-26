package com.simplecalculator.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnAdd,btnsub,btndivide,btnmul;
    private TextView result,txtView;

    private EditText etfirst,etsecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        btnAdd =(Button)findViewById(R.id.btnAdd);
        btnsub = (Button)findViewById(R.id.btnSubtract);
        btndivide = (Button)findViewById(R.id.btnDivide);
        btnmul = (Button)findViewById(R.id.btnMultiply);
        etfirst = (EditText)findViewById(R.id.etFN);
        etsecond =(EditText)findViewById(R.id.etSN);
        result = (TextView)findViewById(R.id.result);
        txtView=(TextView)findViewById(R.id.txtView);

        btnAdd.setOnClickListener(this);
        btnsub.setOnClickListener(this);
        btndivide.setOnClickListener(this);
        btnmul.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        txtView.setText("Result:");
        String num1 = etfirst.getText().toString();
        String num2 = etsecond.getText().toString();
        switch(view.getId()){
            case R.id.btnAdd:
                if (num1.matches("")){ num1 = "0"; }
                if (num2.matches("")){ num2 = "0"; }
                double addition = Double.parseDouble(num1) + Double.parseDouble(num2);
                result.setText(String.valueOf(addition));
                break;
            case R.id.btnSubtract:
                if (num1.matches("")){ num1 = "0"; }
                if (num2.matches("")){ num2 = "0"; }
                double subtraction = Double.parseDouble(num1) - Double.parseDouble(num2);
                result.setText(String.valueOf(subtraction));
                break;
            case R.id.btnDivide:
                if (num1.matches("")){ num1 = "1"; }
                if (num2.matches("")){ num2 = "1"; }
                try{
                    double division = Double.parseDouble(num1) / Double.parseDouble(num2);
                    if (Double.isInfinite(division)) {
                        result.setText("Cannot Divide!");
                    } else {
                        result.setText(String.valueOf(division));
                    }
                }catch(Exception e){
                    result.setText("Cannot Divide!");
                }
                break;
            case R.id.btnMultiply:
                if (num1.matches("")){ num1 = "1"; }
                if (num2.matches("")){ num2 = "1"; }
                double multiply = Double.parseDouble(num1) * Double.parseDouble(num2);
                result.setText(String.valueOf(multiply));
                break;
        }
    }
}

package com.romannumberconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_convert_roman, btn_convert_number;
    TextView tv_roman_output, tv_number_output;
    EditText et_roman, et_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_convert_number = (Button) findViewById(R.id.btn_convert_number);
        btn_convert_roman = (Button) findViewById(R.id.btn_convert_roman);
        et_number = (EditText) findViewById(R.id.et_number);
        et_roman = (EditText) findViewById(R.id.et_roman);
        tv_number_output = (TextView) findViewById(R.id.tv_number_output);
        tv_roman_output = (TextView) findViewById(R.id.tv_roman_output);

        final NumberConverter nc = new NumberConverter();

        btn_convert_roman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int number = Integer.parseInt(et_number.getText().toString());
                tv_roman_output.setText(nc.toRoman(number));

            }
        });

        btn_convert_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = et_roman.getText().toString();
                String x = number;
                if (x == null || x == "") {
                    tv_number_output.setText("No Input Entered!");
                } else {
                    int y = nc.toNumber(x);
                    tv_number_output.setText(String.valueOf(y));
                }
            }
        });

    }
}

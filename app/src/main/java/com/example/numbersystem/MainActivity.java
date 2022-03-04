package com.example.numbersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static EditText input_top;
    private static EditText input_bottom;

    private static int input_number_system = 10;
    private static int output_number_system = 2;

    private static RadioGroup group_input;
    private static RadioGroup group_output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_top =  findViewById(R.id.input_top);
        input_bottom = findViewById(R.id.input_bottom);

        group_input = findViewById(R.id.group_from);
        group_output = findViewById(R.id.group_to);

        group_input.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.from_2:
                        input_number_system = 2;
                        break;
                    case R.id.from_8:
                        input_number_system = 8;
                        break;
                    case R.id.from_10:
                        input_number_system= 10;
                        break;
                    case R.id.from_16:
                        input_number_system= 16;
                        break;
                }
                recalculate();
            }
        });

        group_output.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.in_2:
                        output_number_system = 2;
                        break;
                    case R.id.in_8:
                        output_number_system = 8;
                        break;
                    case R.id.in_10:
                        output_number_system = 10;
                        break;
                    case R.id.in_16:
                        output_number_system = 16;
                        break;
                }
                recalculate();
            }
        });

        input_top.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                recalculate();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public static void recalculate() {
        if (input_top.getText().toString().isEmpty()) {
            return;
        }

        try {
            int LastNumber = Integer.parseInt(input_top.getText().toString().toUpperCase(Locale.ROOT), input_number_system);
            input_bottom.setText(Integer.toString(LastNumber, output_number_system).toUpperCase(Locale.ROOT));
        } catch (NumberFormatException exception) {
            Log.e ("ERROR", "Invalid input");
        }
    }
}
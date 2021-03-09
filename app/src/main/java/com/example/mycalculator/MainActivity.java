package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mycalculator.R;

public class MainActivity extends AppCompatActivity {

    // member declare
    private TextView resultsTV;
    private TextView workingsTV;

    private String input = "";
    private String workings = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        // init text views
        this.resultsTV = findViewById(R.id.results_text);
        this.workingsTV = findViewById(R.id.workings_text);
    }

    public void setResultsTV(String givenValue) {
        resultsTV.setText(givenValue);
    }

    public void setWorkingsTV(String givenValue) {
        workingsTV.setText(givenValue + "=");
    }

    public void clicked(View v) {

        switch (v.getId()) {
            case R.id.button_zero:
                input += "0";
                break;

            case R.id.button_one:
                input += "1";
                break;

            case R.id.button_two:
                input += "2";
                break;

            case R.id.button_three:
                input += "3";
                break;

            case R.id.button_four:
                input += "4";
                break;

            case R.id.button_five:
                input += "5";
                break;

            case R.id.button_six:
                input += "6";
                break;

            case R.id.button_seven:
                input += "7";
                break;

            case R.id.button_eight:
                input += "8";
                break;

            case R.id.button_nine:
                input += "9";
                break;

            case R.id.button_add:
                calculate();
                input += "+";
                break;

            case R.id.button_sub:
                calculate();
                input += "-";
                break;

            case R.id.button_mul:
                calculate();
                input += "*";
                break;

            case R.id.button_div:
                calculate();
                input += "/";
                break;

            case R.id.button_equal:
                calculate();
                setWorkingsTV(workings);
                break;

            case R.id.button_clear:
                input = "";
                workings = "";
                workingsTV.setVisibility(View.INVISIBLE);
                break;
        }
        setResultsTV(input);
        workings = input;
    }

    public void calculate() {
        if (input.split("\\*").length == 2) {
            String numbers[] = input.split("\\*");
            try {
                int mul = Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]);
                input = Integer.toString(mul);
                ;
            } catch (Exception e) {
                // Toggle error
            }
        } else if (input.split("/").length == 2) {
            String numbers[] = input.split("/");
            try {
                int div = Integer.parseInt(numbers[0]) / Integer.parseInt(numbers[1]);
                input = Integer.toString(div);
            } catch (Exception e) {
                // Toggle error
            }
        } else if (input.split("\\+").length == 2) {
            String numbers[] = input.split("\\+");
            try {
                int sum = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
                input = Integer.toString(sum);
                ;
            } catch (Exception e) {
                // Toggle error
            }
        } else if (input.split("-").length == 2) {
            String numbers[] = input.split("-");
            try {
                int sub = Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[1]);
                input = Integer.toString(sub);
                ;
            } catch (Exception e) {
                // Toggle error
            }
        }
        setResultsTV(input);
        workingsTV.setVisibility(View.VISIBLE);
    }
}
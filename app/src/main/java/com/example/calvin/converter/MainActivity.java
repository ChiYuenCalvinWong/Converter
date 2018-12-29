package com.example.calvin.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private TextView output;
    private TextView history;
    private Boolean ForC = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.input);
        output = findViewById(R.id.output);
        history = findViewById(R.id.history);

        history.setMovementMethod(new ScrollingMovementMethod());
    }

    public void CtoF(View v){
        ForC = false;
    }

    public void FtoC(View v){
        ForC = true;
    }

    public void onClick(View v){
        double result = 0;
        String addhistory = history.getText().toString();

        if(ForC){
            result = (Double.parseDouble(input.getText().toString()) - 32) / 1.8;
            addhistory = "F to C: " + input.getText().toString() + " -> " + String.format("%.1f",result) + "\n" + addhistory;
            history.setText(addhistory);
            output.setText(String.format("%.1f",result));
        }else{
            result = (Double.parseDouble(input.getText().toString()) * 1.8) + 32;
            addhistory = "C to F: " + input.getText().toString() + " -> " + String.format("%.1f",result) + "\n" + addhistory;
            history.setText(addhistory);
            output.setText(String.format("%.1f",result));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("INPUT",input.getText().toString());
        outState.putString("OUTPUT",output.getText().toString());
        outState.putString("HISTORY", history.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        history.setText(savedInstanceState.getString("HISTORY"));
        input.setText(savedInstanceState.getString("INPUT"));
        output.setText(savedInstanceState.getString("OUTPUT"));
    }
}

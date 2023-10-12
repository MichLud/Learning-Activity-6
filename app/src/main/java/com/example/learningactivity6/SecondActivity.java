package com.example.learningactivity6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView textViewSummary;
    private Button buttonReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewSummary = findViewById(R.id.textViewSummary);
        buttonReturn = findViewById(R.id.buttonReturn);

        provideSummary();
    }

    private void provideSummary() {
        Intent intent = getIntent();
        String widthStr = intent.getStringExtra("width");
        String lengthStr = intent.getStringExtra("length");

        double width = Double.parseDouble(widthStr);
        double length = Double.parseDouble(lengthStr);

        double flooringNeeded = width * length;

        textViewSummary.setText("Room Width: " + widthStr + " m\nRoom Length: " + lengthStr + " m\nTotal Flooring Needed: " + flooringNeeded + " sq.m");

        buttonReturn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Send the result back to the main activity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("flooringNeeded", flooringNeeded);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
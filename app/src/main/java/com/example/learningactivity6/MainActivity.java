package com.example.learningactivity6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextWidth, editTextLength;
    private Button buttonShowResults;
    private TextView textViewMainSummary;

    // Define a constant for the request code
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWidth = findViewById(R.id.editTextWidth);
        editTextLength = findViewById(R.id.editTextLength);
        buttonShowResults = findViewById(R.id.buttonShowResults);
        textViewMainSummary = findViewById(R.id.textViewMainSummary);

        setUpButton();
    }
    private void setUpButton() {
        buttonShowResults.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String widthStr = editTextWidth.getText().toString();
                String lengthStr = editTextLength.getText().toString();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("width", widthStr);
                intent.putExtra("length", lengthStr);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                double flooringNeeded = data.getDoubleExtra("flooringNeeded", 0.0);
                textViewMainSummary.setText("Total Flooring Needed: " + flooringNeeded + " sq.m");
            }
        }
    }
}
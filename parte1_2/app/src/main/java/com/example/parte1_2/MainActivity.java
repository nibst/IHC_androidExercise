package com.example.parte1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.editTextText); // ID from component
    }
    public void Send(View view)
    {
        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("data", text.getText().toString());
        startActivity(i);
    }
}
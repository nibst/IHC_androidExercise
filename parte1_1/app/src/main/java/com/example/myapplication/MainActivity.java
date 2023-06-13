package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText et1;
    private EditText et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.editTextNumberDecimal); // ID from component
        et2 = (EditText) findViewById(R.id.editTextNumberDecimal2);
// The activity is created
    }
    @Override
    protected void onStart() {
        super.onStart();
// The activity is about to become visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
//The activity has become visible (now it "resumes").
    }
    @Override
    protected void onPause() {
        super.onPause();
// Focus on another activity (this activity is about to be "stopped").
    }
    @Override
    protected void onStop() {
        super.onStop();
// The activity is no longer visible (now it is "stopped")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
// The activity is about to be destroyed.
    }
    public void sum(View view)
    {
        Toast.makeText(this, "Value: " + et1.getText().toString(), Toast.LENGTH_SHORT).show();
        TextView txtView = (TextView) findViewById(R.id.textView); // ID from component
        float sum = Float.parseFloat(et1.getText().toString()) + Float.parseFloat(et2.getText().toString());
        txtView.setText("Result: "+sum);
    }
}
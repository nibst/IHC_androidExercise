package com.example.parte1_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    TextView coordinateX, coordinateY,coordinateZ;
    private final float defaultSensorValue = -1000;
    private float sensorX=defaultSensorValue,sensorY=defaultSensorValue,sensorZ=defaultSensorValue;
    private final float significantChange = 8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        coordinateX = (TextView) findViewById(R.id.editTextText2);
        coordinateY = (TextView) findViewById(R.id.editTextText3);;
        coordinateZ = (TextView) findViewById(R.id.editTextText4);


    }
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()== Sensor.TYPE_ACCELEROMETER) {

            float newSensorX = event.values[0];
            float newSensorY = event.values[1];
            float newSensorZ = event.values[2];
            coordinateX.setText(String.valueOf(newSensorX));
            coordinateY.setText(String.valueOf(newSensorY));
            coordinateZ.setText(String.valueOf(newSensorZ));
            //test with sensor if isnt default(initial) value
            if ((sensorX != defaultSensorValue) && (sensorY != defaultSensorValue) && (sensorZ != defaultSensorValue))
                if (isSignificantChange(newSensorX,newSensorY,newSensorZ)){
                    Intent i = new Intent(this, MainActivity2.class);
                    startActivity(i);
                }
            sensorX = event.values[0];
            sensorY = event.values[1];
            sensorZ = event.values[2];

        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
    }
    private boolean isSignificantChange(float newSensorX, float newSensorY, float newSensorZ){
        if (Math.abs(newSensorX - sensorX) >= significantChange){
            return true;
        }

        if (Math.abs(newSensorY - sensorY) >= significantChange){
            return true;
        }

        if (Math.abs(newSensorZ - sensorZ) >= significantChange){
            return true;
        }
        return false;


    }
}
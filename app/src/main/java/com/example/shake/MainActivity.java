package com.example.shake;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.squareup.seismic.ShakeDetector;

public class MainActivity extends AppCompatActivity implements ShakeDetector.Listener
{
int count=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SensorManager sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        ShakeDetector shakeDetector=new ShakeDetector(this);
        shakeDetector.start(sensorManager);
    }

    @Override
    public void hearShake() {
        count++;
       if(count%2==0){
           getWindow().getDecorView().setBackgroundColor(Color.BLUE);
       }
       else
           getWindow().getDecorView().setBackgroundColor(Color.MAGENTA);
    }
}

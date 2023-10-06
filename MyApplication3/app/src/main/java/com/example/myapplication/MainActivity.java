package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<Button> boutons = new ArrayList<>();

    int positionDuLapin;
    int pafs = 0;
    int flops = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        boutons.add(binding.b1);
        boutons.add(binding.b2);
        boutons.add(binding.b3);
        boutons.add(binding.b4);
        boutons.add(binding.b5);
        boutons.add(binding.b6);

        bougeLeLapin();

        for (Button b: boutons){
            b.setOnClickListener(v -> {
                reagitClick(v);
            });
        }
    }

    private void reagitClick(View v) {
        Button boutonDuLapin = boutons.get(positionDuLapin);
        if (v == boutonDuLapin){
            Log.i("TAPELAPIN", "Bravo tape le lapin");
            pafs++;
            updatescore();
        }
        else{
            Log.i("TAPELAPIN", "Ouch tape une taupe");
            flops++;
            updatescore();
        }
    }

    private void bougeLeLapin(){
        for (Button b : boutons){
            b.setText("taupe");

        }
        Random random = new Random();
        positionDuLapin = random.nextInt(6);
        Button b = boutons.get(positionDuLapin);
        b.setText("lapin");
    }
    private void updatescore(){
        binding.flops.setText(flops + "pafs");
        binding.pafs.setText(pafs + "flops" );
    }
}
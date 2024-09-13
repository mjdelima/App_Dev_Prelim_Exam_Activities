package com.cardinal.prelimexamactivities;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.cardinal.prelimexamactivities.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        binding.btnSumofOddEven.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SumOddEven.class));
        });

        binding.btnArmStrong.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ArmstrongNumber.class));
        });

        binding.btnPrime.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, PrimeNumber.class));
        });

        binding.btnArraySum.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SumofArray.class));
        });

        binding.btnVowelCounter.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, VowelCounter.class));
        });


    }

}

package com.cardinal.prelimexamactivities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.cardinal.prelimexamactivities.databinding.PrimeNumberBinding;

public class PrimeNumber extends AppCompatActivity {

    PrimeNumberBinding binding;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = PrimeNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        binding.btnCheckPrime.setOnClickListener(v -> {
            int number = Integer.parseInt(binding.etPrimeNumber.getText().toString());
            boolean isPrime = true;

            for(int i=2; i<number; i++){
                if(number % i == 0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime){
                binding.tvResult.setText("The Given Number is a Prime Number");
            }else{
                binding.tvResult.setText("The Given Number is not a Prime Number");
            }

        });

    }
}
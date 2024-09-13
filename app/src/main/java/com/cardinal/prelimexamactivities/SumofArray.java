package com.cardinal.prelimexamactivities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.cardinal.prelimexamactivities.databinding.SumofArrayBinding;

public class SumofArray extends AppCompatActivity {

    SumofArrayBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = SumofArrayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.btnCalculate.setOnClickListener(v -> {
            String input = binding.etArrayInput.getText().toString().replace(" ", "");

            try {
                String[] numbers = input.split(",");
                int sum = 0;

                for (String number : numbers) {
                    sum += Integer.parseInt(number);
                }

                binding.tvResult.setText("Sum of all numbers: " + sum);
            }catch (Exception e){
                binding.tvResult.setText("Invalid Input");
            }

        });


    }
}
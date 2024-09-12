package com.cardinal.prelimexamactivities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.cardinal.prelimexamactivities.databinding.ArmstrongNumberBinding;

public class ArmstrongNumber extends AppCompatActivity {
    ArmstrongNumberBinding binding;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ArmstrongNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.btnCheck.setOnClickListener(v -> {
            String input = binding.etArmstrongInput.getText().toString();

            int sum = 0;

            for(int i = 0; i < input.length(); i++){
                int num = Integer.parseInt(String.valueOf(input.charAt(i)));
                sum += (int) Math.pow(num, input.length());
            }

            Toast.makeText(this, "Calculated value: " + sum, Toast.LENGTH_SHORT).show();
            if(sum == Integer.parseInt(input)){
                binding.tvResult.setText("The Given Number is an Armstrong Number");
            }else{
                binding.tvResult.setText("The Given Number is not an Armstrong Number");
            }






        });



    }
}
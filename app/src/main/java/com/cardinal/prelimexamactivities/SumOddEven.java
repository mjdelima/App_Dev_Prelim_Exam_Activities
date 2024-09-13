package com.cardinal.prelimexamactivities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.cardinal.prelimexamactivities.databinding.SumOddEvenBinding;

public class SumOddEven extends AppCompatActivity {
    SumOddEvenBinding binding;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = SumOddEvenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        binding.btnCalculate.setOnClickListener(v -> {
            String input = binding.etArrayInput.getText().toString().replace(" ", "");

            String[] numbers;

            try {
                numbers = input.split(",");
                int sumOdd = 0;
                int sumEven = 0;

                /*
                for (String numStr : numbers) {
                    int num = Integer.parseInt(numStr);
                    if (num % 2 == 0) {
                        sumEven += num;
                    } else {
                        sumOdd += num;
                    }
                }
                 */

                for(int i = 0; i < numbers.length; i++){
                    int num = Integer.parseInt(numbers[i]);
                    if(num % 2 == 0){
                        sumEven += num;
                    }else{
                        sumOdd += num;
                    }
                }

                binding.tvResult.setText("Sum of all Odd numbers: " + sumOdd + "\n" +
                        "Sum of all Even numbers: " + sumEven);
            }catch (Exception e){
                binding.tvResult.setText("Invalid Input");
            }
        });




    }
}
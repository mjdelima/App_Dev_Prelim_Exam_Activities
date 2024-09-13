package com.cardinal.prelimexamactivities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.cardinal.prelimexamactivities.databinding.VowelCounterBinding;

public class VowelCounter extends AppCompatActivity {
    VowelCounterBinding binding;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = VowelCounterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.btnSubmit.setOnClickListener(v -> {
            String input = binding.etWordInput.getText().toString().toLowerCase();
            int count = 0;
            for(int i = 0; i < input.length(); i++){
                if(input.charAt(i) == 'a' || input.charAt(i) == 'e' ||
                        input.charAt(i) == 'i'|| input.charAt(i) == 'o'||
                        input.charAt(i) == 'u'){
                    count++;
                }
            }

            binding.tvResult.setText("The number of vowels in the given string is: " + count);
        });
    }
}

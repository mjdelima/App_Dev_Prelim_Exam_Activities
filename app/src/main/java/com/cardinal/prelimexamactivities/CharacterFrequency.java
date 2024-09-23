package com.cardinal.prelimexamactivities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.cardinal.prelimexamactivities.databinding.CharacterFrequencyBinding;

public class CharacterFrequency extends AppCompatActivity {

    CharacterFrequencyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = CharacterFrequencyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.btnSubmit.setOnClickListener(v -> {
            String stringInput = binding.etStringInput.getText().toString();
            int[] frequency = new int[26];

            //COUNTING OF FREQUENCY
            for (int i = 0; i < stringInput.length(); i++) {
                char c = stringInput.charAt(i);
                if (Character.isLetter(c)) {
                    int index = Character.toLowerCase(c) - 'a';
                    frequency[index]++;
                }
            }

            //USING STRING BUILDER
        /*
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                char c = (char) ('a' + i);

                if (frequency[i] > 0) {
                    result.append(c).append(": ").append(frequency[i]).append("\n");
                }
            }
        */

            //PREPARING THE OUTPUT
            //USING A USUAL STRING
            String result = "";
            for (int i = 0; i < 26; i++) {
                char c = (char) ('a' + i);
                if (frequency[i] > 0) {
                    result += c + ": " + frequency[i] + "\n";
                }
            }

            binding.tvResult.setText(result.toString());
        });
    }
}
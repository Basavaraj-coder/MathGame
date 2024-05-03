package com.example.fullvideoview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.fullvideoview.databinding.ActivitySelectLevelBinding;

public class selectLevelActivity extends AppCompatActivity {
    Handler obj1 = new Handler();
    int delay = 1500;
    ActivitySelectLevelBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectLevelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        obj1.postDelayed(new Runnable() {
            @Override
            public void run() {
                int strokeColor = ContextCompat.getColor(selectLevelActivity.this, R.color.yellow);
                binding.level1btn.setStrokeColor(ColorStateList.valueOf(strokeColor));
            }
        },delay);

        obj1.postDelayed(new Runnable() {
            @Override
            public void run() {
                int strokeColor = ContextCompat.getColor(selectLevelActivity.this, R.color.yellow);
                binding.level2btn.setStrokeColor(ColorStateList.valueOf(strokeColor));
            }
        },delay);

        obj1.postDelayed(new Runnable() {
            @Override
            public void run() {
                int strokeColor = ContextCompat.getColor(selectLevelActivity.this, R.color.yellow);
                binding.level3btn.setStrokeColor(ColorStateList.valueOf(strokeColor));
            }
        },delay);

        obj1.postDelayed(new Runnable() {
            @Override
            public void run() {
                int strokeColor = ContextCompat.getColor(selectLevelActivity.this, R.color.yellow);
                binding.level4btn.setStrokeColor(ColorStateList.valueOf(strokeColor));
            }
        },delay);

        binding.level1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(selectLevelActivity.this, MainActivity.class));
            }
        });

        binding.level2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(selectLevelActivity.this,substractionTutorActivity.class));
            }
        });

        binding.level3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(selectLevelActivity.this, multiplicationTutorActivity.class));
            }
        });

        binding.level4btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(selectLevelActivity.this,divisionTutorActivity.class));
            }
        });

        binding.level5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(selectLevelActivity.this,memoryGameActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        finishAffinity();
    }
}
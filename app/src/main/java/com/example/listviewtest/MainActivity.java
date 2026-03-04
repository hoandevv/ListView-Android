package com.example.listviewtest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnBai1;
    Button btnBai2;
    Button btnBai3;
    Button btnBai4;
    Button btnBai5;
    Button btnBai6;
    Button btnBai7;
    Button btnBai8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
    }
    private void initViews() {
        btnBai1 = findViewById(R.id.btnBai1);
        btnBai2 = findViewById(R.id.btnBai2);
        btnBai3 = findViewById(R.id.btnBai3);
        btnBai4 = findViewById(R.id.btnBai4);
        btnBai5 = findViewById(R.id.btnBai5);
        btnBai6 = findViewById(R.id.btnBai6);
        btnBai7 = findViewById(R.id.btnBai7);
        btnBai8 = findViewById(R.id.btnBai8);
    }
    private void initListeners() {
        btnBai1.setOnClickListener(v -> openActivity(Bai1Activity.class));
        btnBai2.setOnClickListener(v -> openActivity(Bai2Activity.class));
        btnBai3.setOnClickListener(v -> openActivity(Bai3Activity.class));
        btnBai4.setOnClickListener(v -> openActivity(Bai4Activity.class));
        btnBai5.setOnClickListener(v -> openActivity(Bai5Activity.class));
        btnBai6.setOnClickListener(v -> openActivity(Bai6Activity.class));
        btnBai7.setOnClickListener(v -> openActivity(Bai7Activity.class));
        btnBai8.setOnClickListener(v -> openActivity(Bai8Activity.class));
    }
    private void openActivity(Class<?> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}
package com.example.listviewtest;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
    /**
     * Hiển thị ProgressBar dạng xoay tròn (indeterminate)
     * và dạng thanh tiến trình (determinate),
     * kèm nút Start để bắt đầu tăng mức tiến trình*/
public class Bai5Activity extends AppCompatActivity {
    ProgressBar progressBarCircle, progressBarHorizontal;

    TextView tvPercent;
    Button BtnStart;
    int progressStatus = 0;
    Handler handler = new Handler(); // Handler để cập nhật giao diện từ luồng khác


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai5);
        progressBarCircle = findViewById(R.id.progressBarCircle);
        progressBarHorizontal = findViewById(R.id.progressBarHorizontal);
        tvPercent = findViewById(R.id.tvPercent);
        BtnStart = findViewById(R.id.BtnStart);

        progressBarCircle.setVisibility(View.GONE);

        BtnStart.setOnClickListener(v -> {
            progressStatus = 0;
            progressBarCircle.setVisibility(View.VISIBLE);
            new Thread(() -> {
                while (progressStatus < 100) {
                    progressStatus += 1; // Tăng tiến độ
                    handler.post(() -> {
                        progressBarCircle.setProgress(progressStatus);
                        progressBarHorizontal.setProgress(progressStatus);
                        tvPercent.setText(progressStatus + "%");
                    });
                    try {
                        Thread.sleep(100); // Giả lập thời gian tải
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                handler.post(() -> {
                    progressBarCircle.setVisibility(View.GONE);
                    BtnStart.setEnabled(true);
                });
            }).start();
        });
    }
}
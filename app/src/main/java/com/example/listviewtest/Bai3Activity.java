package com.example.listviewtest;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

/**Yêu cầu:
 * Click vào EditText ngày → mở DatePickerDialog → chọn xong hiển thị vào EditText
 * Click vào EditText giờ → mở TimePickerDialog → chọn xong hiển thị vào EditText
 */
public class Bai3Activity extends AppCompatActivity {

    EditText edtNgay, edtGio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai3);

        // Ánh xạ view
        edtNgay = findViewById(R.id.edtNgay);
        edtGio = findViewById(R.id.edtGio);

        Calendar calendar = Calendar.getInstance();

        // Sự kiện click chọn ngày
        edtNgay.setOnClickListener(v -> {
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(
                    Bai3Activity.this,
                    (view, year1, month1, dayOfMonth) -> {
                        month1 ++;
                        edtNgay.setText(dayOfMonth + "/" + month1 + "/" + year1);
                    },
                    year, month, day
            );

            dialog.show();
        });

        // Sự kiện click chọn giờ
        edtGio.setOnClickListener(v -> {

            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            TimePickerDialog dialog = new TimePickerDialog(
                    Bai3Activity.this,
                    (view, hourOfDay, minute1) -> {
                        // Format 2 chữ số
                        String time = String.format("%02d:%02d", hourOfDay, minute1);
                        edtGio.setText(time);
                    },
                    hour, minute, true
            );

            dialog.show();
        });
    }
}
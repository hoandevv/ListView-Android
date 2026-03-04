package com.example.listviewtest;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;

/**Yêu cầu

        Nhập nội dung công việc

        Chọn ngày (DatePickerDialog)

        Chọn giờ (TimePickerDialog)

        Nhấn Thêm → hiển thị xuống ListView
        */
public class Bai4Activity extends AppCompatActivity {
    EditText editNoiDung, editNgay, editGio;
    Button btnThem;
    ListView lvCongViec;
    ArrayList<String> listCV;
    ArrayAdapter<String> adapter;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai4);
        editNoiDung = findViewById(R.id.editNoiDung);
        editNgay = findViewById(R.id.editNgay);
        editGio = findViewById(R.id.editGio);
        btnThem = findViewById(R.id.btnThem);
        lvCongViec = findViewById(R.id.lvCongViec);

        calendar = Calendar.getInstance();
        listCV = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                listCV
        );
        lvCongViec.setAdapter(adapter);

        //chọn ngày
        editNgay.setOnClickListener(v -> {
            new DatePickerDialog(this, (view, year, month, day) -> {
                month ++; // Month bắt đầu từ 0
                editNgay.setText(day + "/" + month + "/" + year);
            }, calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                      calendar.get(Calendar.DAY_OF_MONTH)).show();
        });
        //chọn giờ
        editGio.setOnClickListener(v -> {
            new TimePickerDialog(this, (view, hourOfDay, minute) -> {
                String time = String.format("%02d:%02d", hourOfDay, minute);
                editGio.setText(time);
            }, calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE), true).show();
        });
        // thêm công việc
        btnThem.setOnClickListener(v -> {
            String noiDung = editNoiDung.getText().toString().trim();
            String ngay = editNgay.getText().toString().trim();
            String gio = editGio.getText().toString().trim();
            if (!noiDung.isEmpty() && !ngay.isEmpty() && !gio.isEmpty()) {
                String congViec = noiDung + " - " + ngay + " " + gio;
                listCV.add(congViec);
                adapter.notifyDataSetChanged();
                editNoiDung.setText("");
                editNgay.setText("");
                editGio.setText("");
            }
        });
    }
}
package com.example.listviewtest;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
    /**
     * Spinner là một thành phần giao diện cho phép người dùng chọn một giá trị từ danh sách dạng dropdown.
     *
     * Nó giống như ComboBox trong các ngôn ngữ lập trình khác.
     * */
public class Bai8Activity extends AppCompatActivity {

    Spinner spMonHoc;
    TextView txtKetQua;

    String[] monHoc = {
            "Android",
            "Java",
            "PHP",
            "NodeJS",
            "JavaScript"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai8);

        spMonHoc = findViewById(R.id.spMonHoc);
        txtKetQua = findViewById(R.id.txtKetQua);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                monHoc
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMonHoc.setAdapter(adapter);

        spMonHoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, android.view.View view, int position, long id) {
                String selectedMonHoc = monHoc[position];
                txtKetQua.setText("Bạn đã chọn: " + selectedMonHoc);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                txtKetQua.setText("Bạn chưa chọn môn học nào");
            }

        });
    }
}
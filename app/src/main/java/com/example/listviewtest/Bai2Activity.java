package com.example.listviewtest;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Bai2Activity extends AppCompatActivity {

    private EditText editText;
    private Button btnNhap;
    private ListView lvDanhSach;
    private TextView txtKetQua;

    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai2);

        // Ánh xạ view
        editText = findViewById(R.id.edtTen);
        btnNhap = findViewById(R.id.btnNhap);
        lvDanhSach = findViewById(R.id.lvDanhSach);
        txtKetQua = findViewById(R.id.txtKetQua);

        // Khởi tạo danh sách
        list = new ArrayList<>();
        list.add("teo");
        list.add("ty");
        list.add("binh");

        // Khởi tạo adapter
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                list
        );

        // Gán adapter cho ListView
        lvDanhSach.setAdapter(adapter);

        // Sự kiện click button nhập
        btnNhap.setOnClickListener(v -> {
            String ten = editText.getText().toString().trim();
            if (!ten.isEmpty()) {
                list.add(ten);
                adapter.notifyDataSetChanged();
                editText.setText("");
            }
        });

        // Sự kiện click item trong ListView
        lvDanhSach.setOnItemClickListener((parent, view, position, id) -> {
            String value = list.get(position);
            String result = "Tên: " + value + "\nVị trí: " + position;
            txtKetQua.setText(result);
        });
    }
}
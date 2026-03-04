package com.example.listviewtest;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
    /**
     * Thêm – Sửa – LongClick Xóa – Hộp thoại xác nhận).
     * */
public class Bai1Activity extends AppCompatActivity {

    EditText edtMonHoc;
    Button btnThem, btnSua;
    ListView lvMonHoc;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    int viTriDangChon = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

        // Ánh xạ
        edtMonHoc = findViewById(R.id.edtMonHoc);
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        lvMonHoc = findViewById(R.id.lvMonHoc);


        list = new ArrayList<>();
        list.add("Android");
        list.add("PHP");
        list.add("NodeJS");
        list.add("JavaScript");
        list.add("Java");
        list.add("C#");

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                list
        );

        lvMonHoc.setAdapter(adapter);

        btnThem.setOnClickListener(v -> {
            String mon = edtMonHoc.getText().toString().trim();
            if (!mon.isEmpty()) {
                list.add(mon);
                adapter.notifyDataSetChanged();
                edtMonHoc.setText("");
            }
        });
        lvMonHoc.setOnItemClickListener((parent, view, position, id) -> {
            edtMonHoc.setText(list.get(position));
            viTriDangChon = position;
        });
        btnSua.setOnClickListener(v -> {
            if (viTriDangChon != -1) {
                String monMoi = edtMonHoc.getText().toString().trim();
                list.set(viTriDangChon, monMoi);
                adapter.notifyDataSetChanged();
                edtMonHoc.setText("");
                viTriDangChon = -1;
            }
        });
        lvMonHoc.setOnItemLongClickListener((parent, view, position, id) -> {

            new AlertDialog.Builder(this)
                    .setTitle("Cảnh báo")
                    .setMessage("Bạn thật sự muốn xóa?")
                    .setPositiveButton("CÓ", (dialog, which) -> {
                        list.remove(position);
                        adapter.notifyDataSetChanged();
                    })
                    .setNegativeButton("KHÔNG", null)
                    .show();

            return true;
        });
    }
}
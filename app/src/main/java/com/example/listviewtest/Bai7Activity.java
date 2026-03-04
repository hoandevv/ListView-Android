package com.example.listviewtest;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
/**Yêu cầu
 * Khi chạy app:
 *
 * Người dùng nhập tên trái cây vào AutoCompleteTextView
 *
 * Khi người dùng nhập, sẽ hiển thị gợi ý từ danh sách đã định nghĩa
 *
 * Người dùng chọn một gợi ý → hiển thị tên trái cây đã chọn trong TextView*/
public class Bai7Activity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    String[] fruits = {
            "Apple",
            "Banana",
            "Cherry",
            "Date",
            "Grape",
            "Kiwi",
            "Mango",
            "Orange",
            "Pear"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai7);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                fruits
        );
        autoCompleteTextView.setThreshold(1);
        // Gán adapter cho AutoCompleteTextView
        autoCompleteTextView.setAdapter(adapter);
    }
}
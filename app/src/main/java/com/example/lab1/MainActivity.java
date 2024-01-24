package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextPhone;
    RadioButton radioButton1, radioButton2;
    TextView textView;
    Spinner spinner;
    Button button;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editText1);
        editTextPhone = findViewById(R.id.editText2);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        textView = findViewById(R.id.textView);
        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);

        String[] quequan = {"Thái Bình", "Hà Nội", "Hải Dương", "Nam Định", "Hưng Yên"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                quequan);
        spinner.setAdapter(adapter);

        ArrayList<String> dataList = new ArrayList<>();
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dataList);
        listView.setAdapter(adapter1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoten = editTextName.getText().toString();
                String Sdt = editTextPhone.getText().toString();
                String GT = radioButton1.isChecked() ? "Nam" : "Nữ";
                String  queQuan = spinner.getSelectedItem().toString();

                String listItem = hoten + " - " + GT + " - " + Sdt + " - " + queQuan;

                dataList.add(listItem);
                adapter.notifyDataSetChanged();
                clearInputFields();
            }
        });

        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioButton2.setChecked(false);
            }
        });

        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioButton1.setChecked(false);
            }
        });
    }

    private void clearInputFields() {
        editTextName.getText().clear();
        editTextPhone.getText().clear();
        radioButton1.setChecked(true);
        radioButton2.setChecked(false);
        spinner.setSelection(0);
    }
}
package com.example.baitaptuan8;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] names = {"canhtuan1","canhtuan2","canhtuan4","canhtuan5","canhtuan6"};
    ArrayAdapter<String> adapter;

    @Override
    protected  void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<>(this,R.layout.layout_item,R.id.text_name,names);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}

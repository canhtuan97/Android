package com.example.bai3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    Button hangTren, hangDuoi;
    Button cE, bS, dot, num0,num1,num2,num3,num4,num5,num6,num7,num8,num9;
    Spinner chuyenDoiTren, chuyenDoiDuoi;
    double tiSoTren, tiSoDuoi;
    boolean status = true;
    String hang_Tren="0",hang_Duoi="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hangTren = findViewById(R.id.hang_tren);
        hangDuoi = findViewById(R.id.hang_duoi);
        cE = findViewById(R.id.CE);
        bS  = findViewById(R.id.BS);
        dot  = findViewById(R.id.dot);
        num0  = findViewById(R.id.num0);
        num1  = findViewById(R.id.num1);
        num2  = findViewById(R.id.num2);
        num3  = findViewById(R.id.num3);
        num4  = findViewById(R.id.num4);
        num5  = findViewById(R.id.num5);
        num6  = findViewById(R.id.num6);
        num7  = findViewById(R.id.num7);
        num8  = findViewById(R.id.num8);
        num9 = findViewById(R.id.num9);
        chuyenDoiDuoi = findViewById(R.id.chuyen_doi_duoi);
        chuyenDoiTren = findViewById(R.id.chuyen_doi_tren);

        final  List<Part> partList = new ArrayList<>();

        // khoi tao cac gia tri dong tien
        Part part0 = new Part();
        part0.id = String.valueOf(0);
        part0.name ="Afghanistan - Afghani Afghanistan - AFN";
        partList.add(part0);

        Part part1 = new Part();
        part1.id = String.valueOf(1);
        part1.name ="EU - Euro - EUR ";
        partList.add(part1);

        Part part2 = new Part();
        part2.id = String.valueOf(2);
        part2.name ="Ấn Độ - Rupee Ấn Độ - INR ";
        partList.add(part2);

        Part part3 = new Part();
        part3.id = String.valueOf(3);
        part3.name ="Vương quốc Anh - Bảng Anh - GBP ";
        partList.add(part3);

        Part part4 = new Part();
        part4.id = String.valueOf(4);
        part4.name ="Việt Nam - Việt Nam Đồng - VND";
        partList.add(part4);

        Part part5 = new Part();
        part5.id = String.valueOf(5);
        part5.name ="Thổ Nhĩ Kỳ - Lira Thổ Nhĩ Kỳ - TRY  ";
        partList.add(part5);

        Part part6 = new Part();
        part6.id = String.valueOf(6);
        part6.name ="Trung Quốc - Nhân dân tệ - CNY ";
        partList.add(part6);

        Part part7 = new Part();
        part7.id = String.valueOf(7);
        part7.name ="Nga - Ruble Nga - RUB";
        partList.add(part7);

        Part part8 = new Part();
        part8.id = String.valueOf(8);
        part8.name ="Nhật Bản - Yên Nhật - JPY ";
        partList.add(part8);

        Part part9 = new Part();
        part9.id = String.valueOf(9);
        part9.name ="Hàn Quốc - Won Hàn Quốc - KRW  ";
        partList.add(part9);

        Part part10 = new Part();
        part10.id = String.valueOf(10);
        part10.name ="Mỹ Đôla - Mỹ - USD";
        partList.add(part10);

        MyAdapterSpinner mySpinnerAdapter = new MyAdapterSpinner(this, partList);

        chuyenDoiTren.setAdapter(mySpinnerAdapter);
        chuyenDoiDuoi.setAdapter(mySpinnerAdapter);

        // su kien chon 1 hang trong spinner
        chuyenDoiTren.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            // nguoi dung click va chon 1 hang trong danh sach
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Part part = partList.get(position);

                switch (Integer.parseInt(part.id)){
                    case 0:
                        tiSoTren = 76.7;
                        break;
                    case  1:
                        tiSoTren = 0.92;
                        break;
                    case  2:
                        tiSoTren = 76.27;
                        break;
                    case  3:
                        tiSoTren =0.8 ;
                        break;
                    case  4:
                        tiSoTren = 23632.5;
                        break;
                    case  5:
                        tiSoTren = 6.73;
                        break;
                    case  6:
                        tiSoTren = 7.05;
                        break;
                    case  7:
                        tiSoTren =73.85;
                        break;
                    case  8:
                        tiSoTren =107.62;
                        break;
                    case  9:
                        tiSoTren = 1215.45;
                        break;
                    case  10:
                        tiSoTren = 1;
                        break;
                }
            }


            // neu nguoi dung mo spinner ma ko chon gi
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // su kien chon 1 hang trong spinner
        chuyenDoiDuoi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            // nguoi dung click va chon 1 hang trong danh sach
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Part part = partList.get(position);

                switch (Integer.parseInt(part.id)){
                    case 0:
                        tiSoDuoi = 76.7;
                        break;
                    case  1:
                        tiSoDuoi = 0.92;
                        break;
                    case  2:
                        tiSoDuoi = 76.27;
                        break;
                    case  3:
                        tiSoDuoi =0.8;
                        break;
                    case  4:
                        tiSoDuoi =23632.5;
                        break;
                    case  5:
                        tiSoDuoi =6.73;
                        break;
                    case  6:
                        tiSoDuoi =7.05 ;
                        break;
                    case  7:
                        tiSoDuoi = 73.58;
                        break;
                    case  8:
                        tiSoDuoi = 107.62;
                        break;
                    case  9:
                        tiSoDuoi =1215.45 ;
                        break;
                    case  10:
                        tiSoDuoi =1;
                        break;
                }
            }


            // neu nguoi dung mo spinner ma ko chon gi
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        hangTren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hangTren.setTextColor(Color.parseColor("#FF090909"));
                hangDuoi.setTextColor(Color.parseColor("#FF5A5959"));
                hang_Tren ="0";
                hang_Duoi = "0";
                hangTren.setText(hang_Tren);
                hangDuoi.setText(hang_Duoi);
                status = true;
            }
        });
        hangDuoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hangDuoi.setTextColor(Color.parseColor("#FF090909"));
                hangTren.setTextColor(Color.parseColor("#FF5A5959"));
                hang_Tren ="0";
                hang_Duoi = "0";
                hangTren.setText(hang_Tren);
                hangDuoi.setText(hang_Duoi);
                status = false;
            }
        });
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status) {
                    if (hang_Tren == "0") {
                        hang_Tren = "0";
                    }else {
                        hang_Tren += "0";}
                    Float a = Float.parseFloat(hang_Tren);
                    double ts = a / tiSoTren;
                    double b = ts * tiSoDuoi;
                    hang_Duoi = Double.toString(b);
                }else{
                    if (hang_Duoi == "0") {
                        hang_Duoi = "0";
                    }else {
                        hang_Duoi += "0";}
                    Float a = Float.parseFloat(hang_Duoi);
                    double ts = a / tiSoDuoi;
                    double b = ts * tiSoTren;
                    hang_Tren = Double.toString(b);
                }
                hangTren.setText(hang_Tren);
                hangDuoi.setText(hang_Duoi);
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status) {
                    if (hang_Tren == "0") {
                        hang_Tren = "1";
                    }else {
                        hang_Tren += "1";}
                    Float a = Float.parseFloat(hang_Tren);
                    double ts = a / tiSoTren;
                    double b = ts * tiSoDuoi;
                    hang_Duoi = Double.toString(b);
                }else{
                    if (hang_Duoi == "0") {
                        hang_Duoi = "1";
                    }else {
                        hang_Duoi += "1";}
                    Float a = Float.parseFloat(hang_Duoi);
                    double ts = a / tiSoDuoi;
                    double b = ts * tiSoTren;
                    hang_Tren = Double.toString(b);
                }
                hangTren.setText(hang_Tren);
                hangDuoi.setText(hang_Duoi);
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status) {
                    if (hang_Tren == "0") {
                        hang_Tren = "2";
                    }else {
                        hang_Tren += "2";}
                    Float a = Float.parseFloat(hang_Tren);
                    double ts = a / tiSoTren;
                    double b = ts * tiSoDuoi;
                    hang_Duoi = Double.toString(b);
                }else{
                    if (hang_Duoi == "0") {
                        hang_Duoi = "2";
                    }else {
                        hang_Duoi += "2";}
                    Float a = Float.parseFloat(hang_Duoi);
                    double ts = a/tiSoDuoi;
                    double b = ts*tiSoTren;
                    hang_Tren = Double.toString(b);
                }
                hangTren.setText(hang_Tren);
                hangDuoi.setText(hang_Duoi);
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status) {
                    if (hang_Tren == "0") {
                        hang_Tren = "0";
                    }else {
                        hang_Tren += "3";}
                    Float a = Float.parseFloat(hang_Tren);
                    double ts = a/tiSoTren;
                    double b = ts*tiSoDuoi;
                    hang_Duoi = Double.toString(b);
                }else{
                    if (hang_Duoi == "0") {
                        hang_Duoi = "3";
                    }else {
                        hang_Duoi += "3";}
                    Float a = Float.parseFloat(hang_Duoi);
                    double ts = a/tiSoDuoi;
                    double b = ts*tiSoTren;
                    hang_Tren = Double.toString(b);
                }
                hangTren.setText(hang_Tren);
                hangDuoi.setText(hang_Duoi);
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status) {
                    if (hang_Tren == "0") {
                        hang_Tren = "4";
                    }else {
                        hang_Tren += "4";}
                    Float a = Float.parseFloat(hang_Tren);
                    double ts = a/tiSoTren;
                    double b = ts*tiSoDuoi;
                    hang_Duoi = Double.toString(b);
                }else{
                    if (hang_Duoi == "0") {
                        hang_Duoi = "4";
                    }else {
                        hang_Duoi += "4";}
                    Float a = Float.parseFloat(hang_Duoi);
                    double ts = a/tiSoDuoi;
                    double b = ts*tiSoTren;
                    hang_Tren = Double.toString(b);
                }
                hangTren.setText(hang_Tren);
                hangDuoi.setText(hang_Duoi);
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status) {
                    if (hang_Tren == "0") {
                        hang_Tren = "5";
                    }else {
                        hang_Tren += "5";}
                    Float a = Float.parseFloat(hang_Tren);
                    double ts = a/tiSoTren;
                    double b = ts*tiSoDuoi;
                    hang_Duoi = Double.toString(b);
                }else{
                    if (hang_Duoi == "0") {
                        hang_Duoi = "5";
                    }else {
                        hang_Duoi += "5";}
                    Float a = Float.parseFloat(hang_Duoi);
                    double ts = a/tiSoDuoi;
                    double b = ts*tiSoTren;
                    hang_Tren = Double.toString(b);
                }
                hangTren.setText(hang_Tren);
                hangDuoi.setText(hang_Duoi);
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status) {
                    if (hang_Tren == "0") {
                        hang_Tren = "6";
                    }else {
                        hang_Tren += "6";}
                    Float a = Float.parseFloat(hang_Tren);
                    double ts = a/tiSoTren;
                    double b = ts*tiSoDuoi;
                    hang_Duoi = Double.toString(b);
                }else{
                    if (hang_Duoi == "0") {
                        hang_Duoi = "6";
                    }else {
                        hang_Duoi += "6";}
                    Float a = Float.parseFloat(hang_Duoi);
                    double ts = a/tiSoDuoi;
                    double b = ts*tiSoTren;
                    hang_Tren = Double.toString(b);
                }
                hangTren.setText(hang_Tren);
                hangDuoi.setText(hang_Duoi);
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status) {
                    if (hang_Tren == "0") {
                        hang_Tren = "7";
                    }else {
                        hang_Tren += "7";}
                    Float a = Float.parseFloat(hang_Tren);
                    double ts = a/tiSoTren;
                    double b = ts*tiSoDuoi;
                    hang_Duoi = Double.toString(b);
                }else{
                    if (hang_Duoi == "0") {
                        hang_Duoi = "7";
                    }else {
                        hang_Duoi += "7";}
                    Float a = Float.parseFloat(hang_Duoi);
                    double ts = a/tiSoDuoi;
                    double b = ts*tiSoTren;
                    hang_Tren = Double.toString(b);
                }
                hangTren.setText(hang_Tren);
                hangDuoi.setText(hang_Duoi);
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status) {
                    if (hang_Tren == "0") {
                        hang_Tren = "8";
                    }else {
                        hang_Tren += "8";}
                    Float a = Float.parseFloat(hang_Tren);
                    double ts = a/tiSoTren;
                    double b = ts*tiSoDuoi;
                    hang_Duoi = Double.toString(b);
                }else{
                    if (hang_Duoi == "0") {
                        hang_Duoi = "8";
                    }else {
                        hang_Duoi += "8";}
                    Float a = Float.parseFloat(hang_Duoi);
                    double ts = a/tiSoDuoi;
                    double b = ts*tiSoTren;
                    hang_Tren = Double.toString(b);
                }
                hangTren.setText(hang_Tren);
                hangDuoi.setText(hang_Duoi);
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status) {
                    if (hang_Tren == "0") {
                        hang_Tren = "9";
                    }else {
                        hang_Tren += "9";}
                    Float a = Float.parseFloat(hang_Tren);
                    double ts = a/tiSoTren;
                    double b = ts*tiSoDuoi;
                    hang_Duoi = Double.toString(b);
                }else{
                    if (hang_Duoi == "0") {
                        hang_Duoi = "9";
                    }else {
                        hang_Duoi += "9";}
                    Float a = Float.parseFloat(hang_Duoi);
                    double ts = a/tiSoDuoi;
                    double b = ts*tiSoTren;
                    hang_Tren = Double.toString(b);
                }
                hangTren.setText(hang_Tren);
                hangDuoi.setText(hang_Duoi);
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status) {
                    hang_Tren += ".";
                }else{
                    hang_Duoi += ".";
                }
                hangTren.setText(hang_Tren);
                hangDuoi.setText(hang_Duoi);
            }
        });
        cE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hang_Tren = "0";
                hang_Duoi = "0";
                hangTren.setText(hang_Tren);
                hangDuoi.setText(hang_Duoi);
            }
        });
        bS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(status){
                    if (hang_Tren=="0"){
                        hang_Tren = "0";
                    }else{
                        int l=hang_Tren.length();
                        if (l==1){
                            hang_Tren="0";
                        }else{
                            hang_Tren=hang_Tren.substring(0,l-1);
                        }
                    }
                    Float a = Float.parseFloat(hang_Tren);
                    double ts = a/tiSoTren;
                    double b = ts*tiSoDuoi;
                    hang_Duoi = Double.toString(b);
                }else {
                    if (hang_Duoi == "0") {
                        hang_Duoi = "0";
                    } else {
                        int l = hang_Duoi.length();
                        if (l == 1) {
                            hang_Duoi = "0";
                        } else {
                            hang_Duoi = hang_Duoi.substring(0, l - 1);
                        }
                    }
                    Float a = Float.parseFloat(hang_Duoi);
                    double ts = a / tiSoDuoi;
                    double b = ts * tiSoTren;
                    hang_Tren = Double.toString(b);
                }
                hangTren.setText(hang_Tren);
                hangDuoi.setText(hang_Duoi);
            }
        });
    }
}
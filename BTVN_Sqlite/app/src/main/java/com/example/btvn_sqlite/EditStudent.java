package com.example.btvn_sqlite;



import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class EditStudent extends AppCompatActivity {
    boolean isupdate;
    int idproduct;
    EditText editName;
    EditText editEmail;
    EditText editNgaySinh;
    EditText editQueQuan;
    EditText editMssv;
    Student student;

    //Intent: idproduct, isupdate

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_student);

        Intent intent = getIntent();
        isupdate = intent.getBooleanExtra("isupdate", false);
        if (isupdate) {
            //Activity hoạt động biên tập dữ liệu Sản phẩm đã

            //Đọc sản phẩm

            idproduct = intent.getIntExtra("idproduct", 0);

            SQLiteDatabase db = openOrCreateDatabase(MainActivity.DB_NAME, Context.MODE_PRIVATE, null);
            Cursor cursor = db.rawQuery("SELECT * from student where id = ?",
                    new String[]{idproduct + ""});
            cursor.moveToFirst();
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String email = cursor.getString(2);
            String ngaySinh = cursor.getString(3);
            String queQuan = cursor.getString(4);
            int mssv = cursor.getInt(5);


            student = new Student(id,name,email,ngaySinh,queQuan,mssv);
            cursor.close();

            findViewById(R.id.deleteBtn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SQLiteDatabase db = openOrCreateDatabase(MainActivity.DB_NAME, Context.MODE_PRIVATE, null);
                    db.execSQL("DELETE FROM product where id = ?", new String[]{String.valueOf(idproduct)});
                    db.close();
                    finish();
                }
            });


        } else {
            //Activity nhâp dữ liệu thêm Sản phẩm mới

            student = new Student(0,"","","","",0);
            findViewById(R.id.deleteBtn).setVisibility(View.GONE);
            ((Button) findViewById(R.id.save)).setText("Tạo  mới sinh vien ");
        }

        //Update to View
        editName = findViewById(R.id.name);
        editEmail = findViewById(R.id.email);
        editNgaySinh = findViewById(R.id.ngaySinh);
        editQueQuan = findViewById(R.id.queQuan);
        editMssv = findViewById(R.id.mssv);



        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = openOrCreateDatabase(MainActivity.DB_NAME, Context.MODE_PRIVATE, null);
                student.name = editName.getText().toString();
                student.email = editEmail.getText().toString();
                student.ngaySinh = editNgaySinh.getText().toString();
                student.queQuan = editQueQuan.getText().toString();
                student.mssv = Integer.parseInt(editMssv.getText().toString());
                if (isupdate) {
                    //Cập nhật
                    db.execSQL("UPDATE product SET name=?, price = ? where id = ?",
                            new String[]{student.name, student.email + "", student.ngaySinh + ""});
                } else {
                    //Tạo
                    System.out.println(student.name);
                    //Cập nhật
                    db.execSQL("INSERT INTO student (name, email,ngay_sinh,que_quan,mssv ) VALUES (?,?,?,?,?)",
                            new String[]{student.name, student.email,student.ngaySinh,student.queQuan,student.mssv + ""});
                }
                db.close();
                finish();
            }
        });


    }
}

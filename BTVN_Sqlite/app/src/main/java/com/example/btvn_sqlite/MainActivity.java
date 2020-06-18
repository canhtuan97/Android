package com.example.btvn_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static String DB_NAME = "SQLite";
    final int RESULT_PRODUCT_ACTIVITY = 1;
    String DB_TAG = "SQLite";
    StudentListAdapter studentListAdapter;
    ListView listViewStudent;
    ArrayList<Student> listStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentListAdapter  = new StudentListAdapter(listStudent);
        listViewStudent         = findViewById(R.id.list_view_student);
        findViewById(R.id.tao_db).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createTableStudent();
                loadDbProduct();
                studentListAdapter.notifyDataSetChanged();
            }
        });

        //Thêm dữ liệu
        findViewById(R.id.them_sinh_vien).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("day la trancanhtuan");
                Intent intent = new Intent();
                intent.putExtra("isupdate", false);
                intent.setClass(MainActivity.this, EditStudent.class);
                startActivityForResult(intent, RESULT_PRODUCT_ACTIVITY);


            }
        });


    }
    void createTableStudent() {
        SQLiteDatabase db = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
        if (!(isTableExist(db, "student"))) {
            String queryCreateTable = "CREATE TABLE product ( " +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name VARCHAR (255), " +
                    "email VARCHAR (255), " +
                    "ngay_sinh VARCHAR (255)," +
                    "que_quan VARCHAR (255) ," +
                    "mssv INTEGER" +
                    ")";

            db.execSQL(queryCreateTable);

            Toast.makeText(this, "Đã tạo bảng thành công", Toast.LENGTH_LONG).show();

        } else
            Toast.makeText(this, "Bảng đang tồn tại, không cần tạo mới", Toast.LENGTH_LONG).show();

        db.close();
    }
    boolean isTableExist(SQLiteDatabase db, String table) {
        Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name=?", new String[]{table});
        boolean tableExist = (cursor.getCount() != 0);
        cursor.close();
        return tableExist;
    }

    private void loadDbProduct() {

        listStudent.clear();
        SQLiteDatabase db = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);

        if (!isTableExist(db, "student")) {
            Toast.makeText(this, "Bảng student không tồn tại, cần tạo bảng trước", Toast.LENGTH_LONG).show();
            ((TextView) findViewById(R.id.msg)).setText("Bảng dữ liệu không có, phải tạo bảng");

            return;
        }

        ((TextView) findViewById(R.id.msg)).setText("Student");
        findViewById(R.id.them_sinh_vien).setVisibility(View.VISIBLE);


        Cursor cursor = db.rawQuery("SELECT * from student", null);

        //Đến dòng đầu của tập dữ liệu
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String email = cursor.getString(2);
            String ngaySinh = cursor.getString(3);
            String queQuan = cursor.getString(4);
            int mssv = cursor.getInt(5);
            listStudent.add(new Student(id,name,email,ngaySinh,queQuan,mssv));

            // Đến dòng tiếp theo
            cursor.moveToNext();
        }

        cursor.close();

    }

    class StudentListAdapter extends BaseAdapter{
        final ArrayList<Student> listStudent;

        StudentListAdapter(ArrayList<Student> listStudent) {
            this.listStudent = listStudent;
        }


        @Override
        public int getCount() {
            return listStudent.size();
        }

        @Override
        public Object getItem(int position) {
            return listStudent.get(position);
        }

        @Override
        public long getItemId(int position) {
            return listStudent.get(position).id;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //convertView là View của phần tử ListView, nếu convertView != null nghĩa là
            //View này được sử dụng lại, chỉ việc cập nhật nội dung mới
            //Nếu null cần tạo mới

            View viewProduct;
            if (convertView == null) {
                viewProduct = View.inflate(parent.getContext(), R.layout.student_view, null);
            } else viewProduct = convertView;

            //Bind sữ liệu phần tử vào View
            Student student = (Student) getItem(position);
            ((TextView) viewProduct.findViewById(R.id.id)).setText(String.format("ID = %d", student.id));
            ((TextView) viewProduct.findViewById(R.id.name)).setText(String.format(" name %s", student.name));
            ((TextView) viewProduct.findViewById(R.id.email)).setText(String.format("email %d", student.email));
            ((TextView) viewProduct.findViewById(R.id.ngaySinh)).setText(String.format("Ngay sinh %d", student.ngaySinh));
            ((TextView) viewProduct.findViewById(R.id.queQuan)).setText(String.format("Que quan %d", student.queQuan));
            ((TextView) viewProduct.findViewById(R.id.mssv)).setText(String.format("mssv %d", student.mssv));


            return viewProduct;
        }
    }
}

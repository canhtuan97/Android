package com.example.btvn_sqlite;

public class Student {
    int id;
    String name;
    String email;
    String ngaySinh;
    String queQuan;
    int mssv;

    public int getId() {
        return id;
    }


    public Student(int id, String name, String email, String ngaySinh, String queQuan, int mssv) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.mssv = mssv;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }
}

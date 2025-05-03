package com.jivan.bcamidterm.database.model;

public class Student {
    private int id;
    private String name;
    private String address;
    private String faculty;

    public Student(int id, String name, String address, String faculty) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.faculty = faculty;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getFaculty() { return faculty; }
}

package com.jivan.bcamidterm.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.jivan.bcamidterm.database.model.Student;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "jivan.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "student";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_FACULTY = "faculty";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT ," +
                COLUMN_ADDRESS + " TEXT, " +
                COLUMN_FACULTY + " TEXT )";
        db.execSQL(createTableSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertStudent(String name, String address, String faculty) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_ADDRESS, address);
        values.put(COLUMN_FACULTY, faculty);
        long result = db.insert(TABLE_NAME, null, values);
        return result != -1;
    }

    public boolean updateStudent(int id, String name, String address, String faculty){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", name);
        values.put("address", address);
        values.put("faculty", faculty);

        int result = db.update("student", values, "id=?", new String[]{String.valueOf(id)});
        db.close();
        return result > 0;
    }

    public boolean deleteStudent(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Delete the student where ID matches
        int result = db.delete("student", "id=?", new String[]{String.valueOf(id)});

        db.close();
        return result > 0; // Returns true if deletion was successful
    }


    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from student", null);

        if (cursor.moveToFirst()) {
            // get columns index, if no such column; -1 is returned
            int idIndex = cursor.getColumnIndex("id");
            int nameIndex = cursor.getColumnIndex("name");
            int addressIndex = cursor.getColumnIndex("address");
            int facultyIndex = cursor.getColumnIndex("faculty");
            do {
                // check if the columns exist
                if (idIndex != -1 && nameIndex != -1 && addressIndex != -1 && facultyIndex != -1) {
                    int id = cursor.getInt(idIndex);
                    String name = cursor.getString(nameIndex);
                    String address = cursor.getString(addressIndex);
                    String faculty = cursor.getString(facultyIndex);

                    // add student to list
                    students.add(new Student(id, name, address, faculty));
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return students;
    }

    public Student getStudentById(int studentId) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM STUDENT WHERE id = ?;", new String[]{String.valueOf(studentId)});

        if (cursor.moveToFirst()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String address = cursor.getString(2);
            String faculty = cursor.getString(3);

            cursor.close();
            db.close();
            return new Student(id, name, address, faculty);
        } else {
            cursor.close();
            db.close();
            return null;
        }
    }
}

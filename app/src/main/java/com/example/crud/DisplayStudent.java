package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.crud.Adapter.StudentAdapter;
import com.example.crud.Database;
import com.example.crud.DatabaseHelper;
import com.example.crud.Model.Student;
import com.example.crud.R;


import java.util.List;

public class DisplayStudent extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button btnBackToAddStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_student);
        recyclerView = findViewById(R.id.recyclerViewStudents);
        btnBackToAddStudents = findViewById(R.id.btnBackToAdd);

        DatabaseHelper dbHelper = new DatabaseHelper(DisplayStudent.this);
        List<Student> studentList = dbHelper.displayStudents();

        StudentAdapter studentAdapter = new StudentAdapter(DisplayStudent.this, studentList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(studentAdapter);

        btnBackToAddStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayStudent.this, Database.class);
                startActivity(intent);
            }
        });

    }
}

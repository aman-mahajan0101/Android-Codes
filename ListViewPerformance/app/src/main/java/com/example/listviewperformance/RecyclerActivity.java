package com.example.listviewperformance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    ArrayList<Course> courses = Course.generateNRandomCourses(100);
    RecyclerView rvCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        rvCourses = findViewById(R.id.rvCourses);
        //For linear Layout
        //rvCourses.setLayoutManager(new LinearLayoutManager(this));

        //For grid View
        rvCourses.setLayoutManager(
                new GridLayoutManager(this,4,
                        LinearLayoutManager.HORIZONTAL,false));

        CourseRecyclerAdapter courseAdapter = new CourseRecyclerAdapter(courses);
        rvCourses.setAdapter(courseAdapter);
    }
}
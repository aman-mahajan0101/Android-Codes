package com.example.listviewcustomadapter;

import java.util.ArrayList;

public class Teacher {
    String name;
    String Course;

    public Teacher(String name, String course) {
        this.name = name;
        this.Course = course;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return Course;
    }
    public static ArrayList<Teacher> get8RandomTeachers(){
        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("Arnav","Android"));
        teachers.add(new Teacher("Prateek","C++"));
        teachers.add(new Teacher("Rishabh","Java"));
        teachers.add(new Teacher("Garima","Java"));
        teachers.add(new Teacher("Pulkit","Android"));
        teachers.add(new Teacher("Harsh","NodeJs"));
        teachers.add(new Teacher("Aayush","C++"));
        teachers.add(new Teacher("Arnav","Android"));
        return teachers;
    }
}

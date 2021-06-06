package com.example.listviewperformance;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Course {

    String name;
    String teacherName;
    int lectures;

    public Course(String name, String teacherName,int lectures) {
        this.name = name;
        this.teacherName = teacherName;
        this.lectures = lectures;
    }

    public String getName() {
        return name;
    }

    public int getLectures() {
        return lectures;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public static final String[] teachers = {
            "Harshit",
            "Garima",
            "Arnav",
            "Ayush",
            "Pratek",
            "Deepak"
    };

    public static final String[] courseNames = {
            "Launchpad",
            "Java",
            "Android",
            "NodeJS",
            "C++",
            "Python"
    };

    public static ArrayList<Course> generateNRandomCourses(int n){
        ArrayList<Course> courses = new ArrayList<>();
        Random r = new Random();
        for(int i=0;i<n;i++){
            Course course = new Course(
                    teachers[r.nextInt(6)],
                    courseNames[r.nextInt(6)],
                    10+ r.nextInt(10)
            );
            courses.add(course);
        }
        return courses;
    }


}



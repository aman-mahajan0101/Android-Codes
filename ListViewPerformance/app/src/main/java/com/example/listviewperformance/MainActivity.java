package com.example.listviewperformance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Currency;

public class MainActivity extends AppCompatActivity {

    ListView lvCourses;
    ArrayList<Course> courses = Course.generateNRandomCourses(100);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCourses = findViewById(R.id.lvCourses);
        CourseAdapter courseAdapter = new CourseAdapter();
        lvCourses.setAdapter(courseAdapter);
    }

    class CourseAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return courses.size();
        }

        @Override
        public Course getItem(int position) {
            return courses.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


        //Normal method
        //USING VIEW
        /*
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View itemView = getLayoutInflater().inflate(
                    R.layout.list_item_course,
                    parent,
                    false
            );
            TextView tvCourseName = itemView.findViewById(R.id.tvCourseName);
            TextView tvTeacherName = itemView.findViewById(R.id.tvTeacherName);
            TextView tvLectures = itemView.findViewById(R.id.tvlectures);
            Course course = getItem(position);
            tvCourseName.setText(course.getName());
            tvTeacherName.setText(course.getTeacherName());
            tvLectures.setText(String.valueOf(course.getLectures()));
            return itemView;
        }

         */

        /*USING CONVERT VIEW present in the arguments
        /*
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = getLayoutInflater().inflate(
                        R.layout.list_item_course,
                        parent,
                        false
                );
            }
            TextView tvCourseName = convertView.findViewById(R.id.tvCourseName);
            TextView tvTeacherName = convertView.findViewById(R.id.tvTeacherName);
            TextView tvLectures = convertView.findViewById(R.id.tvlectures);
            Course course = getItem(position);
            tvCourseName.setText(course.getName());
            tvTeacherName.setText(course.getTeacherName());
            tvLectures.setText(String.valueOf(course.getLectures()));
            return convertView;
        }*/


        /* USING CONVERT VIEW present in the arguments
        With holder object in it  */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CourseViewHolder holder;
            if(convertView == null){
                convertView = getLayoutInflater().inflate(
                        R.layout.list_item_course,
                        parent,
                        false
                );
                holder = new CourseViewHolder(convertView);
                convertView.setTag(holder);
            }else{
                holder = (CourseViewHolder) convertView.getTag();
            }

            Course course = getItem(position);
            holder.tvCourseName.setText(course.getName());
            holder.tvTeacherName.setText(course.getTeacherName());
            holder.tvLectures.setText(String.valueOf(course.getLectures()));
            return convertView;
        }

        class CourseViewHolder{

            TextView tvCourseName,tvTeacherName,tvLectures;

            CourseViewHolder(View convertView){
                tvCourseName = convertView.findViewById(R.id.tvCourseName);
                tvTeacherName = convertView.findViewById(R.id.tvTeacherName);
                tvLectures = convertView.findViewById(R.id.tvlectures);

            }
        }


    }

}
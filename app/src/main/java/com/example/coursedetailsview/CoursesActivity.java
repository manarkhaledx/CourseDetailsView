package com.example.coursedetailsview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class CoursesActivity extends AppCompatActivity {
    ImageView courseIV;
    TextView  contentTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        courseIV=findViewById(R.id.iv_course);
        contentTV=findViewById(R.id.tv_content);
        Courses courses=getIntent().getParcelableExtra("course");
        assert courses != null;
        courseIV.setImageResource(courses.courseImage);
        Log.d("CourseActivity", "Course Image Resource ID: " + courses.courseImage);
        contentTV.setText(courses.content);

    }


}
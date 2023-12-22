package com.example.coursedetailsview;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onCourseClick(View view){
        if(view instanceof Button){
            Button btn=((Button)view);
            if(btn.getText().equals("Android Course")){
                String androidfile=readFile("android.txt");
                Courses android=new Courses(androidfile, R.drawable.android);
                Intent intent=new Intent(this, CoursesActivity.class);
                intent.putExtra("course",android);
                startActivity(intent);
            }else if(btn.getText().equals("IOS Course")){
                String iosfile=readFile("ios.txt");
                Courses ios=new Courses(iosfile, R.drawable.ios);
                Intent intent=new Intent(this, CoursesActivity.class);
                intent.putExtra("course",ios);
                startActivity(intent);
            }else {
                String fullStackfile=readFile("fullstack.txt");
                Courses fullStack=new Courses(fullStackfile, R.drawable.fullstack);
                Intent intent=new Intent(this, CoursesActivity.class);
                intent.putExtra("course",fullStack);
                startActivity(intent);
            }

        }
    }
    private String readFile(String fileName) {
        AssetManager assetManager = getAssets();
        StringBuilder stringBuilder = new StringBuilder();

        try {
            InputStream inputStream = assetManager.open(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}

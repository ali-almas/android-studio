package com.example.hp450.something;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.regex.Matcher;

public class MainActivity extends AppCompatActivity
{
    Intent intentOfPass;

    private GestureDetectorCompat gestureObject;

    public void toCallsActivity(View view)
    {
        intentOfPass = new Intent(getApplicationContext(),CallsActivity.class);
        startActivity(intentOfPass);
    }

    public void toChatsActivity(View view)
    {
        intentOfPass = new Intent(getApplicationContext(),ChatsActivity.class);
        startActivity(intentOfPass);
    }
    public void toPeopleActivity(View view)
    {
        intentOfPass = new Intent(getApplicationContext(),PeopleActivity.class);
        startActivity(intentOfPass);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureObject = new GestureDetectorCompat(this,new LearnGesture());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class LearnGesture extends GestureDetector.SimpleOnGestureListener
    {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if (e2.getX() > e1.getX())
            {

            }
            else if(e2.getX() < e1.getX())
            {
                intentOfPass = new Intent(MainActivity.this,CallsActivity.class);
                startActivity(intentOfPass);
            }
            return true;
        }
    }
}

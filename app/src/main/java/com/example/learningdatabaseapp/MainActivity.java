package com.example.learningdatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView showDateTxt;
    private Button editNoteButton;
    private CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addComponents();
        displayCalenderDots();

        Date today = new Date();
        SimpleDateFormat formatting = new SimpleDateFormat("EEE \n dd-MMM-yyyy");
        String strDateNow = formatting.format(today);
        showDateTxt.setText(strDateNow.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator = getMenuInflater();
        inflator.inflate(R.menu.my_menu, menu);
        return true;
    }

    private void displayCalenderDots() {

    }

    private void addComponents() {
        showDateTxt = findViewById(R.id.showDateTxt);
        editNoteButton = findViewById(R.id.editNoteButton);
        calendar = findViewById(R.id.calendarView);
    }
}
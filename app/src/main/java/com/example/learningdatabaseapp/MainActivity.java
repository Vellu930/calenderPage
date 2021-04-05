package com.example.learningdatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView showDateTxt;
    private Button editNoteButton;
    private CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addComponents();
        displayCalenderDots();

        editNoteButton.setOnClickListener(this);

        Date today = new Date();
        SimpleDateFormat formatting = new SimpleDateFormat("EEE \n dd-MMM-yyyy");
        String strDateNow = formatting.format(today);
        showDateTxt.setText(strDateNow.toString());
    }
    @Override
    public void onClick(View v) {
     //Change this to switch if need more buttons
        if (v.getId() == R.id.editNoteButton) {
            startActivity(new Intent(this, AddNoteActivity.class));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
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
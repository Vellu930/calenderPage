package com.example.learningdatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class AddNoteActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String FILE_NAME = "notesData.txt";
    private static EditText titleText, noteText;
    private static Button saveButton, cancelButton;

    public HashMap<String, String> notesList = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        titleText = (EditText) findViewById(R.id.noteTitle);
        noteText = (EditText) findViewById(R.id.noteDesc);
        saveButton = (Button) findViewById(R.id.submitNewNote);
        cancelButton = (Button) findViewById(R.id.cancelNewNote);

    }

    @Override
    public void onClick(View v) {
    switch (v.getId()) {
        case R.id.submitNewNote:
            saveNote();
            startActivity(new Intent(this, ViewNoteActivity.class));
                break;
        case R.id.cancelNewNote:
            startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }

    private void saveNote() {
        String title = titleText.getText().toString();
        String noteDesc = noteText.getText().toString();
        notesList.put(title, noteDesc);
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(title.getBytes());
            fos.write(noteDesc.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
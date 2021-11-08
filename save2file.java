package com.example.assignment1;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class save2file extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save2file);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void save2file(View view) throws IOException {

        RugList the_list = RugList.getInstance();
        EditText et1 = (EditText) findViewById(R.id.filename);
        String outfilename = et1.getText().toString();

        //creates a file that is able to be stored on the device's SD card, with given filename by the user via EditText
        File outfile = new File(getExternalFilesDir(null), outfilename);

        //if the name of the file typed in by the user doesn't exist, creates ability to write to a file
        if (!outfile.exists())

        {
            FileWriter fw = new FileWriter(outfile);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);


            for (int j = 0; j < the_list.size(); j++) {

                //sets newrug variable to every index of the RugList,aka every Rug object, on loop
                Rug newrug = the_list.get(j);

                //using the PrintWriter reference, get information from all the rugs and display one per line in the created file
                pw.println(newrug.getMake());
                pw.println(newrug.getDesigner());
                pw.println(newrug.getProductcode());
                pw.println(newrug.getLength());
                pw.println(newrug.getWidth());
                pw.println(newrug.getYear());
                pw.println(newrug.getPrice());
                pw.println(newrug.getImgurl());

            }
            //closes writer after finished
            pw.close();

            Toast.makeText(save2file.this, "Succesfully Exported.",
                    Toast.LENGTH_SHORT).show();

        }

        //if the file name typed in by the user does exist, Toast message below
        else

            {

            Toast.makeText(save2file.this, "File exists already. Enter another filename.",
                    Toast.LENGTH_SHORT).show();
            }


            if (the_list.isEmpty()) {
                Toast.makeText(save2file.this, "List is empty. Please add a list via one of the appropriate options.",
                        Toast.LENGTH_SHORT).show();
            }

        }
    }



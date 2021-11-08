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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class urlRugs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url_rugs);
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

    public void urlRugs(View view)  {


        //creates EditText for user to type into
        EditText et1 = (EditText) findViewById(R.id.rug_url);

        //stores what is typed by the user into variable url
        String url = et1.getText().toString();

        try

        {
            //creates a scanner that feeds in URL file for opening
            URL file_url = new URL(url);
            Scanner fsc = new Scanner(file_url.openStream());

            //creates instance of list
            RugList the_list = RugList.getInstance();

            //removes the contents of the existing list, so the list only contains what is generated via code below
            the_list.removeAll(the_list);

                //as long as there are contents within the Web data file, assigns each line to a variable
                while (fsc.hasNext())
                {

                    String make = fsc.nextLine();
                    String designer = fsc.nextLine();
                    String productcode = fsc.nextLine();
                    double length = Double.parseDouble(fsc.nextLine());
                    double width = Double.parseDouble(fsc.nextLine());
                    int year = Integer.parseInt(fsc.nextLine());
                    double price = Double.parseDouble(fsc.nextLine());
                    String imgurl = fsc.nextLine();

                    //new Rug object that is populated with the variables above
                    Rug newrug = new Rug(make, designer, productcode, length, width, year, price, imgurl);

                    //adding the Rug object to the RugList
                    the_list.add(the_list.size(), newrug);


                }

           Toast.makeText(urlRugs.this, "Successfully loaded Rug Data. Choose option \"Show Ruglist\" to display.",
                    Toast.LENGTH_LONG).show();

            }

        catch(MalformedURLException e)
        {
            Toast.makeText(urlRugs.this, "Invalid URL",
                    Toast.LENGTH_SHORT).show();
        }

        catch (IOException e)
        {

            Toast.makeText(urlRugs.this, "File doesn't exist",
                    Toast.LENGTH_SHORT).show();
        }


    }

}



package com.example.assignment1;

import android.nfc.FormatException;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.IllegalFormatException;
import java.util.InputMismatchException;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
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

    public void addItem(View view) {

        try {

            //eight EditTexts for user input
            EditText et1, et2, et3, et4, et5, et6, et7, et8;

            RugList the_list = RugList.getInstance();

            et1 = (EditText) findViewById(R.id.enter_make);
            String make = et1.getText().toString();

            et2 = (EditText) findViewById(R.id.enter_designer);
            String designer = et2.getText().toString();

            et3 = (EditText) findViewById(R.id.enter_productcode);
            String productcode = et3.getText().toString();

            et4 = (EditText) findViewById(R.id.enter_length);
            double length = Double.parseDouble(et4.getText().toString());

            et5 = (EditText) findViewById(R.id.enter_width);
            double width = Double.parseDouble(et5.getText().toString());

            et6 = (EditText) findViewById(R.id.enter_year);
            int year = Integer.parseInt(et6.getText().toString());

            et7 = (EditText) findViewById(R.id.enter_price);
            double price = Double.parseDouble(et7.getText().toString());

            et8 = (EditText) findViewById(R.id.enter_url);
            String url = et8.getText().toString();


            //populate newrug variable with information gathered from the eight edit texts
            Rug newrug = new Rug(make, designer, productcode, length, width, year, price, url);

            //add the new Rug object to the RugList
            the_list.add(the_list.size(), newrug);

            Toast.makeText(AddItemActivity.this, " Rug added to the list",
                    Toast.LENGTH_SHORT).show();

            Toast.makeText(AddItemActivity.this, "Please go back to the Main Menu and choose \"Show List\" to display the new rug",
                    Toast.LENGTH_LONG).show();

        }

        catch (InputMismatchException e)
            {

            Toast.makeText(AddItemActivity.this, "One of the fields had invalid data, try entering again.",
                    Toast.LENGTH_SHORT).show();
            }

            catch(NumberFormatException e)
                {
                Toast.makeText(AddItemActivity.this, "One of the fields had invalid data, try entering again.",
                        Toast.LENGTH_SHORT).show();
                }
        }
    }



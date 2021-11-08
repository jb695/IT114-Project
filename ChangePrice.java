package com.example.assignment1;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;

public class ChangePrice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_price);
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

    public void changePrice(View view) {



            EditText et1,et2;
            et1 = (EditText) findViewById(R.id.code_enter);
            et2 = (EditText) findViewById(R.id.price_change);
            RugList the_list = RugList.getInstance();
            String rugcode = et1.getText().toString();
            double newprice = 0;
            boolean ismatch = false;


            try
                {

                newprice = Double.parseDouble(et2.getText().toString());

                }

            //catches error if an invalid character was put into EditText
            catch(NumberFormatException e)

                 {
                     Toast.makeText(ChangePrice.this, "Invalid Number. Enter Again.",
                             Toast.LENGTH_SHORT).show();

                 }

                //iterates through the_list, each index is a rug object
                for (int j = 0; j < the_list.size(); j++)
                {

                    //sets newrug variable to every index of the RugList(aka every Rug object, on loop)
                    Rug newrug = the_list.get(j);

                    //if what is typed in by the user matches a rug's product code, execute code below
                    if (rugcode.equalsIgnoreCase(newrug.getProductcode()))

                    {
                        newrug.setPrice(newprice);
                        Toast.makeText(ChangePrice.this, "Product Code Matched. If Number was valid, Price Updated. Otherwise, Enter Again.",
                                Toast.LENGTH_LONG).show();

                        //if there is a match, set boolean variable to true
                        ismatch = true;

                    }

                }

                //ismatch is only true when there is a successful match, therefore if false, no product code match
                if (!ismatch)

                {
                    Toast.makeText(ChangePrice.this, "There is no rug with this product code.",
                            Toast.LENGTH_SHORT).show();
                }

                //if the list is empty, Toast this message
                if (the_list.isEmpty())
                {

                    Toast.makeText(ChangePrice.this, "List is empty. Please add a list via one of the appropriate options.",
                            Toast.LENGTH_SHORT).show();
                }


            }







    }



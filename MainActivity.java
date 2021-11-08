

////////////////////////////////////////
//                                    //
//  Jared Baez                       //
//  IT114, Section 004               //
//  Dr. Halper                      //
//  App Project #1                 //
//  Mar. 31, 2020                 //
//                               //
//  This app is able to populate  //
//  a List with Rug data containing //
//  various aspects of it such      //
//  as Age, Price, Area, etc        //
//  and offers various options to   //
//  display and manipulate the values //
//  of the Rugs and allows the        //
//  import and export of these Rug files.//
//////////////////////////////////////////



package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.StrictMode;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    //creating TextView reference
    public TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        RugList the_list;

        // setting tv value onCreate so we don't have to declare below
        tv = (TextView) findViewById(R.id.text_main);

        // create/access the list of Rugs
        the_list = RugList.getInstance();

        //sets initial text on screen
       if(the_list.isEmpty())
        {
            tv.setText("List is currently empty. \n\nPlease Choose one of the appropriate Menu Options to Add Rugs.");

        }

    } //end onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onOption1(MenuItem i) {

        //creates instance of list
        RugList the_list = RugList.getInstance();

        //establishes TextView to be empty
        tv.setText("");

        //iterates through the_list, each index is a rug object
        for (int j = 0; j < the_list.size(); j++)

        {
            //sets newrug variable to a rug object per loop and runs get methods to display to TextView
            Rug newrug = the_list.get(j);
            tv.append(newrug.getMake() + ", ");
            tv.append(newrug.getDesigner() + ", ");
            tv.append(newrug.getProductcode() + ", ");
            tv.append(newrug.getArea() + " sqft, ");
            tv.append(newrug.getYear() + ", ");
            tv.append("$" + newrug.getPrice() + ", ");
            tv.append(newrug.getImgurl() + "\n\n");
        }
    }

    public void onOption2(MenuItem i) {


       startActivity(new Intent(this, urlRugs.class));

    }

    public void onOption3(MenuItem i)
    {

        startActivity(new Intent(this, AddItemActivity.class));

    }

    public void onOption4(MenuItem i)
    {

        startActivity(new Intent(this, drawee.class));

    }


    public void onOption5(MenuItem i)
    {

        startActivity(new Intent(this, ChangePrice.class));

    }

    public void onOption6(MenuItem i)
    {

        startActivity(new Intent(this, RemoveItemActivity.class));

    }

    public void onOption7(MenuItem i)
    {

        RugList the_list = RugList.getInstance();
        tv.setText("");

        //sets bigrug reference to be the first item(rug object in the list)
        Rug bigrug = the_list.get(0);

        ////iterates through the_list, each index is a rug object
        for (int j = 0; j < the_list.size(); j++)

        {
            //if bigrug's age is lower than the other ages from all other Rug objects in the list, execute code below
            if(bigrug.getAge() < the_list.get(j).getAge())

            {
                //set bigrug to equal the object that has the greater age
                bigrug = the_list.get(j);

            }
        }

        //displays all information about bigrug, which at this point will be the rug object with the greatest age
        tv.append("The oldest Rug is: " + "\n\n");
        tv.append("Make: " + bigrug.getMake() + "\n");
        tv.append("Design: " + bigrug.getDesigner() + "\n");
        tv.append("Product Code: " + bigrug.getProductcode() + "\n");
        tv.append("Area: " + bigrug.getArea() + " sqft" + "\n");
        tv.append("Age: " + bigrug.getAge() + "\n");
        tv.append("Price: $" + bigrug.getPrice() + "\n\n");




    }


    public void onOption8(MenuItem i) {


        //creates instance of list
        RugList the_list = RugList.getInstance();
        double averageprice = 0;
        double total = 0;

        //creates a DecimalFormat Object to format a number to have only two decimal points
        DecimalFormat df = new DecimalFormat("0.00");

        //establishes TextView to be empty
        tv.setText("");


        if (the_list.isEmpty())

        {

            tv.append("List is empty. Please add a Rug via one of the appropriate options." + "\n");

        }

        //iterates through the_list, each index is a rug object
        for (int j = 0; j < the_list.size(); j++)
        {

            //finds all Rug objects with an area <= 75
            if (the_list.get(j).getArea() <= 75)

            {
                //stores the values of the prices of the Rug objects that fulfill above requirement
                total += the_list.get(j).getPrice();

                //gets average by dividing the sum of prices by the number of Rug objects in the list
                averageprice = total / the_list.size();

            }

        }

            tv.append("The average price of Rugs whose area is less than or equal to 75sqft is: $" + df.format(averageprice));
        }


    public void onOption9(MenuItem i)
    {

        startActivity(new Intent(this, save2file.class));

    }

} // end MainActivity


package com.example.assignment1;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.drawee.view.SimpleDraweeView;

public class drawee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawee);
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

    public void displayRug(View view) {


        TextView tv = (TextView) findViewById(R.id.text_main2);
        EditText et1 = (EditText) findViewById(R.id.code_enter2);
        RugList the_list = RugList.getInstance();
        String rugcode = et1.getText().toString();
        tv.setText("");
        boolean ismatch = false;

        //iterates through the_list, each index is a rug object
        for (int j = 0; j < the_list.size(); j++)

        {

            //sets newrug variable to a rug object, per loop and runs get methods
            Rug newrug = the_list.get(j);

            //if what is typed in by the user via EditText matches a rug's product code, execute code below
            if (rugcode.equalsIgnoreCase(newrug.getProductcode()))

            {
                //set boolean to true on successful match and display the Rug's information via various get methods
                ismatch = true;
                String imgurl = newrug.getImgurl();
                tv.append("Make: " + newrug.getMake() + "\n");
                tv.append("Design: " + newrug.getDesigner() +"\n");
                tv.append("Length: " + newrug.getLength() + "ft" +"\n");
                tv.append("Width: " + newrug.getWidth() + "ft" +"\n");
                tv.append("Area: " + newrug.getArea() + " sqft" +"\n");
                tv.append("Age: " + newrug.getAge() + "\n");
                tv.append("Price: $" + newrug.getPrice());

                //displays image of rug based on imgurl string
                Uri uri = Uri.parse(imgurl);
                SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.image_area);
                draweeView.setImageURI(uri);

            }
        }

        //ismatch is only true when there is a successful match, therefore if false, no product code match
        if(!ismatch)

            {
                    Toast.makeText(drawee.this, "Rug with that Product Code Not Found.",
                            Toast.LENGTH_SHORT).show();
            }

            }
        }



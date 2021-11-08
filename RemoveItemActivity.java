package com.example.assignment1;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.IllegalFormatException;

public class RemoveItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_item);
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

    public void removeItem(View view) {

        EditText et1;
        et1 = (EditText) findViewById(R.id.code_remove);
        RugList the_list = RugList.getInstance();
        String removeposition = et1.getText().toString();
        boolean ismatch = false;


        //iterates through the_list, each index is a rug object
        for (int j = 0; j < the_list.size(); j++)

        {
            //sets newrug variable to every index of the RugList(aka every Rug object, on loop)
            Rug newrug = the_list.get(j);

            //if what is typed in by the user matches a rug's product code, execute code below
            if (removeposition.equalsIgnoreCase(newrug.getProductcode()))

            {
                //set boolean to true to indicate a match was made
                ismatch = true;
                the_list.remove(newrug);
                Toast.makeText(RemoveItemActivity.this, "Rug Removed.",
                        Toast.LENGTH_SHORT).show();

            }
         }

        //ismatch is only true when there is a successful match, therefore if false, no product code match
        if (!ismatch)

        {
            Toast.makeText(RemoveItemActivity.this, "There is no Rug with this Product Code.",
                    Toast.LENGTH_SHORT).show();
        }

        //if the list is empty, Toast this message
        if (the_list.isEmpty())
        {

            Toast.makeText(RemoveItemActivity.this, "List is empty. Please add a Rug via one of the appropriate options.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}







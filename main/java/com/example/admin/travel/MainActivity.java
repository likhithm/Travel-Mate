package com.example.admin.travel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
     private static Button button_1,button_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnClickButtonListener();
    }

    public void OnClickButtonListener(){
        button_1 = (Button)findViewById(R.id.button);
        button_2= (Button)findViewById(R.id.button2);

        button_1.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent("com.example.admin.travel.Main11Activity");
                    startActivity(i);
                }
            }
        );
        button_2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent("com.example.admin.travel.Main12Activity");
                        startActivity(i);
                    }
                }
        );

    }

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
        if (id == R.id.action_planner) {
            Intent i = new Intent("com.example.admin.travel.RoutePlanner");
            startActivity(i);
        }
        if (id == R.id.action_1) {
            Intent i = new Intent("com.example.admin.travel.TravelDaily");
            startActivity(i);
        }
        if (id == R.id.action_2) {
            Intent i = new Intent("com.example.admin.travel.AboutUs");
            startActivity(i);
        }




        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

}

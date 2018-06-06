package com.example.admin.travel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TravelDaily extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_daily);

        ArrayList image_details = getListData();
        final ListView lv1 = (ListView) findViewById(R.id.custom_list);
        lv1.setAdapter(new CustomListAdapter(this, image_details));
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                Toast.makeText(TravelDaily.this, "shortly..." + " ", Toast.LENGTH_LONG).show();
            }
        });
    }


    private ArrayList getListData() {
        ArrayList<NewsItem> results = new ArrayList<NewsItem>();
        NewsItem newsData = new NewsItem();
        newsData.setHeadline("Travel Daily Quotes");
        newsData.setReporterName(" “One’s destination is never a place, but a new way of seeing things.” – Henry Miller\n" +
                "\n");
        newsData.setDate("");
        results.add(newsData);

        newsData.setHeadline("Travel Daily Quotes");
        newsData.setReporterName("Travel is very subjective. What one person loves, another loathes.");
        newsData.setDate("");
        results.add(newsData);
        newsData.setHeadline("Travel Daily Quotes");
        newsData.setReporterName(" “One’s destination is never a place, but a new way of seeing things.” – Henry Miller\n" +
                "\n");
        newsData.setDate("");
        results.add(newsData);
        newsData.setHeadline("Travel Daily Quotes");
        newsData.setReporterName(" “One’s destination is never a place, but a new way of seeing things.” – Henry Miller\n" +
                "\n");
        newsData.setDate("");
        results.add(newsData);
        newsData.setHeadline("Travel Daily Quotes");
        newsData.setReporterName(" “One’s destination is never a place, but a new way of seeing things.” – Henry Miller\n" +
                "\n");
        newsData.setDate("");
        results.add(newsData);
        newsData.setHeadline("Travel Daily Quotes");
        newsData.setReporterName(" “One’s destination is never a place, but a new way of seeing things.” – Henry Miller\n" +
                "\n");
        newsData.setDate("");
        results.add(newsData);
        newsData.setHeadline("Travel Daily Quotes");
        newsData.setReporterName(" “One’s destination is never a place, but a new way of seeing things.” – Henry Miller\n" +
                "\n");
        newsData.setDate("");
        results.add(newsData);
        newsData.setHeadline("Travel Daily Quotes");
        newsData.setReporterName(" “One’s destination is never a place, but a new way of seeing things.” – Henry Miller\n" +
                "\n");
        newsData.setDate("");
        results.add(newsData);
        newsData.setHeadline("Travel Daily Quotes");
        newsData.setReporterName(" “One’s destination is never a place, but a new way of seeing things.” – Henry Miller\n" +
                "\n");
        newsData.setDate("Feb 18, 2016, 7:35");
        results.add(newsData);
        newsData.setHeadline("Travel Daily Quotes");
        newsData.setReporterName("Travel is very subjective.What one person loves, another loathes.");
        newsData.setDate("");
        results.add(newsData);
        newsData.setHeadline("Travel Daily Quotes");
        newsData.setReporterName(" “One’s destination is never a place, but a new way of seeing things.” – Henry Miller\n" +
                "\n");
        newsData.setDate("");
        results.add(newsData);
        newsData.setHeadline("Travel Daily Quotes");
        newsData.setReporterName(" “One’s destination is never a place, but a new way of seeing things.” – Henry Miller\n" +
                "\n");
        newsData.setDate("");
        results.add(newsData);
        newsData.setHeadline("Travel Daily Quotes");
        newsData.setReporterName(" “One’s destination is never a place, but a new way of seeing things.” – Henry Miller\n" +
                "\n");
        newsData.setDate("");
        results.add(newsData);
        newsData.setHeadline("Travel Daily Quotes");
        newsData.setReporterName(" “One’s destination is never a place, but a new way of seeing things.” – Henry Miller\n" +
                "\n");
        newsData.setDate("");
        results.add(newsData);
        newsData.setHeadline("Travel Daily Quotes");
        newsData.setReporterName(" “One’s destination is never a place, but a new way of seeing things.” – Henry Miller\n" +
                "\n");
        newsData.setDate("");
        results.add(newsData);
        newsData.setHeadline("Travel Daily Quotes");
        newsData.setReporterName(" “One’s destination is never a place, but a new way of seeing things.” – Henry Miller\n" +
                "\n");
        newsData.setDate("");
        results.add(newsData);
        newsData.setHeadline("Travel Daily Quotes");
        newsData.setReporterName(" “One’s destination is never a place, but a new way of seeing things.” – Henry Miller\n" +
                "\n");
        newsData.setDate("");
        results.add(newsData);
        newsData.setHeadline("Travel Daily Quotes");
        newsData.setReporterName(" “One’s destination is never a place, but a new way of seeing things.” – Henry Miller\n" +
                "\n");
        newsData.setDate("");
        results.add(newsData);
        newsData.setHeadline("Travel Daily Quotes");
        newsData.setReporterName(" “One’s destination is never a place, but a new way of seeing things.” – Henry Miller\n" +
                "\n");
        newsData.setDate("");
        results.add(newsData);
        newsData.setHeadline("Travel Daily Quotes");
        newsData.setReporterName(" “One’s destination is never a place, but a new way of seeing things.” – Henry Miller\n" +
                "\n");
        newsData.setDate("");
        results.add(newsData);



        // Add some more dummy data for testing
        return results;

    }
}

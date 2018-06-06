package com.example.admin.travel;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
public class NineActivity extends ActionBarActivity {

    // json object response url
    private String urlJsonObj = "http://travelmate.gear.host/json.php";

    // json array response url
    int value=0;

    // Progress dialog
    private ProgressDialog pDialog;

    private TextView txtResponse;
    private TextView name;
    private TextView url;
    private NetworkImageView networkImageView;
    private Context mcontext;
    RequestQueue requestQueue;
    private ImageLoader imageLoader;


    // temporary string to show the parsed response
    private String jsonResponse;

    public NineActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine);
        String turl = "http://i.imgur.com/7spzG.png";
        networkImageView = (NetworkImageView) findViewById(R.id.profilePic2);
        value = getIntent().getExtras().getInt("valu");
        networkImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        networkImageView.requestLayout();

        imageLoader = MySingleton.getInstance(mcontext).getImageLoader();
        requestQueue = Volley.newRequestQueue(this);
        txtResponse = (TextView) findViewById(R.id.txtStatusMsg);
        name = (TextView) findViewById(R.id.name1);
       /* Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(urlJsonObj);
        if (entry != null) {
            // fetch the data from cache
            try {
                String data = new String(entry.data, "UTF-8");
                try {
                    parseJsonFeed(new JSONObject(data));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else {*/
            // making fresh volley request and getting json
        RequestQueue queue = Volley.newRequestQueue(this);
            JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET,
                    urlJsonObj, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {

                    if (response != null) {
                        parseJsonFeed(response);
                    }
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                }

            });

            // Adding request to volley request queue
        queue.add(jsonReq);
        }


    // Adding request to request queue
    private void parseJsonFeed(JSONObject response) {

        try {

            JSONArray feed = response.getJSONArray("feed");
            JSONObject data = (JSONObject) feed.get(value);

            // Parsing json object response
            // response will be a json object

            String status = data.getString("status");
            txtResponse.setText(status);
            String names = data.getString("name");
            name.setText(names);

            String img = data.getString("profilePic");
            imageLoader = MySingleton.getInstance(mcontext).getImageLoader();


// Set the URL of the image that should be loaded into this view, and
// specify the ImageLoader that will be used to make the request.
            networkImageView.setImageUrl(img, imageLoader);

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),
                    "Error: " + e.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
    }
    public void onBackPressed() {

        Intent intent;
        intent = new Intent(NineActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(intent);


    }
}
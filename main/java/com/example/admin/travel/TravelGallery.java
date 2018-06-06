package com.example.admin.travel;

/**
 * Created by Sharu on 14/4/2016.
 */
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class TravelGallery extends Activity implements OnClickListener {

    protected static TextView textView;
    protected static ImageView image1, image2;
    protected Button get_image, save_image, read_image;
    private String selectedImagePath;
    private static final int SELECT_PICTURE = 5;
    String DB_NAME = Environment.getExternalStorageDirectory() + "/test.db";
    String TABLE_NAME = "mytable";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_gallery);

        image1 = (ImageView) findViewById(R.id.imageView1);
        image2 = (ImageView) findViewById(R.id.imageView2);
        textView = (TextView) findViewById(R.id.textView1);

        get_image = (Button) findViewById(R.id.get_image);
        get_image.setOnClickListener(this);

        save_image = (Button) findViewById(R.id.save_image);
        save_image.setOnClickListener(this);

        read_image = (Button) findViewById(R.id.read_image);
        read_image.setOnClickListener(this);

    }

    public void onClick(View v) {

        int id = v.getId();
        switch (id) {

            case R.id.get_image:
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(
                        Intent.createChooser(intent, "Select Picture"),
                        SELECT_PICTURE);
                break;

            case R.id.save_image:
                createTable();
                saveInDB();
                break;

            case R.id.read_image:
                readFromDB();
                break;
            default:
                break;

        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                selectedImagePath = getPath(selectedImageUri);
                System.out.println("Image Path : " + selectedImagePath);
                image1.setVisibility(View.VISIBLE);
                image1.setImageURI(selectedImageUri);
            }
        }
    }

    @SuppressWarnings("deprecation")
    public String getPath(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    void createTable() {
        SQLiteDatabase myDb = openOrCreateDatabase(DB_NAME,
                Context.MODE_PRIVATE, null);
        String MySQL = "create table if not exists "
                + TABLE_NAME
                + " (_id INTEGER primary key autoincrement, name TEXT not null, image BLOB);";
        myDb.execSQL(MySQL);
        myDb.close();
    }

    void saveInDB() {
        SQLiteDatabase myDb = openOrCreateDatabase(DB_NAME,
                Context.MODE_PRIVATE, null);
        byte[] byteImage1 = null;
        String s = myDb.getPath();
        myDb.execSQL("delete from " + TABLE_NAME);          // clearing the table
        ContentValues newValues = new ContentValues();
        String name = "TravelMate";
        newValues.put("name", name);
        try {
            FileInputStream instream = new FileInputStream(selectedImagePath);
            BufferedInputStream bif = new BufferedInputStream(instream);
            byteImage1 = new byte[bif.available()];
            bif.read(byteImage1);
            newValues.put("image", byteImage1);
            long ret = myDb.insert(TABLE_NAME, null, newValues);
            if (ret < 0)
                textView.append("Error");
        } catch (IOException e) {
            textView.append("Error Exception : " + e.getMessage());
        }
        myDb.close();
        textView.append("\n Saving Details \n Name : " + name);
        textView.append("\n Image Size : " + byteImage1.length + " KB");
        textView.append("\n Saved in DB : " + s + "\n");
        Toast.makeText(this.getBaseContext(),
                "Image Saved in DB successfully.", Toast.LENGTH_SHORT).show();
    }

    void readFromDB() {
        byte[] byteImage2 = null;
        SQLiteDatabase myDb;
        myDb = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
        Cursor cur = myDb.query(TABLE_NAME, null, null, null, null, null, null);
        cur.moveToFirst();
        while (cur.isAfterLast() == false) {
            textView.append("\n Reading Details \n Name : " + cur.getString(1));
            cur.moveToNext();
        }

        // /////Read data from blob field////////////////////
        cur.moveToFirst();
        byteImage2 = cur.getBlob(cur.getColumnIndex("image"));
        setImage(byteImage2);
        cur.close();
        myDb.close();
        Toast.makeText(this.getBaseContext(),
                "Image read from DB successfully.", Toast.LENGTH_SHORT).show();
        Toast.makeText(this.getBaseContext(),
                "If your image is big, please scrolldown to see the result.",
                Toast.LENGTH_SHORT).show();
    }

    void setImage(byte[] byteImage2) {
        image2.setImageBitmap(BitmapFactory.decodeByteArray(byteImage2, 0,
                byteImage2.length));
        textView.append("\n Image Size : " + byteImage2.length + " KB");
    }
}

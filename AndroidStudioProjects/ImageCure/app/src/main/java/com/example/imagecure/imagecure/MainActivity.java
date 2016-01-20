package com.example.imagecure.imagecure;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private GridViewAdapter gridAdapter;
    int animal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up the grid view for the main activity
        gridView = (GridView) findViewById(R.id.gridview);
        gridAdapter = new GridViewAdapter(this, R.layout.grid_item_layout, getData());
        gridView.setAdapter(gridAdapter);

        //
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ImageItem item = (ImageItem) parent.getItemAtPosition(position);

                //Create intent
                Intent intent = new Intent(MainActivity.this, DisplayImage.class);
                intent.putExtra("ImageSet", animal);
                intent.putExtra("Button", position);

                //Start details activity
                startActivity(intent);
            }
        });

        //set up the toolbar in the main activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //set up the imagebutton for instagram function inside the main activity
        ImageButton imageButton = (ImageButton) findViewById(R.id.insta_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create intent
                Intent intent = new Intent(MainActivity.this, DisplayInstaImage.class);
                //Start details activity
                startActivity(intent);

            }
        });
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
        final int id = item.getItemId();
        Context context = getApplicationContext();
        CharSequence cat = "Cat";
        CharSequence dog = "Dog";
        int duration = Toast.LENGTH_SHORT;

        if (id == R.id.action_cat) {
            animal = 1;
            Toast t = Toast.makeText(context, cat, duration);
            t.show();
        }
        if (id == R.id.action_dog) {
            animal = 2;
            Toast t = Toast.makeText(context, dog, duration);
            t.show();
        }
        return true;
    }

    /**
     * set up both the images and titles for every item inside the arraylist of imageitem
     * @return arraylist
     */
    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
        String[] label = {"Happy","Stressed","Angry","Excited","Nervous","Sad"};
        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, label[i]));
        }
        return imageItems;
    }
}




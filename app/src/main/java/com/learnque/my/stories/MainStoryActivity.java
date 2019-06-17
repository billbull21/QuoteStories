package com.learnque.my.stories;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.bumptech.glide.Glide;

public class MainStoryActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_QUOTE = "extra_quote";
    public static final String EXTRA_IMAGE = "extra_image";

    TextView quote, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_story);

        quote = findViewById(R.id.tv_item_quote);
        title = findViewById(R.id.toolbar_title);

        String _title = getIntent().getStringExtra(EXTRA_NAME);
        String quote_value = getIntent().getStringExtra(EXTRA_QUOTE);

        title.setText(_title);
        quote.setText(quote_value);

        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_story);
        setSupportActionBar(toolbar);

        ImageView photo = (ImageView) findViewById(R.id.tv_item_image);
        String image = getIntent().getStringExtra(EXTRA_IMAGE);
        Glide.with(this).load(image).into(photo);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}

package com.learnque.my.stories;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCategory;
    private ArrayList<People> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(PeopleData.getListData());
        showRecyclerList();

        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_story);
        setSupportActionBar(toolbar);
    }

    private void showSelectedStatus(People people){
        Intent moveIntent = new Intent(MainActivity.this, MainStoryActivity.class);

        moveIntent.putExtra(MainStoryActivity.EXTRA_NAME, people.getName());
        moveIntent.putExtra(MainStoryActivity.EXTRA_QUOTE, people.getQuote());
        moveIntent.putExtra(MainStoryActivity.EXTRA_IMAGE, people.getPhoto());
        startActivity(moveIntent);
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListPeopleAdapter listPeopleAdapter = new ListPeopleAdapter(this);
        listPeopleAdapter.setPeopleList(list);
        rvCategory.setAdapter(listPeopleAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedStatus(list.get(position));
            }
        });
    }


}

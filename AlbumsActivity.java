package com.fasttech.music;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridLayout;

import java.util.ArrayList;

public class AlbumsActivity extends AppCompatActivity  {
     RecyclerView recyclerView;
     RecyclerView.LayoutManager layoutManager;
     RecyclerView.Adapter adapter;
    ArrayList<Albums> albumsArrayList;

    void initList(){
       // ActionBar actionBar = getSupportActionBar();
        //actionBar.hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Albums a1 = new Albums(R.drawable.badri,"Badri Ki Dulhania");
        Albums a2 = new Albums(R.drawable.aedil,"Ae Dil Hai Mushkil");
        Albums a3 = new Albums(R.drawable.mubar,"Mubarakan");
        Albums a4 = new Albums(R.drawable.munna,"Munna Michael");
        Albums a5 = new Albums(R.drawable.half,"Half Girlfriend");
        Albums a6 = new Albums(R.drawable.raabta,"Raabta");
        Albums a7 = new Albums(R.drawable.jagga,"Jagga Jasoos");
        Albums a8 = new Albums(R.drawable.guest,"Guest in London");
        Albums a9 = new Albums(R.drawable.hindi,"Hindi Medium");
        Albums a10 = new Albums(R.drawable.tube,"TubeLight");

        albumsArrayList =  new ArrayList<>();
        albumsArrayList.add(a2);
        albumsArrayList.add(a1);
        albumsArrayList.add(a8);
        albumsArrayList.add(a5);
        albumsArrayList.add(a9);
        albumsArrayList.add(a7);
        albumsArrayList.add(a3);
        albumsArrayList.add(a4);
        albumsArrayList.add(a6);
        albumsArrayList.add(a10);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);
        initList();
        recyclerView = (RecyclerView)findViewById(R.id.albums);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AlbumsAdapter(albumsArrayList,this);
        recyclerView.setAdapter(adapter);
    }
}

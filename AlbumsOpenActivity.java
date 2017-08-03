package com.fasttech.music;

import android.app.Fragment;
import android.content.Intent;
import android.os.Environment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.File;

public class AlbumsOpenActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView listView;
    ImageView imageView;
    ArrayAdapter<String> adapter;


    public void initList(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Intent rcv = getIntent();
        listView = (ListView)findViewById(R.id.songslist);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        File file = new File(path);
        String files[] = file.list();
        imageView = (ImageView)findViewById(R.id.albumsopenimage);
        imageView.setBackgroundResource(getIntent().getIntExtra("KeyImg",0));
        String name = rcv.getStringExtra("KeyName");
        getSupportActionBar().setTitle(name);
        switch (name){
            case "Ae Dil Hai Mushkil":
                for(String str :files){
                    if (str.endsWith(".mp3") && (str.startsWith("Ae dil hai mushkil"))){
                            adapter.add(str);
                    }
                }
                break;
            case "Badri Ki Dulhania":
                for(String str :files){
                    if (str.endsWith(".mp3") && (str.startsWith("Badri Ki Dulhania"))){
                        adapter.add(str);
                    }
                }
                break;
            case "Jagga Jasoos":
                for(String str :files){
                    if (str.endsWith(".mp3") && (str.startsWith("Jagga Jasoos"))){
                        adapter.add(str);
                    }
                }
                break;
            case "Munna Michael":
                for(String str :files){
                    if (str.endsWith(".mp3") && (str.startsWith("Munna Michael"))){
                        adapter.add(str);
                    }
                }
                break;
            case "Mubarakan":
                for(String str :files){
                    if (str.endsWith(".mp3") && (str.startsWith("Mubarakan"))){
                        adapter.add(str);
                    }
                }
                break;

        }
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums_open);
        initList();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String songName = adapter.getItem(i);
        Intent intent = new Intent(AlbumsOpenActivity.this,TracksActivity.class);
        intent.putExtra("KeyN",songName);
        startActivity(intent);
    }



}

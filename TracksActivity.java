package com.fasttech.music;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class TracksActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button btnp,btns;
    boolean isPlaying;


    void init() {
        Intent rcv = getIntent();
        String sname = rcv.getStringExtra("KeyN");
        textView = (TextView)findViewById(R.id.textView);
        btnp = (Button)findViewById(R.id.button);
        btns = (Button)findViewById(R.id.button2);
        textView.setText(sname);
        btnp.setOnClickListener(this);
        btns.setOnClickListener(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracks);
        init();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        String songName = textView.getText().toString().trim();
        if(id==R.id.button){
            if(!isPlaying){
            Intent intent = new Intent(TracksActivity.this,MusicService.class);
            intent.putExtra("KeySong",songName);
            startService(intent);
            isPlaying = true;
            }else{
                Toast.makeText(this,songName+"is already playing",Toast.LENGTH_LONG).show();
            }
        }else{
            Intent intent = new Intent(TracksActivity.this,MusicService.class);
            stopService(intent);
            isPlaying = false;

        }
    }
}

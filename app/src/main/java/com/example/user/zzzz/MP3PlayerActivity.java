package com.example.user.zzzz;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;


public class MP3PlayerActivity extends AppCompatActivity {

    private MediaPlayer mp=null;
    private Button btn3,btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp3_player);
        btn3=findViewById(R.id.btn3);

    }

    public void clkBtn(View v) {
        getSupportActionBar().setTitle(R.string.musicname);
        Log.i("test","clkBtn:"+v.getId());

        switch (v.getId()){

            case R.id.btn1:
                _dostop();
                btn3.setText(R.string.musicpush);
                mp = MediaPlayer.create(MP3PlayerActivity.this,R.raw.buzz1);
                mp.start();
                break;

            case R.id.btn2:
                _dostop();
                btn3.setText(R.string.musicpush);
                mp = MediaPlayer.create(MP3PlayerActivity.this,R.raw.buzz2);
                mp.start();
                break;

            case R.id.btn3:
                if(mp==null){
                    return;
                }
                Button btn = (Button)v;
                String txt = btn.getText().toString();
                if(txt.equals(getString(R.string.musicpush))){
                    btn.setText(R.string.play); //재생
                   mp.pause();
                }else {
                 btn.setText(R.string.musicpush);  //일시정지
                    mp.start();
                }
                break;

            case R.id.btn4:

            btn3.setText(R.string.musicpush);

                    _dostop();
                break;
        }
    }

    private void _dostop() {
        if(mp !=null) {
            mp.stop();
            mp.release();
            mp=null;
        }
    }
}

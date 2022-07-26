package com.example.test12_2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button controlButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.jazz_in_paris);
        //mediaPlayer.start();

        controlButton = findViewById(R.id.button_control);
        controlButton.setText("시작");
        controlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    controlButton.setText("시작");
                } else {
                    mediaPlayer.start();
                    controlButton.setText("일시정지");
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
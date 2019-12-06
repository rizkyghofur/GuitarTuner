package com.rizkyghofur.guitartuner;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.view.ViewCompat;

public class MainActivity extends Activity implements OnClickListener {

    private MediaPlayer mediaPlayer;
    private Button EButton;
    private Button AButton;
    private Button BButton;
    private Button GButton;
    private Button DButton;
    private Button E2Button;
    TextView txtE;
    TextView txtA;
    TextView txtD;
    TextView txtG;
    TextView txtB;
    TextView txtE2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EButton = findViewById(R.id.Ebtn);
        AButton = findViewById(R.id.Abtn);
        DButton = findViewById(R.id.Dbtn);
        GButton = findViewById(R.id.Gbtn);
        BButton = findViewById(R.id.Bbtn);
        E2Button = findViewById(R.id.E2btn);

        EButton.setOnClickListener(this);
        AButton.setOnClickListener(this);
        DButton.setOnClickListener(this);
        GButton.setOnClickListener(this);
        BButton.setOnClickListener(this);
        E2Button.setOnClickListener(this);

        txtE = findViewById(R.id.textView);
        txtA = findViewById(R.id.textView2);
        txtD = findViewById(R.id.textView3);
        txtG = findViewById(R.id.textView4);
        txtB = findViewById(R.id.textView5);
        txtE2 = findViewById(R.id.textView6);

        txtE.bringToFront();
        txtE.invalidate();
        txtE.requestLayout();
        ViewCompat.setTranslationZ(txtE, 1000);

        txtA.bringToFront();
        txtA.invalidate();
        txtA.requestLayout();
        ViewCompat.setTranslationZ(txtA, 1000);

        txtD.bringToFront();
        txtD.invalidate();
        txtD.requestLayout();
        ViewCompat.setTranslationZ(txtD, 1000);

        txtG.bringToFront();
        txtG.invalidate();
        txtG.requestLayout();
        ViewCompat.setTranslationZ(txtG, 1000);

        txtB.bringToFront();
        txtB.invalidate();
        txtB.requestLayout();
        ViewCompat.setTranslationZ(txtB, 1000);

        txtE2.bringToFront();
        txtE2.invalidate();
        txtE2.requestLayout();
        ViewCompat.setTranslationZ(txtE2, 1000);
    }

    @Override
    public void onClick(View arg0){
        switch (arg0.getId()) {
            case R.id.Ebtn:
                playSound(1);
                break;
            case R.id.Abtn:
                playSound(2);
                break;
            case R.id.Dbtn:
                playSound(3);
                break;
            case R.id.Gbtn:
                playSound(4);
                break;
            case R.id.Bbtn:
                playSound(5);
                break;
            case R.id.E2btn:
                playSound(6);
                break;
        }
    }

    private void playSound(int i){
        try{
            if (mediaPlayer.isPlaying()){
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        }
        catch (Exception e){

        }
        switch (i){
            case 1:
                mediaPlayer = MediaPlayer.create(this, R.raw.e_tune);
                break;
            case 2:
                mediaPlayer = MediaPlayer.create(this, R.raw.a_tune);
                break;
            case 3:
                mediaPlayer = MediaPlayer.create(this, R.raw.d_tune);
                break;
            case 4:
                mediaPlayer = MediaPlayer.create(this, R.raw.g_tune);
                break;
            case 5:
                mediaPlayer = MediaPlayer.create(this, R.raw.b_tune);
                break;
            case 6:
                mediaPlayer = MediaPlayer.create(this, R.raw.em_tune);
                break;
        }
        mediaPlayer.start();
    }
    public void onPause(){
        try{
            super.onPause();
            mediaPlayer.pause();
        } catch (Exception e){
        }
    }
    public void onStop(){
        super.onStop();
        mediaPlayer.stop();
    }
}

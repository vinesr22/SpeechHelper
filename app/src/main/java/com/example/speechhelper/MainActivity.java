package com.example.speechhelper;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.view.View;
import android.media.SoundPool.OnLoadCompleteListener;
import android.app.Activity;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    private SoundPool soundPool;
    private int letter_ID,letter_a_ID,letter_b_ID,letter_c_ID,letter_d_ID,letter_e_ID,letter_f_ID;
    AudioManager audioManager;

    boolean loaded = false;
    float actVolume, maxVolume, volume;

    private static final int MAX_NUMBER_STREAMS = 5;
    private static final int streamType = AudioManager.STREAM_MUSIC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // AudioManager audio settings for adjusting the volume
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        // Current volumn Index of particular stream type.
        actVolume = (float) audioManager.getStreamVolume(streamType);
        // Get the maximum volume index for a particular stream type.
        maxVolume = (float) audioManager.getStreamMaxVolume(streamType);
        // Volumn (0 --> 1)
        volume = actVolume/maxVolume;

        // Suggests an audio stream whose volume should be changed by
        // the hardware volume controls.
        this.setVolumeControlStream(streamType);


        soundPool = new SoundPool(MAX_NUMBER_STREAMS, streamType, 0);

        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                //use to know when sound has finished its asynchronous loading
                loaded = true;
            }
        });
        letter_a_ID = soundPool.load(this, R.raw.letter_a, 1);
        letter_b_ID = soundPool.load(this, R.raw.letter_b, 1);
        letter_c_ID = soundPool.load(this, R.raw.letter_c, 1);
        letter_d_ID = soundPool.load(this, R.raw.letter_d, 1);
        letter_e_ID = soundPool.load(this, R.raw.letter_e, 1);
        letter_f_ID = soundPool.load(this, R.raw.letter_f, 1);

    }

    public void playSound(View v){
        if(loaded) {
            letter_ID = getLetter_ID(v.getTag().toString());
            soundPool.play(letter_ID, volume, volume, 1, 0, 1f);
        }
    }

    public int getLetter_ID(String letter_ID_case){
        letter_ID = 0;

        switch(letter_ID_case){
            case "A":
                letter_ID = letter_a_ID;
                break;
            case "B":
                letter_ID = letter_b_ID;
                break;
            case "C":
                letter_ID = letter_c_ID;
                break;
            case "D":
                letter_ID = letter_d_ID;
                break;
            case "E":
                letter_ID = letter_e_ID;
                break;
            case "F":
                letter_ID = letter_f_ID;
                break;
            default:
                //letter not handled
        }
        if(letter_ID != 0) {
            Toast.makeText(getApplicationContext(), letter_ID_case + " selected", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), letter_ID_case + " not supported", Toast.LENGTH_SHORT).show();
        }
        //Toast.makeText(getApplicationContext(),Integer.toString(letter_ID) + " ID", Toast.LENGTH_SHORT).show();
        return letter_ID;
    }

}

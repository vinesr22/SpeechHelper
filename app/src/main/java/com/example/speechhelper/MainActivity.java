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
    private int ID,letters_ID,letter_a_ID,letter_b_ID,letter_c_ID,letter_d_ID,letter_e_ID,letter_f_ID;
    private int letter_g_ID,letter_h_ID,letter_i_ID,letter_j_ID,letter_k_ID,letter_l_ID,letter_m_ID;
    private int letter_n_ID,letter_o_ID,letter_p_ID,letter_q_ID,letter_r_ID,letter_s_ID,letter_t_ID;
    private int letter_u_ID,letter_v_ID,letter_w_ID,letter_x_ID,letter_y_ID,letter_z_ID, buzzer_ID;
    private int numbers_ID,number_0_ID,number_1_ID,number_2_ID,number_3_ID,number_4_ID,number_5_ID;
    private int number_6_ID,number_7_ID,number_8_ID,number_9_ID,number_10_ID;
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
        letters_ID = soundPool.load(this, R.raw.letters, 1);
        letter_a_ID = soundPool.load(this, R.raw.letter_a, 1);
        letter_b_ID = soundPool.load(this, R.raw.letter_b, 1);
        letter_c_ID = soundPool.load(this, R.raw.letter_c, 1);
        letter_d_ID = soundPool.load(this, R.raw.letter_d, 1);
        letter_e_ID = soundPool.load(this, R.raw.letter_e, 1);
        letter_f_ID = soundPool.load(this, R.raw.letter_f, 1);
        letter_g_ID = soundPool.load(this, R.raw.letter_g, 1);
        letter_h_ID = soundPool.load(this, R.raw.letter_h, 1);
        letter_i_ID = soundPool.load(this, R.raw.letter_i, 1);
        letter_j_ID = soundPool.load(this, R.raw.letter_j, 1);
        letter_k_ID = soundPool.load(this, R.raw.letter_k, 1);
        letter_l_ID = soundPool.load(this, R.raw.letter_l, 1);
        letter_m_ID = soundPool.load(this, R.raw.letter_m, 1);
        letter_n_ID = soundPool.load(this, R.raw.letter_n, 1);
        letter_o_ID = soundPool.load(this, R.raw.letter_o, 1);
        letter_p_ID = soundPool.load(this, R.raw.letter_p, 1);
        letter_q_ID = soundPool.load(this, R.raw.letter_q, 1);
        letter_r_ID = soundPool.load(this, R.raw.letter_r, 1);
        letter_s_ID = soundPool.load(this, R.raw.letter_s, 1);
        letter_t_ID = soundPool.load(this, R.raw.letter_t, 1);
        letter_u_ID = soundPool.load(this, R.raw.letter_u, 1);
        letter_v_ID = soundPool.load(this, R.raw.letter_v, 1);
        letter_w_ID = soundPool.load(this, R.raw.letter_w, 1);
        letter_x_ID = soundPool.load(this, R.raw.letter_x, 1);
        letter_y_ID = soundPool.load(this, R.raw.letter_y, 1);
        letter_z_ID = soundPool.load(this, R.raw.letter_z, 1);
        buzzer_ID = soundPool.load(this, R.raw.buzzer, 1);
        numbers_ID = soundPool.load(this, R.raw.numbers, 1);
        number_0_ID = soundPool.load(this, R.raw.number_0, 1);
        number_1_ID = soundPool.load(this, R.raw.number_1, 1);
        number_2_ID = soundPool.load(this, R.raw.number_2, 1);
        number_3_ID = soundPool.load(this, R.raw.number_3, 1);
        number_4_ID = soundPool.load(this, R.raw.number_4, 1);
        number_5_ID = soundPool.load(this, R.raw.number_5, 1);
        number_6_ID = soundPool.load(this, R.raw.number_6, 1);
        number_7_ID = soundPool.load(this, R.raw.number_7, 1);
        number_8_ID = soundPool.load(this, R.raw.number_8, 1);
        number_9_ID = soundPool.load(this, R.raw.number_9, 1);
        number_10_ID = soundPool.load(this, R.raw.number_10, 1);
    }

    public void playSound(View v){
        if(loaded) {
            ID = get_ID(v.getTag().toString());
            soundPool.play(ID, volume, volume, 1, 0, 1f);
        }
    }

    public int get_ID(String ID_case){
        ID = 0;

        switch(ID_case){
            case "LETTERS":
                ID = letters_ID;
                break;
            case "A":
                ID = letter_a_ID;
                break;
            case "B":
                ID = letter_b_ID;
                break;
            case "C":
                ID = letter_c_ID;
                break;
            case "D":
                ID = letter_d_ID;
                break;
            case "E":
                ID = letter_e_ID;
                break;
            case "F":
                ID = letter_f_ID;
                break;
            case "G":
                ID = letter_g_ID;
                break;
            case "H":
                ID = letter_h_ID;
                break;
            case "I":
                ID = letter_i_ID;
                break;
            case "J":
                ID = letter_j_ID;
                break;
            case "K":
                ID = letter_k_ID;
                break;
            case "L":
                ID = letter_l_ID;
                break;
            case "M":
                ID = letter_m_ID;
                break;
            case "N":
                ID = letter_n_ID;
                break;
            case "O":
                ID = letter_o_ID;
                break;
            case "P":
                ID = letter_p_ID;
                break;
            case "Q":
                ID = letter_q_ID;
                break;
            case "R":
                ID = letter_r_ID;
                break;
            case "S":
                ID = letter_s_ID;
                break;
            case "T":
                ID = letter_t_ID;
                break;
            case "U":
                ID = letter_u_ID;
                break;
            case "V":
                ID = letter_v_ID;
                break;
            case "W":
                ID = letter_w_ID;
                break;
            case "X":
                ID = letter_x_ID;
                break;
            case "Y":
                ID = letter_y_ID;
                break;
            case "Z":
                ID = letter_z_ID;
                break;
            case "BUZZER":
                ID = buzzer_ID;
                break;
            case "NUMBERS":
                ID = numbers_ID;
                break;
            case "0":
                ID = number_0_ID;
                break;
            case "1":
                ID = number_1_ID;
                break;
            case "2":
                ID = number_2_ID;
                break;
            case "3":
                ID = number_3_ID;
                break;
            case "4":
                ID = number_4_ID;
                break;
            case "5":
                ID = number_5_ID;
                break;
            case "6":
                ID = number_6_ID;
                break;
            case "7":
                ID = number_7_ID;
                break;
            case "8":
                ID = number_8_ID;
                break;
            case "9":
                ID = number_9_ID;
                break;
            case "10":
                ID = number_10_ID;
                break;
            default:
                //letter/number not handled
        }
        if(ID != 0) {
           // Toast.makeText(getApplicationContext(), ID_case + " selected", Toast.LENGTH_SHORT).show();
        }
        else {
          //  Toast.makeText(getApplicationContext(), ID_case + " not supported", Toast.LENGTH_SHORT).show();
        }
        //Toast.makeText(getApplicationContext(),Integer.toString(ID) + " ID", Toast.LENGTH_SHORT).show();
        return ID;
    }

}

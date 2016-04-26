package com.example.android.happybirthday;

import android.app.FragmentManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mPlayer;
    private RetainedFragment dataFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView myTextView = (TextView) findViewById(R.id.happy_birthday);
        myTextView.setSelected(true);

        // find the retained fragment on activity restarts
        FragmentManager fm = getFragmentManager();
        dataFragment = (RetainedFragment) fm.findFragmentByTag("data");

        if (dataFragment == null) {
            dataFragment = new RetainedFragment();
            fm.beginTransaction().add(dataFragment, "data").commit();
            mPlayer = MediaPlayer.create(this, R.raw.icantimagineme);
            mPlayer.start();
            dataFragment.setData(mPlayer);
        }
        else {
            mPlayer = dataFragment.getData();
        }

    }
}

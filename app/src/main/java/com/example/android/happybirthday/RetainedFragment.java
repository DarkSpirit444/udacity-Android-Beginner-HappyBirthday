package com.example.android.happybirthday;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by davidteo on 3/19/2016.
 */
public class RetainedFragment extends Fragment {

    // data object we want to retain
    private MediaPlayer data;

    // this method is only called once for this fragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // retain this fragment
        setRetainInstance(true);
    }

    public void setData(MediaPlayer data) {
        this.data = data;
    }

    public MediaPlayer getData() {
        return data;
    }
}

package com.wrightcontrol.app.mainscreen.mainscreen.mainbuttons;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.wrightcontrol.app.R;

/**
 * Created by Grant on 08/10/2015.
 */
public class MainFragment extends Fragment {
    private static final String TAG = "MAIN_FRAGMENT";
    private CheckBox checkBox;

    //Vars for soundpool, bang and ding audio
    private SoundPool soundPool;
    private int bang;
    private int ding;
    private boolean hasEffect = false;

    //Vars for the new soundpool object
    private final int maxStreams = 5;
    private final int streamType = AudioManager.STREAM_MUSIC;
    private final int srcQuality = 0;

    //vars for the soundpool.load
    private final int loadPriority = 1;

    //Vars for soundpool.play
    private final float leftVolume = 1;
    private final float rightVolume = 1;
    private final int playPriority = 0;
    private final int loop = 0;
    private final float rate = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        loadBangDing();

        Button bangBtn = (Button) view.findViewById(R.id.button_bang);
        bangBtn.setOnClickListener(new Clicker());

        Button dingBtn = (Button) view.findViewById(R.id.button_ding);
        dingBtn.setOnClickListener(new Clicker());

        checkBox = (CheckBox) view.findViewById(R.id.checkbox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.i(TAG, String.valueOf(b));
                hasEffect = b;
                loadBangDing();
            }
        });

        return view;
    }

    /**
     * creates a SoundPool object and loads the
     * appropriate MP3 audio file
     */
    private void loadBangDing() {
        soundPool = new SoundPool(maxStreams, streamType, srcQuality);
        if(!hasEffect) {
            bang = soundPool.load(getContext(), R.raw.bang_proj_mptree, loadPriority);
            ding = soundPool.load(getContext(), R.raw.ding_proj_mptree, loadPriority);
        }else {
            bang = soundPool.load(getContext(), R.raw.bang_with_fx, loadPriority);
            ding = soundPool.load(getContext(), R.raw.ding_with_fx, loadPriority);
        }
    }

    private class Clicker implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button_bang:
                    soundPool.play(bang, leftVolume, rightVolume, playPriority, loop, rate);
                    break;
                case R.id.button_ding:
                    soundPool.play(ding, leftVolume, rightVolume, playPriority, loop, rate);
                    break;
            }
        }
    }
}

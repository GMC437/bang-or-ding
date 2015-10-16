package com.wrightcontrol.app.mainscreen.mainscreen.mainbuttons;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.wrightcontrol.app.R;

/**
 * Created by Grant on 08/10/2015.
 */
public class MainFragment extends Fragment {

    private Button bangBtn;
    private Button dingBtn;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        bangBtn = (Button) view.findViewById(R.id.button_bang);
        bangBtn.setOnClickListener(new Clicker());
        dingBtn = (Button) view.findViewById(R.id.button_ding);
        dingBtn.setOnClickListener(new Clicker());
        return view;
    }


    private class Clicker implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button_bang:
                    MediaPlayer MP_Bang = MediaPlayer.create(v.getContext(), R.raw.bang_proj_mptree);
                    MP_Bang.start();
                    break;
                case R.id.button_ding:
                    MediaPlayer MP_Ding = MediaPlayer.create(v.getContext(), R.raw.ding_proj_mptree);
                    MP_Ding.start();
                    break;
            }
        }
    }
}

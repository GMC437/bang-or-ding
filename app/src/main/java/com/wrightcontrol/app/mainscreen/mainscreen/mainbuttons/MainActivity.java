package com.wrightcontrol.app.mainscreen.mainscreen.mainbuttons;

import android.support.v4.app.Fragment;
import com.wrightcontrol.app.R;
import com.wrightcontrol.app.mainscreen.mainscreen.abstractmain.SingleAbstractActivity;

public class MainActivity extends SingleAbstractActivity {

    @Override
    protected int getLayout() {
        return R.layout.fragment_container;
    }

    @Override
    protected int getContainerID() {
        return R.id.fragment_container;
    }

    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }
}

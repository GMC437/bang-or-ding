package com.wrightcontrol.app.mainscreen.mainscreen.abstractmain;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Grant on 08/10/2015.
 */
public abstract class SingleAbstractActivity extends AppCompatActivity {

    protected abstract int getLayout();
    protected abstract int getContainerID();
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment frag = fragmentManager.findFragmentById(getContainerID());

        if(frag == null){
            frag = createFragment();
            fragmentTransaction.add(getContainerID(), frag);
            fragmentTransaction.commit();
        }
    }
}

package com.example.tyler.itemrankings.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.tyler.itemrankings.fragments.SongFragment;

public class SongActivity extends SingleFragmentActivity
{

    @Override
    protected Fragment getFragment()
    {
        Bundle extras = getIntent().getExtras();

        SongFragment frag = new SongFragment();
        frag.setArguments(extras);

        return frag;
    }
}

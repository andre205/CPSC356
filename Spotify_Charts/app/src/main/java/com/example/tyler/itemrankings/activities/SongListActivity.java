package com.example.tyler.itemrankings.activities;

import android.support.v4.app.Fragment;

import com.example.tyler.itemrankings.fragments.SongListFragment;

public class SongListActivity extends SingleFragmentActivity
{
    @Override
    protected Fragment getFragment()
    {
        return new SongListFragment();
    }
}

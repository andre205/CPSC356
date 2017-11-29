package com.example.tyler.itemrankings.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.tyler.itemrankings.R;

public abstract class SingleFragmentActivity extends AppCompatActivity
{
    protected abstract Fragment getFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        showFragment(getFragment());

    }

    private void showFragment(Fragment frag)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_fragment_container, frag)
                .commit();
    }
}

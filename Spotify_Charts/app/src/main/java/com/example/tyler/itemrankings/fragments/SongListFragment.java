package com.example.tyler.itemrankings.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tyler.itemrankings.R;
import com.example.tyler.itemrankings.SongCollection;
import com.example.tyler.itemrankings.adapters.SongListAdapter;
import com.example.tyler.itemrankings.activities.SongActivity;
import com.example.tyler.itemrankings.adapters.SongListTouchHelper;
import com.example.tyler.itemrankings.models.SongModel;


public class SongListFragment extends Fragment
{
    private SongListAdapter adapter;
    private SongCollection songCollection;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_song_list, container, false);

        RecyclerView songsListView = v.findViewById(R.id.rv_songs);

        this.adapter = new SongListAdapter();
        songsListView.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new SongListTouchHelper(this.adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(songsListView);

        songsListView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }

    public void remove(int position) {
        this.songCollection = SongCollection.GetInstance();
        this.songCollection.remove(position);
        this.adapter.notifyItemRemoved(position);
    }

    @Override
    public void onResume()
    {
        super.onResume();

        this.adapter.notifyDataSetChanged();
    }
}



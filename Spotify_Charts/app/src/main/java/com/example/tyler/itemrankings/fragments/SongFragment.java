package com.example.tyler.itemrankings.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


import com.example.tyler.itemrankings.R;
import com.example.tyler.itemrankings.SongCollection;
import com.example.tyler.itemrankings.activities.SongActivity;
import com.example.tyler.itemrankings.models.SongModel;

import org.w3c.dom.Text;


public class SongFragment extends Fragment
{
    private TextView rankTextView;
    private TextView titleTextView;
    private TextView artistTextView;
    private TextView urlTextView;

    private SongModel song;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        String songId = getArguments().getString("song_id");
        this.song = SongCollection.GetInstance().getSong(songId);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_song, container, false);

        this.rankTextView = v.findViewById(R.id.tv_rank);
        this.rankTextView.setText(this.song.getRank());

        this.titleTextView = v.findViewById(R.id.tv_title);
        this.titleTextView.setText(this.song.getTitle());

        this.artistTextView = v.findViewById(R.id.tv_artist);
        this.artistTextView.setText(this.song.getArtist());

        this.urlTextView = v.findViewById(R.id.tv_url);
        this.urlTextView.setText(this.song.getUrl());

        return v;
    }
}

package com.example.tyler.itemrankings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.tyler.itemrankings.models.SongModel;

public class SongCollection
{
    private static SongCollection collection;

    public static SongCollection GetInstance()
    {
        if (collection == null)
        {
            collection = new SongCollection();
        }

        return collection;
    }

    private List<SongModel> songs;

    private SongCollection()
    {
        this.songs = new ArrayList<>();

        //Fetch pertinent song info for songmodel generation
        SpotifyChartFetcher scf = new SpotifyChartFetcher();
        String [] tempSongList;
        String [] tempArtistList;
        String [] tempURLList;
        tempSongList = scf.getTop200();
        tempArtistList = scf.getTop200Artists();
        tempURLList = scf.getTop200Urls();

        for (int i = 0; i < 200; ++i)
        {
            SongModel song = new SongModel();
            song.setTitle(tempSongList[i]);
            song.setArtist(tempArtistList[i]);
            song.setUrl(tempURLList[i]);
            song.setRank(i+1);
            this.songs.add(song);
        }

        // Couldn't get a method returning songmodels to work. Current method is super inefficient
//        SongModel[] songList = scf.getTop200SongModels();
//        for (int i = 0; i < 200; i++) {
//            SongModel s = songList[i];
//            this.songs.add(s);
//        }

    }

    public List<SongModel> getCrimes()
    {
        return this.songs;
    }

    public void addSong(SongModel song)
    {
        this.songs.add(song);
    }

    public void remove(int position) {
        this.songs.remove(position);
    }

    public void swap(int firstPosition, int secondPosition) {
        Collections.swap(songs, firstPosition, secondPosition);
    }

    public SongModel getSong(String id)
    {
        for(SongModel song : this.songs)
        {
            if (song.getId().equals(id))
            {
                return song;
            }
        }

        return null;
    }
}

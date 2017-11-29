package com.example.tyler.itemrankings.models;


import java.util.UUID;

public class SongModel
{
    private String id;
    private String title;
    private String artist;
    private String url;

    public String getRank() {
        return "#" + Integer.toString(rank);
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    private int rank;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public SongModel()
    {
        this.id = UUID.randomUUID().toString();
    }

    public String getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

}

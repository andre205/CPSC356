package com.example.tyler.itemrankings;


import android.os.StrictMode;

import com.example.tyler.itemrankings.models.SongModel;

import org.apache.commons.csv.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class SpotifyChartFetcher
{
    public SpotifyChartFetcher(){};

    public String[] getTop200()
    {
        //Thanks, https://stackoverflow.com/questions/6343166/how-do-i-fix-android-os-networkonmainthreadexception
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String[] returnlist = new String[200];

        try{
            URL url = new URL("https://spotifycharts.com/regional/global/daily/latest/download");
            URLConnection urlConnection = url.openConnection();
            InputStreamReader urlStreamReader = new InputStreamReader(urlConnection.getInputStream());
            //FOR DEFAULT CHANGE TO CSVFormat.DEFAULT
            CSVParser csv_p = new CSVParser(urlStreamReader, CSVFormat.EXCEL.withHeader());
            int i = 0;
            for (CSVRecord record : csv_p)
            {
                String s = record.get("Track Name");

                returnlist[i] = s;

                i++;

                if (i == 199)
                {
                    break;
                }
            }

        }


        catch (MalformedURLException m)
        {
            for (int i = 0; i < 200; ++i)
            {
                returnlist[i] = "URL EXCEPTION";
            }
        }

        catch (IOException io)
        {
            for (int i = 0; i < 200; ++i)
            {
                returnlist[i] = "IO EXCEPTION";
            }
        }

        catch (Exception e)
        {
            //This helped me discover my Network on Main Thread exception. Fixed it on stack overflow
            for (int i = 0; i < 200; ++i)
            {
                returnlist[i] = e.toString();
            }
        }

        return returnlist;
    }

    public String[] getTop200Artists()
    {
        //Thanks, https://stackoverflow.com/questions/6343166/how-do-i-fix-android-os-networkonmainthreadexception
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String[] returnlist = new String[200];

        try{
            URL url = new URL("https://spotifycharts.com/regional/global/daily/latest/download");
            URLConnection urlConnection = url.openConnection();
            InputStreamReader urlStreamReader = new InputStreamReader(urlConnection.getInputStream());
            //FOR DEFAULT CHANGE TO CSVFormat.DEFAULT
            CSVParser csv_p = new CSVParser(urlStreamReader, CSVFormat.EXCEL.withHeader());
            int i = 0;
            for (CSVRecord record : csv_p)
            {
                String s = record.get("Artist");

                returnlist[i] = s;

                i++;

                if (i == 199)
                {
                    break;
                }
            }

        }

        catch (Exception e)
        {
            for (int i = 0; i < 200; ++i)
            {
                returnlist[i] = e.toString();
            }
        }

        return returnlist;
    }

    public String[] getTop200Urls()
    {
        //Thanks, https://stackoverflow.com/questions/6343166/how-do-i-fix-android-os-networkonmainthreadexception
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String[] returnlist = new String[200];

        try{
            URL url = new URL("https://spotifycharts.com/regional/global/daily/latest/download");
            URLConnection urlConnection = url.openConnection();
            InputStreamReader urlStreamReader = new InputStreamReader(urlConnection.getInputStream());
            //FOR DEFAULT CHANGE TO CSVFormat.DEFAULT
            CSVParser csv_p = new CSVParser(urlStreamReader, CSVFormat.EXCEL.withHeader());
            int i = 0;
            for (CSVRecord record : csv_p)
            {
                String s = record.get("URL");

                returnlist[i] = s;

                i++;

                if (i == 199)
                {
                    break;
                }
            }

        }

        catch (Exception e)
        {
            for (int i = 0; i < 200; ++i)
            {
                returnlist[i] = e.toString();
            }
        }

        return returnlist;
    }


    //I made an effort to return songmodels but ultimately it didn't work.
    //Sorry the current methods are super inefficient
    public SongModel[] getTop200SongModels()
    {
        //Thanks, https://stackoverflow.com/questions/6343166/how-do-i-fix-android-os-networkonmainthreadexception
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        SongModel[] returnlist = new SongModel[200];

        try{
            URL url = new URL("https://spotifycharts.com/regional/global/daily/latest/download");
            URLConnection urlConnection = url.openConnection();
            InputStreamReader urlStreamReader = new InputStreamReader(urlConnection.getInputStream());
            //FOR DEFAULT CHANGE TO CSVFormat.DEFAULT
            CSVParser csv_p = new CSVParser(urlStreamReader, CSVFormat.EXCEL.withHeader());
            int i = 0;
            for (CSVRecord record : csv_p)
            {
                String s = record.get("Track Name");
                String a = record.get("Artist");
                String u = record.get("URL");

                SongModel song = returnlist[i];
                song.setTitle(s);
                song.setArtist(a);
                song.setUrl(u);


                i++;

                if (i == 199)
                {
                    break;
                }
            }

        }

        catch (Exception e)
        {

        }

        return returnlist;
    }


}
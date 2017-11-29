package com.example.tyler.itemrankings.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tyler.itemrankings.R;
import com.example.tyler.itemrankings.SongCollection;
import com.example.tyler.itemrankings.activities.SongActivity;
import com.example.tyler.itemrankings.models.SongModel;

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.SongViewHolder>
{
    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.cell_song, parent, false);

        return new SongViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position)
    {
        // Get song at specified position
        SongModel song = SongCollection.GetInstance().getCrimes().get(position);

        // Setup the ViewHolder
        holder.setup(song);
    }

    public void remove(int position)
    {
        SongCollection.GetInstance().remove(position);
        notifyItemRemoved(position);
    }

    public void swap(int firstPosition, int secondPosition)
    {
        SongCollection.GetInstance().swap(firstPosition, secondPosition);
        notifyItemMoved(firstPosition, secondPosition);
    }

    @Override
    public int getItemCount()
    {
        return SongCollection.GetInstance().getCrimes().size();
    }

    class SongViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private SongModel song;

        private TextView titleTextView;

        public SongViewHolder(View itemView)
        {
            super(itemView);

            itemView.setOnClickListener(this);

            this.titleTextView = itemView.findViewById(R.id.tv_title);
        }

        public void setup(SongModel song)
        {
            this.song = song;

            this.titleTextView.setText(song.getTitle());
        }

        @Override
        public void onClick(View view)
        {
            Intent songIntent = new Intent(view.getContext(), SongActivity.class);
            songIntent.putExtra("song_id", this.song.getId());

            view.getContext().startActivity(songIntent);
        }
    }
}

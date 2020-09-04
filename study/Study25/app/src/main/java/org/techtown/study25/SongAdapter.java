package org.techtown.study25;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {
    ArrayList<Song> items = new ArrayList<Song>();

    OnSongItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.song_item, viewGroup, false);

        return new ViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Song item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Song item) {
        items.add(item);
    }

    public void setItems(ArrayList<Song> items) {
        this.items = items;
    }

    public Song getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, Song item) {
        items.set(position, item);
    }

    public void setOnItemClickListener(OnSongItemClickListener listener) {
        this.listener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView output1;
        TextView output2;
        ImageView imageView;

        public ViewHolder(View itemView, final OnSongItemClickListener listener) {
            super(itemView);

            output1 = itemView.findViewById(R.id.output1);
            output2 = itemView.findViewById(R.id.output2);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });
        }

        public void setItem(Song item) {
            output1.setText(item.getName());
            output2.setText(item.getSinger());
            imageView.setImageResource(item.getImageId());
        }

    }

}

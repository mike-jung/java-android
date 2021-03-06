package org.techtown.memo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MemoAdapter extends RecyclerView.Adapter<MemoAdapter.ViewHolder> {
    public ArrayList<MemoItem> items = new ArrayList<MemoItem>();

    static Activity activity;

    public interface OnItemClickListener {
        public void onItemClick(int position);
    }

    OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public MemoAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(MemoItem item) {
        items.add(item);
    }

    public MemoItem getItem(int position) {
        return items.get(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.memo_item, parent, false);

        return new ViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MemoItem item = items.get(position);
        holder.setItem(item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        ImageView imageView;

        public ViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
            textView4 = itemView.findViewById(R.id.textView4);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null) {
                        listener.onItemClick(position);
                    }
                }
            });

        }

        public void setItem(MemoItem item) {
            textView.setText(item.getContents());
            textView2.setText(item.getFriendName());
            textView3.setText(item.getFriendMobile());
            textView4.setText(item.getTimestamp());

            try {
                Uri fileUri = Uri.parse(item.getImagePath());
                Bitmap bitmap = BitmapFactory.decodeStream(activity.getContentResolver().openInputStream(fileUri));
                imageView.setImageBitmap(bitmap);
            } catch(Exception e) {
                e.printStackTrace();
            }

        }
    }
}

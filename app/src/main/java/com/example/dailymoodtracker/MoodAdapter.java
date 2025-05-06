package com.example.dailymoodtracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MoodAdapter extends RecyclerView.Adapter<MoodAdapter.MoodViewHolder> {

    private List<MoodEntry> moodList;

    public MoodAdapter(List<MoodEntry> moodList) {

        this.moodList = moodList;
    }

    public void setMoodList(List<MoodEntry> newList) {
        this.moodList = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mood, parent, false);
        return new MoodViewHolder(view);
    }


    public void onBindViewHolder(@NonNull MoodViewHolder holder, int position) {
        MoodEntry entry = moodList.get(position);
        holder.moodText.setText(entry.mood);
        holder.moodNote.setText(entry.note);
        holder.moodImage.setImageResource(entry.moodImage);

    }

    @Override
    public int getItemCount() {
        return moodList.size();
    }

    public static class MoodViewHolder extends RecyclerView.ViewHolder {
        TextView moodText, moodNote;
        ImageView moodImage;

        public MoodViewHolder(@NonNull View itemView) {
            super(itemView);
            moodText = itemView.findViewById(R.id.selectedMood);
            moodNote = itemView.findViewById(R.id.noteInList);
            moodImage = itemView.findViewById(R.id.smallMoodImage);
        }
    }

}

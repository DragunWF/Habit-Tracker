package com.example.habit_tracker.utils;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.habit_tracker.R;
import com.example.habit_tracker.data.Habit;

import java.util.List;

public class HabitRecycler extends RecyclerView.Adapter<HabitRecycler.ViewHolder> {

    private List<Habit> habits;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView description;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            name = view.findViewById(R.id.habitName);
            description = view.findViewById(R.id.description);
        }

        public TextView getName() {
            return name;
        }

        public TextView getDescription() {
            return description;
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public HabitRecycler(List<Habit> habits) {
        this.habits = habits;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.completed_habits_recycle_view, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        Habit habit = habits.get(position);
        viewHolder.getName().setText(String.format("Habit %s: %s", position + 1, habit.getName()));
        viewHolder.getDescription().setText("Description: " + habit.getDescription());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return habits.size();
    }
}

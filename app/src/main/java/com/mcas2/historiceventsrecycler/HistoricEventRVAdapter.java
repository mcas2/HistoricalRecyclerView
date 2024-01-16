package com.mcas2.historiceventsrecycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoricEventRVAdapter extends RecyclerView.Adapter<HistoricEventRVAdapter.MyViewHolder> {
    Context context;
    ArrayList<HistoricEventModel> historicEventModels;

    public HistoricEventRVAdapter(Context context, ArrayList<HistoricEventModel> historicEventModels) {
        this.context = context;
        this.historicEventModels = historicEventModels;
    }

    @NonNull
    @Override
    public HistoricEventRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_row, parent, false);
        return new HistoricEventRVAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoricEventRVAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(historicEventModels.get(position).getEventName());
        holder.tvDate.setText(historicEventModels.get(position).getEventDate());
        holder.tvLocation.setText(historicEventModels.get(position).getEventLocation());
    }

    @Override
    public int getItemCount() {
        return historicEventModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDate, tvLocation;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvEventName);
            tvDate = itemView.findViewById(R.id.tvEventDate);
            tvLocation = itemView.findViewById(R.id.tvEventLocation);
        }
    }
}

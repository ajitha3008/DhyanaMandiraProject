package com.braingalore.dhyanamandira.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.braingalore.dhyanamandira.R;
import com.braingalore.dhyanamandira.model.EventsObject;

import java.util.List;

/**
 * Created by s92 on 5/8/2017.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.MyViewHolder> {
    private List<EventsObject> eventList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView eventName, eventDate, eventLocation, eventDescription;

        public MyViewHolder(View view) {
            super(view);
            eventName = (TextView) view.findViewById(R.id.event_name);
            eventDate = (TextView) view.findViewById(R.id.event_date);
            eventLocation = (TextView) view.findViewById(R.id.event_location);
            eventDescription = (TextView) view.findViewById(R.id.event_description);
        }
    }

    public EventsAdapter(List<EventsObject> events) {
        eventList = events;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.events_row_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        EventsObject event = eventList.get(position);
        holder.eventName.setText(event.getEventName());
        holder.eventLocation.setText(event.getEventLocation());
        holder.eventDescription.setText(event.getEventDescription());
        holder.eventDate.setText(event.getEventDate());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}

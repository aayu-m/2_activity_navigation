package com.example.a1_navigation_activity;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.w3c.dom.Text;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int type =1;
    private final Context context;
    private final List<Object>list;


    public RecyclerAdapter(Context context, List<Object>list){
        this.context= context;
        this.list=list;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView movieName;
        private TextView writer;
        private TextView releaseDate;

        public ViewHolder(@NonNull View view){
            super(view);
            movieName = (TextView) view.findViewById(R.id.movieName);
            writer = (TextView) view.findViewById(R.id.writer);
            releaseDate = (TextView) view.findViewById(R.id.releaseDate);
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewholder, int position) {
        ViewHolder viewHolder = (ViewHolder) viewholder;
        Movie movie = (Movie) list.get(position);

        viewHolder.movieName.setText(movie.getMovieName());
        viewHolder.writer.setText(movie.getWriter());
        viewHolder.releaseDate.setText(movie.getReleaseDate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

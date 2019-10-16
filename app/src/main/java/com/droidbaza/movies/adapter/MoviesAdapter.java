package com.droidbaza.movies.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.droidbaza.movies.R;
import com.droidbaza.movies.model.Movie;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by droidbaza on 16/10/19.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private List<Movie> movies;
    private Context context;

    public MoviesAdapter(Context context, List<Movie> movies){
        this.movies = movies;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.overview)
        TextView overview;
        @BindView(R.id.poster)
        ImageView poster;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.title.setText(movie.getTitle());
        holder.overview.setText(movie.getOverview());
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500/"+movie.getPoster())
                .into(holder.poster);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}

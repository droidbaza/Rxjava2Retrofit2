package com.droidbaza.movies.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.droidbaza.movies.R;
import com.droidbaza.movies.model.Movie;
import java.util.List;
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

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title, overview;
        private ImageView poster;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            overview = (TextView) itemView.findViewById(R.id.overview);
            poster = (ImageView) itemView.findViewById(R.id.poster);
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

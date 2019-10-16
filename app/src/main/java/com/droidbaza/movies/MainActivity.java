package com.droidbaza.movies;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.droidbaza.movies.adapter.MoviesAdapter;
import com.droidbaza.movies.api.ApiService;
import com.droidbaza.movies.api.MovieApi;
import com.droidbaza.movies.model.Movie;
import com.droidbaza.movies.model.Page;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
/**
 * Created by droidbaza on 16/10/19.
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    private RecyclerView recyclerView;


    private List<Movie> movies = new ArrayList<>();
    private MoviesAdapter moviesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        moviesAdapter = new MoviesAdapter(MainActivity.this, movies);
        recyclerView.setAdapter(moviesAdapter);

        getMovies();
    }

    private void getMovies(){
        MovieApi movieApi = ApiService.getMovieApi();
        movieApi.getPage().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Page>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(Page page) {
                        List<Movie>movieList = page.getResults();
                        movies.addAll(movieList);
                        moviesAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }

}

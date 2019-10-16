package com.droidbaza.movies.api;
import com.droidbaza.movies.model.Page;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import static com.droidbaza.movies.utils.Constants.POPULAR;

/**
 * Created by droidbaza on 16/10/19.
 */
public interface MovieApi {
    @GET(POPULAR)
    Single<Page> getPage();


}

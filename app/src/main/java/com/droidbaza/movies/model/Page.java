package com.droidbaza.movies.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Page {
    @SerializedName("results")
    private List<Movie> results;
    @SerializedName("total_results")

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}

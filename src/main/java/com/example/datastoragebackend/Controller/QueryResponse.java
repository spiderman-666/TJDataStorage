package com.example.datastoragebackend.Controller;

import java.util.List;
import java.util.Map;

public class QueryResponse {
    private List<Map<String, String>> movies;
    private Map<String, String> queryTime;

    // 构造函数
    public QueryResponse(List<Map<String, String>> movies, Map<String, String> queryTime) {
        this.movies = movies;
        this.queryTime = queryTime;
    }

    // Getter 和 Setter
    public List<Map<String, String>> getMovies() {
        return movies;
    }

    public void setMovies(List<Map<String, String>> movies) {
        this.movies = movies;
    }

    public Map<String, String> getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(Map<String, String> queryTime) {
        this.queryTime = queryTime;
    }
}


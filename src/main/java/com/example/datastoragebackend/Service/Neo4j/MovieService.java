package com.example.datastoragebackend.Service.Neo4j;
/*
import com.example.datastoragebackend.DAO.Neo4j.MovieDAO;
import com.example.datastoragebackend.Entity.Neo4j.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {
    @Autowired
    private MovieDAO movieDAO;

    // 根据电影名查询电影
    // 根据电影名查询所有电影信息
    public List<Map<String, String>> getMoviesByTitle(String movieName) {
        List<Movie> movies = movieDAO.findByTitle(movieName);
        List<Map<String, String>> result = new ArrayList<>();
        for (Movie movie : movies) {
            Map<String, String> map = new HashMap<>();
            map.put("id", movie.getId());
            map.put("title", movie.getTitle());
            map.put("score", movie.getScore());
            map.put("releaseDate", movie.getReleaseDate());
            map.put("genre", movie.getGenre());
            result.add(map);
        }
        return result;
    }


}
*/
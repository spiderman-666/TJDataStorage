package com.example.datastoragebackend.Service;

import com.example.datastoragebackend.Entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.datastoragebackend.DAO.MovieDAO;

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
            map.put("id", movie.getID());
            map.put("title", movie.getTitle());
            map.put("duration", movie.getDuration());
            map.put("score", movie.getScore());
            map.put("releaseDate", movie.getReleaseDate());
            map.put("genre", movie.getGenre());
            map.put("reviewCount", String.valueOf(movie.getReviewCount()));
            map.put("source_type", movie.getSource_type());
            result.add(map);
        }
        return result;
    }


}

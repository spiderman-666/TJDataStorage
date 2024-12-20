package com.example.datastoragebackend.Service;

import com.example.datastoragebackend.Entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.datastoragebackend.DAO.MovieDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {
    @Autowired
    private MovieDAO movieDAO;

    // 根据电影名查询电影
    // 根据电影名查询所有电影信息
    public List<Movie> getMoviesByTitle(String movieName) {
        return movieDAO.findByTitle(movieName);
    }


}

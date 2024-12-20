package com.example.datastoragebackend.Service;

import com.example.datastoragebackend.Entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.datastoragebackend.DAO.MovieDAO;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieDAO movieDAO;

    public List<Movie> getMoviesByTitle(String title) {
        return movieDAO.findByTitle(title);
    }


}

package com.example.datastoragebackend.Service.Neo4j;

import com.example.datastoragebackend.DAO.Neo4j.ActorDAON;
import com.example.datastoragebackend.DAO.Neo4j.DirectorDAON;
import com.example.datastoragebackend.DAO.Neo4j.MovieDAON;
import com.example.datastoragebackend.Entity.Neo4j.ActorN;
import com.example.datastoragebackend.Entity.Neo4j.DirectorN;
import com.example.datastoragebackend.Entity.Neo4j.MovieN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieServiceN {
    @Autowired
    private MovieDAON movieDAO;
    @Autowired
    private DirectorDAON directorDAON;
    @Autowired
    private ActorDAON actorDAON;

    public List<Map<String, String>> transformMovies(List<MovieN> movies) {
        List<Map<String, String>> result = new ArrayList<>();
        for (MovieN movie : movies) {
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

    // 根据电影名查询电影
    public List<Map<String, String>> getMoviesByTitle(String movieName) {
        return transformMovies(movieDAO.findAllByTitle(movieName));
    }

    // 根据导演查询电影
    public List<Map<String, String>> getMoviesByDirector(String directorName) {
        DirectorN director = directorDAON.findByName(directorName).orElse(null);
        if (director == null) {
            return new ArrayList<>();
        }
        return transformMovies(movieDAO.findAllByDirector(director));
    }

    // 根据演员查询电影
    public List<Map<String, String>> getMoviesByActor(String actorName) {
        ActorN actor = actorDAON.findByName(actorName).orElse(null);
        if (actor == null) {
            return new ArrayList<>();
        }
        return transformMovies(movieDAO.findAllByActor(actor));
    }

    // 根据演员查询电影
    public List<Map<String, String>> getMoviesByActorAndDirector(String actorName, String directorName) {
        ActorN actor = actorDAON.findByName(actorName).orElse(null);
        DirectorN director = directorDAON.findByName(directorName).orElse(null);
        if (actor == null || director == null) {
            return new ArrayList<>();
        }
        return transformMovies(movieDAO.findAllByDirectorAndActor(director, actor));
    }
}

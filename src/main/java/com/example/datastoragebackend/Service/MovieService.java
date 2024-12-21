package com.example.datastoragebackend.Service;

import com.example.datastoragebackend.DAO.*;
import com.example.datastoragebackend.Entity.Actor;
import com.example.datastoragebackend.Entity.Director;
import com.example.datastoragebackend.Entity.Movie;
import com.example.datastoragebackend.Relation.MovieActor;
import com.example.datastoragebackend.Relation.MovieDirector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    private MovieDAO movieDAO;
    @Autowired
    private ActorDAO actorDAO;
    @Autowired
    private DirectorDAO directorDAO;
    @Autowired
    private MovieActorDAO movieActorDAO;
    @Autowired
    private MovieDirectorDAO movieDirectorDAO;

    public List<Map<String,String>> transferMovies (List<Movie> movies) {
        List<Map<String, String>> result = new ArrayList<>();
        for (Movie movie : movies) {
            Map<String, String> map = new HashMap<>();
            map.put("id", movie.getID());
            map.put("title", movie.getTitle());
            map.put("duration", movie.getDuration());
            map.put("score", String.valueOf(movie.getScore()));
            map.put("releaseDate", movie.getReleaseDate().toString());
            map.put("genre", movie.getGenre());
            map.put("reviewCount", String.valueOf(movie.getReviewCount()));
            map.put("source_type", movie.getSource_type());
            result.add(map);
        }
        return result;
    }

    //根据电影上映时间进行查询
    public List<Map<String,String>> getMoviesByTime(String startDate, String endDate) {
        List<Movie> movies = movieDAO.findMoviesByReleaseDateBetween(startDate, endDate);
        return transferMovies(movies);
    }

    // 根据电影名查询所有电影信息
    public List<Map<String, String>> getMoviesByTitle(String movieName) {
        List<Movie> movies = movieDAO.findByTitle(movieName);
        return transferMovies(movies);
    }

    //根据电影类型查询
    public List<Map<String, String>> getMoviesByGenre(String genre) {
        List<Movie> movies = movieDAO.findByGenre(genre);
        System.out.println(movies);
        return transferMovies(movies);
    }

    //根据电影评分查询
    public List<Map<String, String>> getMoviesByScore(float low, float high) {
        List<Movie> movies = movieDAO.findByScoreBetween(low, high);
        System.out.println(movies);
        return transferMovies(movies);
    }

    //根据导演类型查询
    public List<Map<String, String>> getMoviesByDirector(String director_name) {
        Director director = directorDAO.findByName(director_name).orElse(null);
        if (director == null) {
            return new ArrayList<>();
        }
        List<MovieDirector> movieDirector = movieDirectorDAO.findByDirectorId(director.getId());
        List<Movie> movies = new ArrayList<>();
        for (MovieDirector movieDirectorEntity : movieDirector) {
            movieDAO.findById(movieDirectorEntity.getMovieId()).ifPresent(movies::add);
        }
        System.out.println(movies);
        return transferMovies(movies);
    }

    //根据演员类型查询
    public List<Map<String, String>> getMoviesByActor(String actor_name) {
        Actor actor = actorDAO.findByName(actor_name).orElse(null);
        if (actor == null) {
            return new ArrayList<>();
        }
        List<MovieActor> movieActor = movieActorDAO.findByActorId(actor.getId());
        List<Movie> movies = new ArrayList<>();
        for (MovieActor movieActorEntity : movieActor) {
            movieDAO.findById(movieActorEntity.getMovieId()).ifPresent(movies::add);
        }
        System.out.println(movies);
        return transferMovies(movies);
    }

    //根据演员类型查询
    public List<Map<String, String>> getMoviesByActorAndDirector(String actor_name, String director_name) {
        Director director = directorDAO.findByName(director_name).orElse(null);
        Actor actor = actorDAO.findByName(actor_name).orElse(null);
        if (director == null || actor == null) {
            return new ArrayList<>();
        }
        List<MovieDirector> movieDirector = movieDirectorDAO.findByDirectorId(director.getId());
        List<Movie> moviesD = new ArrayList<>();
        for (MovieDirector movieDirectorEntity : movieDirector) {
            movieDAO.findById(movieDirectorEntity.getMovieId()).ifPresent(moviesD::add);
        }
        List<MovieActor> movieActor = movieActorDAO.findByActorId(actor.getId());
        List<Movie> moviesA = new ArrayList<>();
        for (MovieActor movieActorEntity : movieActor) {
            movieDAO.findById(movieActorEntity.getMovieId()).ifPresent(moviesA::add);
        }
        return transferMovies(moviesD.stream().filter(moviesA::contains) .collect(Collectors.toList()));
    }
}

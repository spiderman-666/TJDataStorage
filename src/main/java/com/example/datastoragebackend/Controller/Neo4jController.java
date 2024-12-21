package com.example.datastoragebackend.Controller;

import com.example.datastoragebackend.Service.Neo4j.MovieServiceN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class Neo4jController {
    @Autowired
    private MovieServiceN movieService;

    @PostMapping("/query")
    public ResponseEntity<List<Map<String, String>>>  handleQuery(@RequestBody Map<String, String> query) {
        String queryType = query.get("type");
        System.out.println(queryType);
        List<Map<String, String>> result= new ArrayList<>();
        try {
            switch (queryType) {
                case "name":
                    String movieName = query.get("movieName");
                    result = movieService.getMoviesByTitle(movieName);
                    break;
                case "director":
                    String directorName = query.get("directorName");
                    result = movieService.getMoviesByDirector(directorName);
                    break;
                case "actor":
                    String actorName = query.get("actorName");
                    result = movieService.getMoviesByActor(actorName);
                    break;
                case "relationship":
                    String director = query.get("directorName");
                    String actor = query.get("actorName");
                    result = movieService.getMoviesByActorAndDirector(actor, director);
                    break;
                case "rating":
                    Integer minRating = Integer.parseInt(query.get("minRating"));
                    Integer maxRating = Integer.parseInt(query.get("maxRating"));
                    //result = queryByRating(minRating, maxRating);
                    break;
                case "combination":
                    String keyword = query.get("keyword");
                    //result = queryByCombination(keyword);
                    break;
                default:
                    throw new IllegalArgumentException("未知的查询类型: " + queryType);
            }
            System.out.println(result);
            return ResponseEntity.ok(result);

        } catch (Exception e) {
            return ResponseEntity.status(500).body(result);
        }


    }


}


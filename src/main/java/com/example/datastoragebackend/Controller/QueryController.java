package com.example.datastoragebackend.Controller;

import com.example.datastoragebackend.Entity.Movie;
import com.example.datastoragebackend.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.datastoragebackend.Service.QueryService;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class QueryController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/query")
    public ResponseEntity<List<Map<String, String>>>  handleQuery(@RequestBody Map<String, String> query) {
        String queryType = query.get("type");
        List<Map<String, String>> result= new ArrayList<>();
        try {
            switch (queryType) {
                case "time":
                    String startDate = query.get("startDate");
                    String endDate = query.get("endDate");
                    //result = queryByTime(startDate, endDate);
                    break;
                case "name":
                    String movieName = query.get("movieName");
                    // 查询电影信息
                    result = movieService.getMoviesByTitle(movieName);
                    System.out.println("查询到的电影数据: " + result);  // 确认是否查询到正确的电影数据
                    break;
                case "director":
                    String directorName = query.get("directorName");
                    //result = queryByDirector(directorName);
                    break;
                case "actor":
                    String actorName = query.get("actorName");
                    //result = queryByActor(actorName);
                    break;
                case "relationship":
                    String director = query.get("directorName");
                    String actor = query.get("actorName");
                    //result = queryByRelationship(director, actor);
                    break;
                case "category":
                    String categoryName = query.get("categoryName");
                    //result = queryByCategory(categoryName);
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


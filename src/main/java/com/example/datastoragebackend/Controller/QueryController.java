package com.example.datastoragebackend.Controller;

import com.example.datastoragebackend.Entity.Movie;
import com.example.datastoragebackend.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.datastoragebackend.Service.QueryService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class QueryController {
    @Autowired
    //private QueryService queryService;
    private MovieService movieService;
    @PostMapping("/query")
    public List<Movie> getMoviesByTitle(String title) {
        return movieService.getMoviesByTitle(title);
    }
    /*
    public ResponseEntity<?> handleQuery(@RequestBody Map<String, Object> query) {
        System.out.println(query);
        String queryType = (String) query.get("type");
        Map<String, Object> result= new HashMap<>();
        try {
            if ("name".equals(queryType)) {
                String movieName = (String) query.get("movieName");
                result = queryService.queryByName(movieName);  // 调用 queryByName
            } else {
                throw new IllegalArgumentException("未知的查询类型: " + queryType);
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("查询失败: " + e.getMessage());
        }
        /*
        try {
            switch (queryType) {
                case "time":
                    String startDate = (String) query.get("startDate");
                    String endDate = (String) query.get("endDate");
                    //result = queryByTime(startDate, endDate);
                    break;
                case "name":
                    String movieName = (String) query.get("movieName");
                    result = queryService.queryByName(movieName);
                    break;
                case "director":
                    String directorName = (String) query.get("directorName");
                    //result = queryByDirector(directorName);
                    break;
                case "actor":
                    String actorName = (String) query.get("actorName");
                    //result = queryByActor(actorName);
                    break;
                case "relationship":
                    String director = (String) query.get("directorName");
                    String actor = (String) query.get("actorName");
                    //result = queryByRelationship(director, actor);
                    break;
                case "category":
                    String categoryName = (String) query.get("categoryName");
                    //result = queryByCategory(categoryName);
                    break;
                case "rating":
                    Integer minRating = (Integer) query.get("minRating");
                    Integer maxRating = (Integer) query.get("maxRating");
                    //result = queryByRating(minRating, maxRating);
                    break;
                case "combination":
                    String keyword = (String) query.get("keyword");
                    //result = queryByCombination(keyword);
                    break;
                default:
                    throw new IllegalArgumentException("未知的查询类型: " + queryType);
            }
            return ResponseEntity.ok(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("查询失败: " + e.getMessage());
        }


    }*/


}


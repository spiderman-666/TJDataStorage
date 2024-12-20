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
    private MovieService movieService;

    @PostMapping("/query")
    public ResponseEntity<Map<String, Object>>  handleQuery(@RequestBody Map<String, Object> query) {
        String queryType = (String) query.get("type");
        Map<String, Object> result= new HashMap<>();
        try {
            switch (queryType) {
                case "time":
                    String startDate = (String) query.get("startDate");
                    String endDate = (String) query.get("endDate");
                    //result = queryByTime(startDate, endDate);
                    break;
                case "name":
                    String movieName = (String) query.get("movieName");
                    // 查询电影信息
                    List<Movie> movies = movieService.getMoviesByTitle(movieName);
                    System.out.println("查询到的电影数据: " + movies);  // 确认是否查询到正确的电影数据
                    result.put("movies", movies);
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
            result.put("message","查找成功");
            System.out.println(result);
            return ResponseEntity.ok(result);

        } catch (Exception e) {
            result.put("message", "查找失败");
            return ResponseEntity.status(500).body(result);
        }


    }


}


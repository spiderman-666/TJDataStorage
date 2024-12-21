package com.example.datastoragebackend.Controller;

import com.example.datastoragebackend.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class MySQLController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/query")
    public ResponseEntity<QueryResponse> handleQuery(@RequestBody Map<String, String> query) {
        String queryType = query.get("type");
        System.out.println(queryType);
        List<Map<String, String>> result = new ArrayList<>();
        // 记录查询开始时间
        long startTime = System.currentTimeMillis();
        switch (queryType) {
            case "time":
                String startDate = query.get("startDate");
                String endDate = query.get("endDate");
                System.out.println(startDate);
                result = movieService.getMoviesByTime(startDate, endDate);
                System.out.println(result);
                break;
            case "name":
                String movieName = query.get("movieName");
                // 查询电影信息
                result = movieService.getMoviesByTitle(movieName);
                System.out.println("查询到的电影数据: " + result);  // 确认是否查询到正确的电影数据
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
            case "category":
                String categoryName = query.get("categoryName");
                System.out.println(categoryName);
                result = movieService.getMoviesByGenre(categoryName);
                System.out.println(result);
                break;
            case "rating":
                System.out.println("ratingsession");
                float minRating = Float.parseFloat(query.get("minRating"));
                float maxRating = Float.parseFloat(query.get("maxRating"));
                result = movieService.getMoviesByScore(minRating, maxRating);
                break;
            case "combination":
                String keyword = query.get("keyword");
                //result = queryByCombination(keyword);
                break;
            default:
                throw new IllegalArgumentException("未知的查询类型: " + queryType);
        }
        // 记录查询结束时间
        long endTime = System.currentTimeMillis();
        // 计算查询耗时
        long duration = endTime - startTime;
        // 将查询时间封装到 Map 中
        Map<String, String> timeInfo = new HashMap<>();
        timeInfo.put("queryTime", duration + " ms");

        // 返回 QueryResponse 对象，其中包含查询结果和查询时间
        QueryResponse queryResponse = new QueryResponse(result, timeInfo);
        return ResponseEntity.ok(queryResponse);
    }
}


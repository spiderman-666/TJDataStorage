package com.example.datastoragebackend.Controller;

import com.example.datastoragebackend.Service.MySQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin(origins = "")
@RequestMapping("/mysql")
public class MySQLController {
    @Autowired
    private MySQLService mySQLService;

    @GetMapping("/query")
    public List<String> query(@RequestParam String query) {
        return mySQLService.testSparkMysql();
    }
}

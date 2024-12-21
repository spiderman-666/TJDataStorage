package com.example.datastoragebackend.Service;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MySQLService {
    @Autowired
    SparkSession sparkSession;

    public List<String> testSparkMysql() {
        Dataset<Row> jdbcDF = sparkSession.read()
                .format("jdbc")
                .option("url", "jdbc:mysql://rm-uf6t5zn7j996evf66po.mysql.rds.aliyuncs.com:3306/movies")
                .option("dbtable", "(SELECT * FROM original_data LIMIT 1) tmp")
                .option("user", "user")
                .option("password", "Movies123")
                .option("driver", "com.mysql.cj.jdbc.Driver")
                .load();

        jdbcDF.printSchema();
        jdbcDF.show();

        Dataset<String> jsonDF = jdbcDF.toJSON();
        return jsonDF.collectAsList();
    }
}

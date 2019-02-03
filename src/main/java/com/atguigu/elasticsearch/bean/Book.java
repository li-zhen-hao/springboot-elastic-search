package com.atguigu.elasticsearch.bean;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author li
 * 2019/2/3 21:33
 * version 1.0
 */
@Data
@Builder
@Document(indexName = "atguigu",type = "book")
public class Book {
    private Integer id;
    private String name;
    private String author;

    public Book() {
    }

    public Book(Integer id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
}

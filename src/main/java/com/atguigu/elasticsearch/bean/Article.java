package com.atguigu.elasticsearch.bean;

import lombok.Builder;
import lombok.Data;

/**
 * @author li
 * 2019/2/3 17:03
 * version 1.0
 */
@Data
@Builder(toBuilder = true)
public class Article {
    private Integer id;
    private String author;
    private String title;
    private String content;

}

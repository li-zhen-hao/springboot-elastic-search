package com.atguigu.elasticsearch.repository;

import com.atguigu.elasticsearch.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author li
 * 2019/2/3 21:35
 * version 1.0
 */

public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
    public List<Book> findBookByNameIsLike(String bookname);
}

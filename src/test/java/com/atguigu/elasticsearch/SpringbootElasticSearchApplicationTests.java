package com.atguigu.elasticsearch;

import com.atguigu.elasticsearch.bean.Article;
import com.atguigu.elasticsearch.bean.Book;
import com.atguigu.elasticsearch.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootElasticSearchApplicationTests {

    @Autowired
    private JestClient jestClient;
    @Autowired
    private BookRepository bookRepository;
    @Test
    public void book(){
        Book book=Book.builder().id(1).name("西游记").author("吴承恩").build();
        System.out.println(book);
        bookRepository.index(book);
    }

    @Test
    public void contextLoads() {
        Article article=Article.builder().id(1).author("张三 ").title("好消息").content("Hello World").build();
        //System.out.println(article.toBuilder().id(2).getClass());
        System.out.println(article);
        Index index = new Index.Builder(article).index("atguigu").type("news").id("1").build();
        try {
            DocumentResult execute = jestClient.execute(index);
            System.out.println(execute.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test() throws IOException {
        String string="{\n" +
                "    \"query\" : {\n" +
                "        \"match_phrase\" : {\n" +
                "            \"content\" : \"hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        System.out.println(string);
        Search build = new Search.Builder(string).addIndex("atguigu").addType("news").build();
        SearchResult result = jestClient.execute(build);
        System.out.println(result.getJsonObject());
    }
}


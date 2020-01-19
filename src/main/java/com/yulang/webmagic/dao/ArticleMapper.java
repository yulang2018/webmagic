package com.yulang.webmagic.dao;

import com.yulang.webmagic.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Insert({ "insert into article(id, title, content, create_time) values(#{id}, #{title}, " +
            "#{content}, #{createTime, jdbcType=TIMESTAMP})" })
    public void insert(Article article);

    @Select({"select * from article"})
    List<Article> list();
}

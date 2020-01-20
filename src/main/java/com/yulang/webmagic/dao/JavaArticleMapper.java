package com.yulang.webmagic.dao;

import com.yulang.webmagic.pojo.JavaArticle;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JavaArticleMapper {

    @Insert({ "insert into java_article(id, title, content, create_time) values(#{id}, #{title}, " +
            "#{content}, #{createTime, jdbcType=TIMESTAMP})" })
    public void insert(JavaArticle article);

    @Select({"select * from java_article limit 10"})
    List<JavaArticle> list();
}

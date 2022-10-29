package com.troubleskiller;

import com.troubleskiller.mapper.BlogMapper;
import com.troubleskiller.mapper.CategoryMapper;
import com.troubleskiller.pojo.Blog;
import com.troubleskiller.pojo.Category;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class MybatisDemo {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession sqlSession = sqlSessionFactory.openSession();

        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        List<Blog> blogs = blogMapper.selectAllBlog();
        List<Category> categories= mapper.selectAllCategory();
        sqlSession.commit();
        System.out.println(categories);

    }
}

package com.troubleskiller;

import com.troubleskiller.mapper.BlogMapper;
import com.troubleskiller.pojo.Blog;
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


        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        java.util.Date date = new java.util.Date(); // 获取一个Date对象
        Timestamp timeStamp = new Timestamp(date.getTime()); // 将日期时间转换为数据库中的timestamp类型


        blogMapper.insertBlog(new Blog(1, "这是我插入的数据", "这是测试数据的内容", 0, 1, timeStamp));
        List<Blog> blogs = blogMapper.selectAllBlog();
        sqlSession.commit();
//        System.out.println(blogs);

    }
}

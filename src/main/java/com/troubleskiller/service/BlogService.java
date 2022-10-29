package com.troubleskiller.service;

import com.troubleskiller.mapper.BlogMapper;
import com.troubleskiller.pojo.Blog;
import com.troubleskiller.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BlogService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Blog> selectAllBlog() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        List<Blog> blogs = mapper.selectAllBlog();
        sqlSession.close();
        return blogs;
    }
}

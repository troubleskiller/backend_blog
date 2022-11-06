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

    public List<Blog> selectFromCategory(Integer category_id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        List<Blog> blogs = mapper.selectFromCategory(category_id);
        sqlSession.close();
        return blogs;
    }

    public void insertBlog(Blog blog) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        mapper.insertBlog(blog);
        sqlSession.commit();
        sqlSession.close();
    }
}

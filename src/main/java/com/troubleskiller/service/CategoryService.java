package com.troubleskiller.service;

import com.troubleskiller.mapper.CategoryMapper;
import com.troubleskiller.pojo.Category;
import com.troubleskiller.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CategoryService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Category> selectAllCategory(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
        List<Category> categories = mapper.selectAllCategory();
        sqlSession.close();
        return categories;
    }

    public void addCategory(Category category){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
        mapper.addCategory(category);
        sqlSession.close();
    }
}

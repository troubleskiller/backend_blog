package com.troubleskiller.mapper;

import com.troubleskiller.pojo.Blog;

import java.util.List;

public interface BlogMapper {
    List<Blog> selectAllBlog();

    void insertBlog(Blog blog);

    List<Blog> selectFromCategory(Integer category_id);

}

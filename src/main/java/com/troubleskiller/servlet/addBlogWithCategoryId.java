package com.troubleskiller.servlet;

import com.alibaba.dubbo.common.utils.IOUtils;
import com.alibaba.fastjson.JSONObject;
import com.troubleskiller.pojo.Blog;
import com.troubleskiller.service.BlogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

@WebServlet(name = "addBlogWithCategoryId", value = "/blog/addBlogWithCategoryId")
public class addBlogWithCategoryId extends HttpServlet {
    private BlogService blogService = new BlogService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if("OPTIONS".equals(request.getMethod())){
            response.setStatus(200);
            return ;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Max-Age", "4200");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        String body = IOUtils.read(reader);
        System.out.println(body);
        System.out.println(Timestamp.valueOf(LocalDateTime.now()));
        JSONObject jsonObject = JSONObject.parseObject(body);
        Blog insertBlog = new Blog();
        insertBlog.setcategory_id(jsonObject.getInteger("category_id"));
        insertBlog.setContent(jsonObject.getString("content"));
        insertBlog.setPublish_time(Timestamp.from(Instant.ofEpochMilli(jsonObject.getLong("publish_time"))));
        insertBlog.setStatus(jsonObject.getInteger("status"));
        insertBlog.setType(jsonObject.getInteger("type"));
        insertBlog.setTitle(jsonObject.getString("title"));
        blogService.insertBlog(insertBlog);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Authorization,Origin,X-Requested-With,Content-Type,Accept,"
                + "content-Type,origin,x-requested-with,content-type,accept,authorization,token,id,X-Custom-Header,X-Cookie,Connection,User-Agent,Cookie,*");
        response.setHeader("Access-Control-Request-Headers", "Authorization,Origin, X-Requested-With,content-Type,Accept");
        response.setHeader("Access-Control-Expose-Headers", "*");
    }
}

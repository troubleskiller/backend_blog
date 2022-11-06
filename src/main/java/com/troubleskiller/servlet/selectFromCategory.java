package com.troubleskiller.servlet;

import com.alibaba.fastjson.JSON;
import com.troubleskiller.pojo.Blog;
import com.troubleskiller.service.BlogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "selectFromCategory", value = "/blog/selectFromCategory")
public class selectFromCategory extends HttpServlet {
    private BlogService blogService = new BlogService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("category_id"));
        List<Blog> blogs = blogService.selectFromCategory(id);

        String jsonString = JSON.toJSONString(blogs);
        //*Dart/Flutter：Http 请求引发 XMLHttpRequest 错误 https://stackoverflow.com/questions/71157863/dart-flutter-http-request-raises-xmlhttprequest-error/
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Max-Age", "4200");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");//
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

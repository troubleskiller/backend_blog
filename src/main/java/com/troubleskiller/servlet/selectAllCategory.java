package com.troubleskiller.servlet;

import com.alibaba.fastjson.JSON;
import com.troubleskiller.pojo.Category;
import com.troubleskiller.service.CategoryService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "selectAllCategory", value = "/blog/selectAllCategory")
public class selectAllCategory extends HttpServlet {
    private CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Category> categories = categoryService.selectAllCategory();

        String jsonString = JSON.toJSONString(categories);

        //*Dart/Flutter：Http 请求引发 XMLHttpRequest 错误 https://stackoverflow.com/questions/71157863/dart-flutter-http-request-raises-xmlhttprequest-error/
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Max-Age", "4200");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");// If needed
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

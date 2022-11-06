package com.troubleskiller.servlet;

import com.alibaba.dubbo.common.utils.IOUtils;
import com.alibaba.fastjson.JSONObject;
import com.troubleskiller.pojo.Category;
import com.troubleskiller.service.CategoryService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@WebServlet(name = "addCategory", value = "/blog/addCategory")
public class addCategory extends HttpServlet {
    CategoryService categoryService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Max-Age", "4200");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        String body = IOUtils.read(reader);
        JSONObject jsonObject = JSONObject.parseObject(body);
        Category insertCa = new Category();
        insertCa.setDescription(jsonObject.getString("description"));
        insertCa.setOrder(jsonObject.getInteger("order"));
        insertCa.setCategory_py(jsonObject.getString("category_py"));
        insertCa.setCategory_name(jsonObject.getString("category_name"));
        categoryService.addCategory(insertCa);
    }
}

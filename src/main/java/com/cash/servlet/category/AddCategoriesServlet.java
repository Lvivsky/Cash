package com.cash.servlet.category;

import com.cash.model.Categories;
import com.cash.service.CategoriesService;
import com.cash.service.CategoriesServiceImpl;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j
@WebServlet("/categories/add")
public class AddCategoriesServlet extends HttpServlet {

    private static CategoriesService categoriesService;

    @Override
    public void init() throws ServletException {
        categoriesService = new CategoriesServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("category_id");
        String name = req.getParameter("add_name");
        String comment = req.getParameter("add_comment");

        categoriesService.add(new Categories(name,comment,id));
        resp.sendRedirect(req.getContextPath()+"/categories");
    }
}

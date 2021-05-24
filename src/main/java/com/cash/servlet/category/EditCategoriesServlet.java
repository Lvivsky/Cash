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
@WebServlet("/categories/edit")
public class EditCategoriesServlet extends HttpServlet {

    private static CategoriesService categoriesService;

    @Override
    public void init() throws ServletException {
        categoriesService = new CategoriesServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("category_id");
        String name = req.getParameter("edit_name");
        String comment = req.getParameter("edit_comment");

        Categories categories = new Categories(name,comment,"1");
        categories.setId(Integer.parseInt(id));
        categoriesService.edit(categories);
        resp.sendRedirect(req.getContextPath()+"/categories");
    }
}

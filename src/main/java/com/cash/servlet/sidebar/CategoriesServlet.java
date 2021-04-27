package com.cash.servlet.sidebar;

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
@WebServlet("/categories")
public class CategoriesServlet extends HttpServlet {

    private CategoriesService categoriesService;

    @Override
    public void init() throws ServletException {
        this.categoriesService = new CategoriesServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        log.info("Get categories page");


        req.setAttribute("categories", categoriesService.getAll());
        log.info("Get all categories");

        req.getRequestDispatcher("categories.jsp").forward(req,resp);
    }


}

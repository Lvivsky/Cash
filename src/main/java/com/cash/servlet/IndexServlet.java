package com.cash.servlet;

import com.cash.servlet.filter.IndexFilter;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.hibernate.annotations.Filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j
@WebServlet("")
public class IndexServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Get main page");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        req.setCharacterEncoding("UTF-8");
        log.info("Do post on: /");



        resp.sendRedirect(req.getContextPath()+"/account");
        log.info("Do redirect on: /account");
    }
}

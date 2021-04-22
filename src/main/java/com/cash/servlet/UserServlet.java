package com.cash.servlet;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j
@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("user.jsp").forward(req,resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        req.setCharacterEncoding("UTF-8");



        resp.sendRedirect(req.getContextPath());
    }
}

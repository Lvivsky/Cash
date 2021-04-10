package com.cash.servlet.registerdb;

import com.cash.util.singleton.DbController;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j
@WebServlet("/remove-db")
public class RemoveDatabaseTemplateServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        req.setCharacterEncoding("UTF-8");

        DbController dbController = DbController.getInstance();

        if (dbController.removeTemplate())
            log.info("Database was removed");
        else
            log.info("Can`t remove database");
        resp.sendRedirect(req.getContextPath() + "/");
    }


}

package com.cash.servlet.registerdb;

import com.cash.util.singleton.SqliteConnection;
import com.cash.dao.User;
import com.cash.service.UserService;
import com.cash.service.impl.UserServiceImpl;
import com.cash.util.singleton.DbController;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*

    for creating empty database on the start

 */

@Log4j
@WebServlet("/generate-template-database")
public class CreateTemplateDBServlet extends HttpServlet {
    private static UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
        super.init();
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        req.setCharacterEncoding("UTF-8");

        DbController dbController = DbController.getInstance();
        dbController.setCurrentDatabase("/Users/a1/Documents/api/cash/db/template.cash");

        // create new empty database
        dbController.createEmptyTemplate();

        // set connection with database
        SqliteConnection.getInstance(dbController.getDbFileAbsolutePath());

        User user = userService.getUserById(1);
        log.info("Get empty database with user: " + user.toString());

        resp.sendRedirect(req.getContextPath() + "/account");
    }
}

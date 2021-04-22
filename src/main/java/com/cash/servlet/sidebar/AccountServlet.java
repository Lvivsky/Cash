package com.cash.servlet.sidebar;

import com.cash.dao.Accounts;
import com.cash.service.AccountsService;
import com.cash.service.UserService;
import com.cash.service.impl.AccountServiceImpl;
import com.cash.service.impl.UserServiceImpl;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j
@WebServlet("/account")
public class AccountServlet extends HttpServlet {

    private AccountsService accountsService;

    @Override
    public void init() {
        accountsService = new AccountServiceImpl();
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        req.setAttribute("accounts", accountsService.getAllAccounts());

        log.info("Get account page");
        req.getRequestDispatcher("account.jsp").forward(req, resp);
    }
}

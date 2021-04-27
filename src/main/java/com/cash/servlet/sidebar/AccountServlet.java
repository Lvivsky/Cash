package com.cash.servlet.sidebar;

import com.cash.service.AccountsService;
import com.cash.service.AccountsServiceImpl;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j
@WebServlet("/account")
public class AccountServlet extends HttpServlet {

    private AccountsService accountsService;

    @Override
    public void init() {
        accountsService = new AccountsServiceImpl();
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        req.setAttribute("accounts", accountsService.getAllAccounts());

        log.info("Get account page");
        req.getRequestDispatcher("account.jsp").forward(req, resp);
    }
}

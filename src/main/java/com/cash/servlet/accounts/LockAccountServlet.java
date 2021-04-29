package com.cash.servlet.accounts;

import com.cash.model.Accounts;
import com.cash.service.AccountsService;
import com.cash.service.AccountsServiceImpl;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j
@WebServlet("/account-lock")
public class LockAccountServlet extends HttpServlet {

    private AccountsService accountsService;

    @Override
    public void init() throws ServletException {
        this.accountsService = new AccountsServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("account_id"));
        accountsService.setLocked(id,1);
        log.info("Account with id:" + id + " was locked");

        resp.sendRedirect(req.getContextPath()+"/account");
    }


}

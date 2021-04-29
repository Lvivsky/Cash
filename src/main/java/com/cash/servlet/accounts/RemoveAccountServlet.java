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
import java.util.Objects;

@Log4j
@WebServlet("/account-remove")
public class RemoveAccountServlet extends HttpServlet {

    private AccountsService accountsService;

    @Override
    public void init() throws ServletException {
        accountsService = new AccountsServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        log.info("try to remove account");

        Accounts accounts = accountsService.getAccounts(Integer.parseInt(req.getParameter("account_id")));
        if (!Objects.isNull(accounts.getId()))
            accountsService.removeAccounts(accounts.getId());

        resp.sendRedirect(req.getContextPath()+"/account");
    }

}

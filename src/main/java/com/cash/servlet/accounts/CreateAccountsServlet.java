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
@WebServlet("/accounts-create")
public class CreateAccountsServlet extends HttpServlet {

    private AccountsService accountsService;

    @Override
    public void init() throws ServletException {
        accountsService = new AccountsServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        accountsService.addAccounts(
                new Accounts(
                    req.getParameter("a_name"),
                    req.getParameter("a_balance"),
                    req.getParameter("a_currency"),
                    req.getParameter("a_comment")
        ));
        resp.sendRedirect(req.getContextPath()+"/account");
    }
}

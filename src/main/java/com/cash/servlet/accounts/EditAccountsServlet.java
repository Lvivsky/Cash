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
import java.time.Instant;
import java.util.Objects;

@Log4j
@WebServlet("/account-edit")
public class EditAccountsServlet extends HttpServlet {

    private AccountsService accountsService;

    @Override
    public void init() throws ServletException {
        accountsService = new AccountsServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Accounts accounts = accountsService.getAccounts(Integer.parseInt(req.getParameter("account_id")));

        if (!Objects.isNull(accounts)) {
            String name = req.getParameter("name");
            String balance = req.getParameter("balance");

            accounts.setChanged(String.valueOf(Instant.now().getEpochSecond()));
            if (!name.equals(""))
                accounts.setName(name);
            if (!balance.equals(""))
                accounts.setStartingBalance(balance);
            accounts.setComment(req.getParameter("comment"));
            accounts.setCurrency(req.getParameter("a_currency"));

            accountsService.editAccount(accounts);
            log.info("Account was edited");
        } else {
            log.error("Account not found!");
        }
        resp.sendRedirect(req.getContextPath()+"/account");
    }
}

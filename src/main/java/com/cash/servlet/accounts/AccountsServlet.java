package com.cash.servlet.accounts;

import com.cash.model.Accounts;
import com.cash.model.Currencies;
import com.cash.service.AccountsService;
import com.cash.service.AccountsServiceImpl;
import com.cash.service.CurrenciesService;
import com.cash.service.CurrenciesServiceImpl;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Log4j
@WebServlet("/account")
public class AccountsServlet extends HttpServlet {

    private AccountsService accountsService;
    private CurrenciesService currenciesService;

    @Override
    public void init() {
        this.accountsService = new AccountsServiceImpl();
        this.currenciesService = new CurrenciesServiceImpl();
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        List<Accounts> accounts = accountsService.getAllAccountsWithCurrencyCode();

        req.setAttribute("accounts", accounts);

        req.setAttribute("currencies", currenciesService.getAll());

        req.getRequestDispatcher("account.jsp").forward(req, resp);
    }
}

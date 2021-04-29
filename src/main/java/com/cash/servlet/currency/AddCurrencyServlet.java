package com.cash.servlet.currency;

import com.cash.model.Currencies;
import com.cash.service.CurrenciesService;
import com.cash.service.CurrenciesServiceImpl;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j
@WebServlet("/currency-add")
public class AddCurrencyServlet extends HttpServlet {

    private CurrenciesService currenciesService;

    @Override
    public void init() throws ServletException {
        currenciesService = new CurrenciesServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");



        resp.sendRedirect(req.getContextPath()+"/currencies");
    }
}

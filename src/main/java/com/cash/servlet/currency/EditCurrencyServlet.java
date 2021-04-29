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
import java.time.Instant;
import java.util.Objects;

@Log4j
@WebServlet("/currency-edit")
public class EditCurrencyServlet extends HttpServlet {

    private CurrenciesService currenciesService;

    @Override
    public void init() throws ServletException {
        currenciesService = new CurrenciesServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Currencies currencies = currenciesService.getById(Integer.parseInt(req.getParameter("currency_id")));

        if (!Objects.isNull(currencies)) {
            currencies.setChanged(String.valueOf(Instant.now().getEpochSecond()));
            currencies.setName(req.getParameter("name"));
            currencies.setCode(req.getParameter("code").toUpperCase());

            currenciesService.edit(currencies);
        }


        resp.sendRedirect(req.getContextPath()+"/currencies");
    }

}

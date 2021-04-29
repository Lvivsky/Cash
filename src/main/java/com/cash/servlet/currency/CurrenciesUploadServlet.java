package com.cash.servlet.currency;


import com.cash.core.CurrencyController;
import com.cash.model.Currencies;
import com.cash.service.CurrenciesService;
import com.cash.service.CurrenciesServiceImpl;
import com.cash.service.CurrencyRatesService;
import com.cash.service.CurrencyRatesServiceImpl;
import com.cash.util.TemplateCurrency;
import lombok.extern.log4j.Log4j;
import lombok.var;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Log4j
@WebServlet("/currency-upload")
public class CurrenciesUploadServlet extends HttpServlet {

    private List<TemplateCurrency> templateCurrencies;
    private CurrenciesService currenciesService;

    @Override
    public void init() throws ServletException {
        templateCurrencies = new ArrayList<>();
        this.currenciesService = new CurrenciesServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        templateCurrencies = CurrencyController.downloadCurrency();

        req.setAttribute("template_currencies", templateCurrencies);
        req.getRequestDispatcher("document.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List<Currencies> currencies = new ArrayList<>();
        String[] checksCurr = req.getParameterValues("checksCurr");


        List<TemplateCurrency> res = new ArrayList<>();
        for (var e: templateCurrencies) {
            for (int i = 0; i < checksCurr.length; i++) {
                if (e.getCharCode().equals(checksCurr[i])) {
                    res.add(e);
                    currencies.add(new Currencies(
                            String.valueOf(Instant.now().getEpochSecond()),
                            "0",
                            e.getCharCode(),
                            e.getName(),
                            "2"
                    ));
                }
            }
        }

        currencies.forEach(x -> currenciesService.add(x));
        log.info("Currencies added successfully");


        templateCurrencies.clear();
        resp.sendRedirect(req.getContextPath()+"/currencies");
    }
}

package com.cash.servlet.currency;


import com.cash.core.CurrencyController;
import com.cash.model.Currencies;
import com.cash.model.CurrencyRates;
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
    private CurrencyRatesService currencyRatesService;

    @Override
    public void init() throws ServletException {
        this.templateCurrencies = new ArrayList<>();
        this.currenciesService = new CurrenciesServiceImpl();
        this.currencyRatesService = new CurrencyRatesServiceImpl();
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

        List<Currencies> currenciesList = currenciesService.getAll();
        List<CurrencyRates> currencyRatesList = new ArrayList<>();


        for (int i = 0; i < res.size(); i++) {
            for (int j = i+1; j < res.size(); j++) {

                Currencies c1 = currenciesService.getByCode(res.get(i).getCharCode());
                Currencies c2 = currenciesService.getByCode(res.get(j).getCharCode());

                String value1 = res.get(i).getValue().replace(',','.');
                String value2 = res.get(j).getValue().replace(',','.');


                currencyRatesList.add(
                        new CurrencyRates(
                                String.valueOf(Instant.now().getEpochSecond()),
                                String.valueOf(c1.getId()),
                                String.valueOf(c2.getId()),
                                String.valueOf(Math.round(Double.parseDouble(value2) * 10000)),
                                String.valueOf(Math.round(Double.parseDouble(value1) * res.get(j).getNominal() * 10000))
                        )
                );
            }
        }

        currencyRatesList.forEach(x -> currencyRatesService.add(x));
        log.info("Currencies successfully added");

        templateCurrencies.clear();
        resp.sendRedirect(req.getContextPath()+"/currencies");
    }

}

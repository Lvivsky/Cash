package com.cash.servlet.currency;

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
@WebServlet("/currencies")
public class CurrenciesServlet extends HttpServlet {

    private CurrenciesService currenciesService;

    @Override
    public void init() {
        this.currenciesService = new CurrenciesServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        req.setAttribute("curr", currenciesService.getAll());

        req.getRequestDispatcher("currencies.jsp").forward(req,resp);
    }


}

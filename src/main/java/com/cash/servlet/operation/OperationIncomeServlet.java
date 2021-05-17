package com.cash.servlet.operation;

import com.cash.service.TransactionsService;
import com.cash.service.TransactionsServiceImpl;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Log4j
@WebServlet("/operation/income")
public class OperationIncomeServlet extends HttpServlet {

    private TransactionsService transactionsService;

    @Override
    public void init() throws ServletException {
        transactionsService = new TransactionsServiceImpl();
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String account = req.getParameter("income_accounts");
        String date = req.getParameter("income_date");
        String state = req.getParameter("income_state");
        int balance = Integer.parseInt(req.getParameter("income_balance"));
        String category = req.getParameter("income_category");
        String comment = req.getParameter("income_comment");

        Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date.replace('T',' '));
        Long chosenDate = date1.toInstant().getEpochSecond();

        if (balance < 0) balance = balance * (-1);

        log.info("Input transaction: " +
                " Account: " + account +
                " State: " + state +
                " Date: " + chosenDate.toString() +
                " Category: " + category +
                " Balance: " + balance +
                " Comment: " + comment);

        transactionsService.addIncomeTransaction(
                account,
                state,
                chosenDate.toString(),
                category,
                String.valueOf(balance),
                comment);

        resp.sendRedirect(req.getContextPath()+"/operation");
    }
}

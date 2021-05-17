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
@WebServlet("/operation/expense")
public class OperationOutcomeServlet extends HttpServlet {

    private TransactionsService transactionsService;

    @Override
    public void init() throws ServletException {
        transactionsService = new TransactionsServiceImpl();
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String account = req.getParameter("outcome_accounts");
        String date = req.getParameter("outcome_date");
        String state = req.getParameter("outcome_state");
        int balance = Integer.parseInt(req.getParameter("outcome_balance"));
        String category = req.getParameter("outcome_category");
        String comment = req.getParameter("outcome_comment");

        Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date.replace('T',' '));
        long chosenDate = date1.toInstant().getEpochSecond();

        if (balance < 0) balance = balance * (-1);

        log.info("Input transaction: " +
                " Account: " + account +
                " State: " + state +
                " Date: " + Long.toString(chosenDate) +
                " Category: " + category +
                " Balance: " + balance +
                " Comment: " + comment);

        transactionsService.addOutcomeTransaction(
                account,
                state,
                Long.toString(chosenDate),
                category,
                String.valueOf(balance),
                comment);

        resp.sendRedirect(req.getContextPath()+"/operation");
    }

}

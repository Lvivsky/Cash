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
@WebServlet("/operation/transfer")
public class OperationTransferServlet extends HttpServlet {

    private TransactionsService transactionsService;

    @Override
    public void init() throws ServletException {
        transactionsService = new TransactionsServiceImpl();
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String fromAccount = req.getParameter("transfer_outcome_account");
        String toAccount = req.getParameter("transfer_income_account");
        int balance = Integer.parseInt(req.getParameter("transfer_balance"));
        if (balance < 0) balance = balance * (-1);

        String date = req.getParameter("transfer_date");
        Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date.replace('T',' '));
        long chosenDate = date1.toInstant().getEpochSecond();

        String comment = req.getParameter("transfer_comment");
        String state = req.getParameter("transfer_state");


        if (fromAccount.equals(toAccount)) {
            log.info("Cant transfer balance on the same account");
            resp.sendRedirect(req.getContextPath()+"/operation");
            return;
        }

        transactionsService.addOutcomeTransaction(fromAccount, state,String.valueOf(chosenDate),"1",
                String.valueOf(balance),comment);

        transactionsService.addIncomeTransaction(toAccount, state,String.valueOf(chosenDate),"1",
                String.valueOf(balance),comment);


        resp.sendRedirect(req.getContextPath()+"/operation");
    }
}

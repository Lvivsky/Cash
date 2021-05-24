package com.cash.servlet.operation;

import com.cash.model.Categories;
import com.cash.model.Transactions;
import com.cash.model.comparator.TransactionComparatorByChanged;
import com.cash.service.*;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Log4j
@WebServlet("/operation")
public class OperationServlet extends HttpServlet {

    private AccountsService accountsService;
    private CategoriesService categoriesService;
    private TransactionsService transactionsService;
    private List<Transactions> transactionsList;

    @Override
    public void init() throws ServletException {
        accountsService = new AccountsServiceImpl();
        categoriesService = new CategoriesServiceImpl();
        transactionsService = new TransactionsServiceImpl();
        transactionsList = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        req.setAttribute("accounts", accountsService.getAllAccountsWithCurrencyCodeAndNotLocked());
        req.setAttribute("operations_income", categoriesService.getAllRecursiveById(1));
        req.setAttribute("operations_outcome", categoriesService.getAllRecursiveById(2));

        String filterId = req.getParameter("filter_id");
        String income = req.getParameter("income");
        String outcome = req.getParameter("outcome");

        boolean fi = Objects.isNull(filterId);
        boolean ic = Objects.isNull(income);
        boolean oc = Objects.isNull(outcome);


        log.info("FILTER: " + filterId + " | " + income + " | " + outcome);


        transactionsList.clear();
        if (!fi && !ic && !oc) {
            // TODO :: nothing
        }

        if (filterId != null && !filterId.equals("-1")) {
            if (income == null && outcome == null) {
                transactionsList.addAll(transactionsService.getByIncomeAccount(filterId));
                transactionsList.addAll(transactionsService.getByExpanseAccount(filterId));
            }
            if (income != null && outcome == null) {

            }
            if (income == null && outcome != null) {

            }
        }


        transactionsList.sort(new TransactionComparatorByChanged());
        transactionsList.forEach(t -> t.setChanged(String.valueOf(
                Instant.ofEpochSecond(Long.parseLong(t.getChanged()))
        ).replace('T', ' ').replace('Z', ' ')));
        Collections.reverse(transactionsList);
        req.setAttribute("filter_account", transactionsList);
        req.getRequestDispatcher("operation.jsp").forward(req,resp);
    }
}

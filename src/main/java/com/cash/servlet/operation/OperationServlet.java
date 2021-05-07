package com.cash.servlet.operation;

import com.cash.model.Categories;
import com.cash.service.AccountsService;
import com.cash.service.AccountsServiceImpl;
import com.cash.service.CategoriesService;
import com.cash.service.CategoriesServiceImpl;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j
@WebServlet("/operation")
public class OperationServlet extends HttpServlet {

    private AccountsService accountsService;
    private CategoriesService categoriesService;

    @Override
    public void init() throws ServletException {
        accountsService = new AccountsServiceImpl();
        categoriesService = new CategoriesServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        req.setAttribute("accounts", accountsService.getAllAccountsWithCurrencyCode());
        req.setAttribute("operations_income", categoriesService.getAllRecursiveById(1));
        req.setAttribute("operations_outcome", categoriesService.getAllRecursiveById(2));

        req.getRequestDispatcher("operation.jsp").forward(req,resp);
    }
}

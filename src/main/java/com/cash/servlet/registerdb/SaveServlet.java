package com.cash.servlet.registerdb;

import com.cash.util.singleton.DbController;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Log4j
@WebServlet("/save")
public class SaveServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        req.setCharacterEncoding("UTF-8");
        DbController dbController = DbController.getInstance();

        resp.setContentType("*.cash");

        // Make sure to show the download dialog
        resp.setHeader("Content-disposition","attachment; filename=account");

        File file = dbController.getDbFile();

        // This should send the file to browser
        OutputStream out = resp.getOutputStream();
        FileInputStream in = new FileInputStream(file);
        byte[] buffer = new byte[4096];
        int length;
        while ((length = in.read(buffer)) > 0){
            out.write(buffer, 0, length);
        }
        in.close();
        out.flush();

        resp.sendRedirect(req.getContextPath() + "/account");
    }


}

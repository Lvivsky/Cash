package com.cash.servlet.registerdb;

import com.cash.util.singleton.SqliteConnection;
import com.cash.util.singleton.DbController;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@Log4j
@WebServlet("/upload-database")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class UploadServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        req.setCharacterEncoding("UTF-8");
        log.info("Upload database");


        Part filePart = req.getPart("database");
        String fileName = filePart.getSubmittedFileName();

        DbController dbController = DbController.getInstance();
        dbController.setCurrentDatabase("/Users/a1/Documents/api/cash/db/" + fileName);

        dbController.removeTemplate();

        for (Part part : req.getParts()) {
            part.write("/Users/a1/Documents/api/cash/db/" + fileName);
        }

        SqliteConnection.getInstance(dbController.getDbFileAbsolutePath());

        log.info("Database uploaded: " + dbController.getDbFileAbsolutePath());
        resp.sendRedirect(req.getContextPath() + "/account");


    }
}

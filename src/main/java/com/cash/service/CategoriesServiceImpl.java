package com.cash.service;

import com.cash.dao.CategoriesDao;
import com.cash.dao.CategoriesDaoImpl;
import com.cash.model.Categories;
import lombok.extern.log4j.Log4j;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class CategoriesServiceImpl implements CategoriesService {

    private final CategoriesDao categoriesDao;

    public CategoriesServiceImpl() {
        this.categoriesDao = new CategoriesDaoImpl();
    }

    @Override
    public List<Categories> getAll() {
        List<Categories> categories = new ArrayList<>();
        try {
            categories = categoriesDao.getAll();
            return categories;
        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
            return categories;
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
            return categories;
        }

    }
}

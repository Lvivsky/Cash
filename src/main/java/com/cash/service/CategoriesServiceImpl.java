package com.cash.service;

import com.cash.dao.CategoriesDao;
import com.cash.dao.CategoriesDaoImpl;
import com.cash.model.Categories;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class CategoriesServiceImpl implements CategoriesService {

    private static CategoriesDao categoriesDao;

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

    @Override
    public List<Categories> getAllRecursiveById(int id) {
        try {
            Categories c = categoriesDao.getCategoryById(id);
            return categoriesDao.getParent(c);
        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
            return new ArrayList<>();
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public void add(Categories categories) {
        try {
            categoriesDao.add(categories);
        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
        }
    }

    @Override
    public void edit(Categories categories) {
        try {
            categoriesDao.edit(categories);
        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
        }
    }
}

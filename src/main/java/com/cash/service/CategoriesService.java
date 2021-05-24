package com.cash.service;

import com.cash.model.Categories;

import java.util.List;

public interface CategoriesService {

    List<Categories> getAll();
    List<Categories> getAllRecursiveById(int id);

    void add(Categories categories);
    void edit(Categories categories);

}

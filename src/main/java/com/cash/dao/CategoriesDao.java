package com.cash.dao;

import com.cash.model.Categories;

import java.sql.SQLException;
import java.util.List;

public interface CategoriesDao {

    List<Categories> getAll() throws SQLException, ClassNotFoundException;
    List<Categories> getParent(Categories categories) throws SQLException, ClassNotFoundException;

    Categories getCategoryById(int id) throws SQLException, ClassNotFoundException;
    Categories getCategoryByGuid(String guid) throws SQLException, ClassNotFoundException;
    Categories getCategoryByParent(String parent) throws SQLException, ClassNotFoundException;

    void add(Categories category) throws SQLException, ClassNotFoundException;
    void edit(Categories category) throws SQLException, ClassNotFoundException;
    void edit(String guid, Categories category) throws SQLException, ClassNotFoundException;

    void editComment(int id, String comment) throws SQLException, ClassNotFoundException;

    void remove(int id) throws SQLException, ClassNotFoundException;
    void remove(String guid) throws SQLException, ClassNotFoundException;
    void removeWhereParentIs(String parent) throws SQLException, ClassNotFoundException;


}

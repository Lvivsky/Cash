package com.cash.dao;

import com.cash.model.Categories;
import com.cash.core.SqliteConnection;
import lombok.extern.log4j.Log4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class CategoriesDaoImpl implements CategoriesDao {

    @Override
    public List<Categories> getAll() throws SQLException, ClassNotFoundException {
        List<Categories> categories = new ArrayList<>();
        try (
                Connection connection = SqliteConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Categories"))
        {
            while (resultSet.next()) {
                categories.add(new Categories(
                        resultSet.getInt("Id"),
                        resultSet.getString("Guid"),
                        resultSet.getString("Changed"),
                        resultSet.getString("Deleted"),
                        resultSet.getString("Name"),
                        resultSet.getString("Comment"),
                        resultSet.getString("Parent")
                ));
            }
            statement.close();
            connection.close();
            resultSet.close();
            return categories;
        }
    }

    private Categories doResultSet(PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        Categories categories = new Categories();
        while (resultSet.next()) {
            categories.setId(resultSet.getInt("Id"));
            categories.setGuid(resultSet.getString("Guid"));
            categories.setChanged(resultSet.getString("Changed"));
            categories.setDeleted(resultSet.getString("Deleted"));
            categories.setName(resultSet.getString("Name"));
            categories.setComment(resultSet.getString("Comment"));
            categories.setParent(resultSet.getString("Parent"));
        }
        resultSet.close();
        return categories;
    }
    private void close(PreparedStatement statement, Connection connection) throws SQLException {
        statement.close();
        connection.close();
    }

    @Override
    public Categories getCategoryById(int id) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "Select * from Categories where Id = ?")
                ){
            statement.setInt(1, id);
            Categories categories = doResultSet(statement);

            close(statement,connection);
            return categories;
        }
    }

    @Override
    public Categories getCategoryByGuid(String guid) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "Select * from Categories where Guid = ?")
        ){
            statement.setString(1, guid);
            Categories categories = doResultSet(statement);

            close(statement,connection);
            return categories;
        }
    }

    @Override
    public Categories getCategoryByParent(String parent) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "Select * from Categories where Parent = ?")
        ){
            statement.setString(1, parent);
            Categories categories = doResultSet(statement);

            close(statement,connection);
            return categories;
        }
    }

    @Override
    public void add(Categories category) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO Categories values (?,?,?,?,?,?,?)")
                ) {
            statement.setInt(1, category.getId());
            statement.setString(2,category.getGuid());
            statement.setString(3,category.getChanged());
            statement.setString(4,category.getDeleted());
            statement.setString(5,category.getName());
            statement.setString(6,category.getComment());
            statement.setString(7,category.getParent());
            statement.execute();
            close(statement,connection);
        }
    }

    @Override
    public void edit(int id, Categories category) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "UPDATE Categories SET Name=?, Comment=?, Parent=? WHERE Id = ?")
                ) {
            statement.setString(1,category.getName());
            statement.setString(2,category.getComment());
            statement.setString(3,category.getParent());
            statement.setInt(4, id);
            statement.execute();
            close(statement,connection);
        }
    }

    @Override
    public void edit(String guid, Categories category) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "UPDATE Categories SET Name=?, Comment=?, Parent=? WHERE Guid = ?")
        ) {
            statement.setString(1,category.getName());
            statement.setString(2,category.getComment());
            statement.setString(3,category.getParent());
            statement.setString(4, guid);
            statement.execute();
            close(statement,connection);
        }
    }

    @Override
    public void editComment(int id, String comment) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "UPDATE Categories SET Comment=? WHERE Id = ?")
        ) {
            statement.setString(1,comment);
            statement.setInt(2, id);
            statement.execute();
            close(statement,connection);
        }
    }

    @Override
    public void remove(int id) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "DELETE FROM Categories WHERE Id=?")
        ) {
            statement.setInt(1,id);
            statement.execute();
            close(statement,connection);
        }
    }

    @Override
    public void remove(String guid) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "DELETE FROM Categories WHERE Id=?")
        ) {
            statement.setString(1,guid);
            statement.execute();
            close(statement,connection);
        }
    }

    @Override
    public void removeWhereParentIs(String parent) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "DELETE FROM Categories WHERE Parent=?")
        ) {
            statement.setString(1,parent);
            statement.execute();
            close(statement,connection);
        }
    }
}

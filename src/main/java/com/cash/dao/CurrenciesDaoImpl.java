package com.cash.dao;

import com.cash.core.SqliteConnection;
import com.cash.model.Currencies;
import lombok.extern.log4j.Log4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class CurrenciesDaoImpl implements CurrenciesDao {

    private void close(Statement statement, Connection connection, ResultSet resultSet) throws SQLException {
        statement.close();
        connection.close();
        resultSet.close();
    }

    @Override
    public List<Currencies> getAll() throws SQLException, ClassNotFoundException {
        List<Currencies> currencies = new ArrayList<>();
        try (
                Connection connection = SqliteConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(
                        "SELECT * FROM Currencies")
                ) {

            while (resultSet.next()) {
                currencies.add(new Currencies(
                        resultSet.getInt("Id"),
                        resultSet.getString("Guid"),
                        resultSet.getString("Changed"),
                        resultSet.getString("Deleted"),
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Precision")
                ));
            }
            log.info("Get currencies list");
            close(statement,connection,resultSet);
            return currencies;
        }
    }

    @Override
    public Currencies getByCode(String code) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM Currencies WHERE Code=?")
                ) {
            statement.setString(1,code);
            return doGetBy(statement);
        }
    }

    @Override
    public Currencies getById(int id) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM Currencies WHERE Id=?")
        ) {
            statement.setInt(1,id);
            return doGetBy(statement);
        }
    }

    private static Currencies doGetBy(PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        Currencies currencies = new Currencies();
        while (resultSet.next()) {
            currencies.setId(resultSet.getInt("Id"));
            currencies.setGuid(resultSet.getString("Guid"));
            currencies.setChanged(resultSet.getString("Changed"));
            currencies.setDeleted(resultSet.getString("Deleted"));
            currencies.setCode(resultSet.getString("Code"));
            currencies.setName(resultSet.getString("Name"));
            currencies.setPrecision(resultSet.getString("Precision"));
        }
        return currencies;
    }




    @Override
    public void add(Currencies currencies) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO Currencies (Guid,Changed,Deleted,Code,Name,Precision) VALUES (?,?,?,?,?,?)")
                ) {
            statement.setString(1,currencies.getGuid());
            statement.setString(2,currencies.getChanged());
            statement.setString(3,currencies.getDeleted());
            statement.setString(4,currencies.getCode());
            statement.setString(5,currencies.getName());
            statement.setString(6,currencies.getPrecision());
            statement.execute();
            log.info("Insert new currency " + currencies.toString());
        }
    }

    @Override
    public void edit(int id, Currencies currencies) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "UPDATE Currencies SET Name=?, Code=?, Precision=? WHERE Id = ?")
                ) {
            statement.setString(1,currencies.getName());
            statement.setString(2,currencies.getCode());
            statement.setString(3,currencies.getPrecision());
            statement.execute();
            log.info("Edit currency id:"+id+" on" + currencies.toString());
        }
    }

    @Override
    public void remove(int id) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "DELETE FROM Currencies WHERE Id=?")
                ) {
            statement.setInt(1,id);
            statement.execute();
            log.info("Delete currency id:" + id);
        }
    }

    @Override
    public boolean existByCode(String code) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = SqliteConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT 1 FROM Currencies WHERE Code=?")
                ) {
            statement.setString(1,code);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        }
    }
}

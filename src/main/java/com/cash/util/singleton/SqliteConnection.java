package com.cash.util.singleton;

import lombok.Data;
import lombok.ToString;
import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.SQLException;

@Data
@ToString
public class SqliteConnection {
    private static SqliteConnection instance;
    private static final String SQL_DRIVER = "com.cash.dialect.SQLiteDialect";

    private static String url;
    private static String username;
    private static String password;

    private SqliteConnection(String _url) {
        url = "jdbc:sqlite:"+_url;
    }


    public static SqliteConnection getInstance(String url) {
        if (instance == null)
            instance = new SqliteConnection(url);
        return instance;
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(SQL_DRIVER);

        SQLiteDataSource sqLiteDataSource = new SQLiteDataSource();
        sqLiteDataSource.setUrl(url);
        return sqLiteDataSource.getConnection();
    }

    public static String getUrl() { return url; }
    public static void setUrl(String _url) { url = "jdbc:sqlite:"+_url; }

}

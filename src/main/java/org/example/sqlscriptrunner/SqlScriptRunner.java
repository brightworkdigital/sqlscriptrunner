package org.example.sqlscriptrunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlScriptRunner {
    private static final String SQLITE_URL = "jdbc:sqlite:database/database.db";
    private static final String DB_URL = "jdbc:h2:mem:testdb";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
//    private static Connection connection;

    public void runSql(String sql) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            statement.execute(sql);
        }
    }

    public void runSqlFile(File sqlFile) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String sql = new String(Files.readAllBytes(sqlFile.toPath()));
            statement.execute(sql);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

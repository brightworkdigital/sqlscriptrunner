package org.example.sqlscriptrunner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1.0/database")
public class DatabaseController {

    @GetMapping("/reset")
    public void resetDatabase() throws SQLException {
        SqlScriptRunner runner = new SqlScriptRunner();

        // runner.runSql("DROP TABLE IF EXISTS USERS; CREATE TABLE USERS (id INTEGER AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255));");

        runner.runSqlFile(new File("database/create_users_table.sql"));
        runner.runSqlFile(new File("database/seed_users_table.sql"));

    }
}

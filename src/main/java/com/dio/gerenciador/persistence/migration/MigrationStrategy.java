package com.dio.gerenciador.persistence.migration;

import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import lombok.AllArgsConstructor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;

import static com.dio.gerenciador.persistence.config.ConnectionConfig.getConnection;

@AllArgsConstructor
public class MigrationStrategy {
    private final Connection connection;

    public void executeMigration(){
        var originalOut = System.out;
        var originalErr = System.err;
        try {
            try (var fos = new FileOutputStream("liquibase.log")) {
                System.setOut(new PrintStream(fos));
                System.setErr(new PrintStream(fos));
                try (var connection = getConnection();
                     var jdbcConnection = new JdbcConnection(connection);
                ) {
                    var liquiBase = new Liquibase(
                            "/db/chancelog/db.changelog-master.yml",
                            new ClassLoaderResourceAccessor(),
                            jdbcConnection
                    );
                } catch (SQLException | LiquibaseException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            System.setOut(originalOut);
            System.setErr(originalErr);
        }
    }
}

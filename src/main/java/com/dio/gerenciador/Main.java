package com.dio.gerenciador;

import com.dio.gerenciador.persistence.migration.MigrationStrategy;

import java.sql.SQLException;

import static com.dio.gerenciador.persistence.config.ConnectionConfig.getConnection;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (var connection = getConnection()) {
            new MigrationStrategy(connection).executeMigration();
        }
    }
}

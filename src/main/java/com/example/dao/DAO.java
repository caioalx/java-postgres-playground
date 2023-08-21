package com.example.dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

public class DAO {
    protected Connection conn;

    public DAO(Connection conn) {
        this.conn = conn;
    }

    public void listar(String tabela) {
        String sql = "select * from " + tabela;

        try {
            var statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            var resultMetadata = result.getMetaData();
            int cols = resultMetadata.getColumnCount();

            for (int i = 1; i <= cols; i++) {
                System.out.printf("%-25s | ", resultMetadata.getColumnName(i));
            }

            System.out.println();

            while(result.next()) {
                for (int i = 1; i < cols; i++) {
                    System.out.printf("%-25s | ", result.getString(i));
                }
                System.out.println();
            }

        } catch(SQLException e) {
            System.err.println("Não foi possível executar a consulta ao banco de dados: " + e.getMessage());
        }
    }

}

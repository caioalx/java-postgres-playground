package com.example;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppListarEstados {
    
    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch(ClassNotFoundException e) {
            System.err.println("Não foi possível carregar a biblioteca para acesso ao banco de dados.");
        }

        Statement statement = null;
        try(var conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "gitpod", "")) {
            System.out.println("Conexão com o banco realizada com sucesso");

            statement = conn.createStatement();
            var result = statement.executeQuery("select * from estado");

            while(result.next()) {
                System.out.printf("ID: %d, NOME: %s, UF: %s, AREA_KM2: %d, POPULACAO: %d \n", result.getInt("id"), result.getString("nome"), result.getString("uf"), result.getInt("area_km2"), result.getInt("populacao"));
            }            

        } catch (SQLException e) {
            if(statement == null)
                System.err.println("Não foi possível conectar ao banco de dados.");
            else 
                System.err.println("Não foi possível executar a consulta ao banco de dados.");
        }

    }

}

package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.example.model.Estado;

public class EstadoDAO extends DAO {
    
    public EstadoDAO(Connection conn) {
        super(conn);
    }

    public List<Estado> listar() throws SQLException {
        List<Estado> lista = new LinkedList<>();
        var statement = conn.createStatement();
        var result = statement.executeQuery("select * from estado");
        while(result.next()) {
            var estado = new Estado();
            estado.setId(result.getLong("id"));
            estado.setNome(result.getString("nome"));
            estado.setUf(result.getString("uf"));
            estado.setAreaKm2(result.getInt("area_km2"));
            estado.setPopulacao(result.getInt("populacao"));
            lista.add(estado);
        }
        return lista;
    }

    public void localizar(String uf) {
        System.out.println("Localiza estado: " + uf);
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("select * from estado where lower(uf) = ?");
            preparedStatement.setString(1, uf.toLowerCase());
    
            ResultSet result = preparedStatement.executeQuery();
    
            if(result.next()) {
                System.out.printf("ID: %d, NOME: %s, UF: %s, AREA_KM2: %d, POPULACAO: %d \n", result.getInt("id"), result.getString("nome"), result.getString("uf"), result.getInt("area_km2"), result.getInt("populacao"));
            }
        } catch(SQLException e) {
            System.err.println("Não foi possível executar a consulta ao banco de dados: " + e.getMessage());
        }
    }    

}

package com.example.empresaFinanceira.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.example.dao.DAO;
import com.example.empresaFinanceira.model.Transacao;

public class TransacaoDAO extends DAO {
    
    public TransacaoDAO(Connection conn) {
        super(conn);
    }

    public List<Transacao> listar(String cliente) {
        if(cliente == null) {
            throw new IllegalArgumentException("O cliente é obrigatório");
        }
        String sql = "select * from transacao where louwer(cliente) like ? ";
        List<Transacao> transacoes = new LinkedList<>();
        try{
            var statement = conn.prepareStatement(sql);
            statement.setString(1, cliente.toLowerCase());
            var result = statement.executeQuery();
            while(result.next()) {
                Transacao transacao = new Transacao(
                    result.getString("cliente"), 
                    result.getDouble("valor"), 
                    result.getString("moeda"), 
                    result.getString("tipo").charAt(0));
                transacao.setId(result.getInt("id"));
                transacoes.add(transacao);
            }
        } catch(SQLException e) {
            throw new RuntimeException("Não foi possível obter as transações do cliente", e);
        }

        return transacoes;
    }
}

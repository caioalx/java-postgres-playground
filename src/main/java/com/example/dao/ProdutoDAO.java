package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.model.Produto;

public class ProdutoDAO extends DAO {

    public ProdutoDAO(Connection conn) {
        super(conn);
    }

    public void remover(long id) {
        String sql = "delete from produto where id = ?";

        try(var preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            int rows = preparedStatement.executeUpdate();

            if(rows > 0) System.out.println("Registro removido");
            else System.out.println("Registro não localizado");
             
        } catch (SQLException e) {
            System.err.println("Não foi possível executar a consulta ao banco de dados: " + e.getMessage());
        }
    }

    public void inserir(Produto produto) {
        String sql = "insert into produto(nome, marca_id, valor) values (?, ?, ?)";

        try(var preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setLong(2, produto.getMarca().getId());
            preparedStatement.setBigDecimal(3, produto.getValor());

            int rows = preparedStatement.executeUpdate();

            if(rows > 0) System.out.println("Registro inserido");
            else System.out.println("Registro não inserido");

        } catch(SQLException e) {
            System.err.println("Não foi possível executar a consulta ao banco de dados: " + e.getMessage());
        }
    }

    public void alterar(Produto produto) {
        String sql = "update produto set nome = ?, marca_id = ?, valor = ? where id = ?";

        try(var preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setLong(2, produto.getMarca().getId());
            preparedStatement.setBigDecimal(3, produto.getValor());
            preparedStatement.setLong(4, produto.getId());

            int rows = preparedStatement.executeUpdate();

            if(rows > 0) System.out.println("Registro alterado");
            else System.out.println("Registro não alterado");

        } catch(SQLException e) {
            System.err.println("Não foi possível executar a consulta ao banco de dados: " + e.getMessage());
        }
    }    

        
}

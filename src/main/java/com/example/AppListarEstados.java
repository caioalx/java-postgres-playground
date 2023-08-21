package com.example;

import java.math.BigDecimal;

import java.sql.SQLException;

import com.example.dao.ConnectionManager;
import com.example.dao.DAO;
import com.example.dao.EstadoDAO;
import com.example.dao.ProdutoDAO;
import com.example.model.Marca;
import com.example.model.Produto;

public class AppListarEstados {
    
    public static void main(String[] args) {
        new AppListarEstados();
    }
    
    public AppListarEstados() {
        try(var conn = ConnectionManager.getConnection()) {
            var dao = new DAO(conn);

            var estadoDAO = new EstadoDAO(conn);

            var listaEstados = estadoDAO.listar();
            for (var estado : listaEstados) {
                System.out.println(estado);
            }
            estadoDAO.localizar("sp");

            var produtoDAO = new ProdutoDAO(conn);

            var marca = new Marca();
            marca.setId(1L);
            
            var produto = new Produto();
            produto.setNome("produto teste");
            produto.setMarca(marca);
            produto.setValor(new BigDecimal(200.50));

            produtoDAO.inserir(produto);
            dao.listar("produto");

            marca.setId(2L);
            produto.setId(205L);
            produto.setNome("produto teste alerado");
            produto.setValor(new BigDecimal(500));
            produtoDAO.alterar(produto);
            dao.listar("produto");
            
            produtoDAO.remover(203L);
            dao.listar("produto");

        } catch (SQLException e) {
            System.err.println("Não foi possível conectar ao banco de dados.");
        }
    }



    /*
    Carrega automaticamente
    private void carregarDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch(ClassNotFoundException e) {
            System.err.println("Não foi possível carregar a biblioteca para acesso ao banco de dados.");
        }
    }*/

}

package com.example.escola.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.escola.model.Aluno;

public class AlunoDAO extends DAO {
    
    public AlunoDAO(Connection conn) {
        super(conn);
    }

    public void inserir(Aluno aluno) {
        try {
            String sql = "insert into aluno(nome) values (?)";
            PreparedStatement statement = getConn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, aluno.getNome());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            if(result.next()) aluno.setMatricula(result.getInt(1));
            System.out.println("Aluno criado com sucesso");
        } catch(SQLException e) {
            throw new RuntimeException("Erro ao criar o aluno", e);
        }
    }

    public void inserirNota(int idDisciplina, double nota, int matricula) {
        if(idDisciplina < 1 || idDisciplina > 3){
            throw new IllegalArgumentException("O id da disciplina deve estar entre 1 e 3");
        }
        try {
            String sql = "update aluno set nota" + idDisciplina + "= ? where matricula = ? ";
            PreparedStatement statement = getConn().prepareStatement(sql);
            statement.setDouble(1, nota);
            statement.setInt(2, matricula);
            statement.executeUpdate();
            System.out.println("Nota inseririda com sucesso");
        } catch(SQLException e) {
            throw new RuntimeException("Erro ao inserir a nota do aluno", e);
        }
    }

    public List<Aluno> listar() {
        try {
            String sql = "select * from aluno";
            PreparedStatement statement = getConn().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            List<Aluno> alunos = new ArrayList<>();
            while(result.next()) {
                alunos.add(obtemAluno(result));
            }
            return alunos;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar alunos", e);
        }
    }

    public Aluno obtem(int matricula) {
        try {
            String sql = "select * from aluno where matricula = ?";
            PreparedStatement statement = getConn().prepareStatement(sql);
            statement.setInt(1, matricula);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                return obtemAluno(result);
            }
            throw new IllegalArgumentException("Aluno não encontrado");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar aluno", e);
        }
    }

    private Aluno obtemAluno(ResultSet result) throws SQLException {
        Aluno aluno = new Aluno();
        aluno.setNome(result.getString("nome"));
        aluno.setMatricula(result.getInt("matricula"));
        aluno.setNota1(result.getDouble("nota1"));
        aluno.setNota2(result.getDouble("nota2"));
        aluno.setNota3(result.getDouble("nota3"));
        return aluno;
    }    
}

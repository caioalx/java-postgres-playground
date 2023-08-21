package com.example.educacao.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.example.dao.DAO;
import com.example.educacao.model.Aluno;

public class AlunoDAO extends DAO {

    public AlunoDAO(Connection conn) {
        super(conn);
    }

    public List<Aluno> listar() {
        try {
            List<Aluno> alunos = new LinkedList<>();
            var statement = conn.createStatement();
            var result = statement.executeQuery("select * from aluno");
            while(result.next()) {
                Aluno aluno = new Aluno();
                aluno.setMatricula(result.getInt("matricula"));
                aluno.setNome(result.getString("nome"));
                aluno.setNota1(result.getDouble("nota1"));
                aluno.setNota2(result.getDouble("nota2"));
                aluno.setNota3(result.getDouble("nota3"));
                alunos.add(aluno);
            }
            return alunos;
        }catch(SQLException e) {
            throw new RuntimeException("Não foi possível listar os alunos", e);
        }
    }

    public void inserir(Aluno aluno) {
        try {
            var sql = "insert into aluno(nome) values(?)";
            var statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, aluno.getNome());
            statement.executeUpdate();
            var result = statement.getGeneratedKeys();
            if(result.next()) {
                aluno.setMatricula(result.getInt(1));
            }
        } catch(SQLException e) {
            throw new RuntimeException("Não foi possível inserir o aluno", e);
        }
    }

    public void inserirNota(int idDisciplina, double nota, int matricula) {
        if(idDisciplina <= 0 || idDisciplina > 3) {
            throw new IllegalArgumentException("O id da disciplina deve estar entre 1 e 3");
        }
        try {
            var sql = "update aluno set nota" + idDisciplina + " = ? where matricula = ?";
            var statement = conn.prepareStatement(sql);
            statement.setDouble(1, nota);
            statement.setInt(2, matricula);
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Não foi possível registrar a nota", e);
        }        
    }
}

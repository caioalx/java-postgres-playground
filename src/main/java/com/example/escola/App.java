package com.example.escola;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.example.escola.connection.ConnectionManager;
import com.example.escola.dao.AlunoDAO;
import com.example.escola.model.Aluno;

public class App {
    public static void main(String[] args) {
        new App();
    }

    public App() {
        carregaDriver();

        try(Connection conn = ConnectionManager.getConnection()) {
            AlunoDAO dao = new AlunoDAO(conn);
            Aluno aluno = inserirAluno(dao);
            inserirNotas(dao, aluno);
            listarAlunos(dao);
            calculaMediaAluno(dao, aluno);
        } catch(SQLException e) {
            e.printStackTrace();
            System.err.println("Não foi possível conectar ao banco de dados.");
        } catch(RuntimeException e) {
            System.err.println(e.getMessage());
        }            
    }

    private void carregaDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Biblioteca do banco de dados não carregada.");
        }
    }

    private Aluno inserirAluno(AlunoDAO dao) {
        Aluno aluno = new Aluno();
        aluno.setNome("Caio Silva");
        dao.inserir(aluno);
        System.out.println("Marticula: " + aluno.getMatricula());
        return aluno;
    }  

    private void inserirNotas(AlunoDAO dao, Aluno aluno) {
        dao.inserirNota(1, 6, aluno.getMatricula());
        dao.inserirNota(2, 10, aluno.getMatricula());
        dao.inserirNota(3, 7, aluno.getMatricula());    
    }

    private void listarAlunos(AlunoDAO dao) {
        List<Aluno> alunos = dao.listar();
        for (Aluno alunoLista : alunos) {
           System.out.println(alunoLista); 
        }
    }

    private void calculaMediaAluno(AlunoDAO dao, Aluno aluno) {
        Aluno alunoCalculoMedia = dao.obtem(aluno.getMatricula());
        System.out.println("Médias das notas do aluno: " + alunoCalculoMedia.calculaMedia());
    }
}

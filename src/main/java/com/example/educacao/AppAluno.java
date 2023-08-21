package com.example.educacao;

import java.sql.SQLException;
import java.util.List;

import com.example.dao.ConnectionManager;
import com.example.educacao.dao.AlunoDAO;
import com.example.educacao.model.Aluno;

public class AppAluno {
    
    public static void main(String[] args) {
        try(var conn = ConnectionManager.getConnection()) {
            Aluno aluno = new Aluno();
            aluno.setNome("Caio Silva");

            var alunoDAO = new AlunoDAO(conn);
            alunoDAO.inserir(aluno);
            System.out.println("Aluno inserido com sucesso!");
            
            alunoDAO.inserirNota(1, 5.5, aluno.getMatricula());
            alunoDAO.inserirNota(2, 10, aluno.getMatricula());
            alunoDAO.inserirNota(3, 9.75, aluno.getMatricula());

            List<Aluno> alunos = alunoDAO.listar();
            for (Aluno alunoLista : alunos) {
               System.out.println(alunoLista); 
            }
            
        } catch(SQLException e) {
            System.err.println("Não foi possível conectar ao banco de dados.");
        } catch(RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

}

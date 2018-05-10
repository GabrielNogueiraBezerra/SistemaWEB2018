/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexao.ConnectionFactory;
import java.sql.SQLException;
import Models.Dia;
import Models.Turno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Marcelo
 */
public class DiaDAO{
    private ConnectionFactory dao = ConnectionFactory.getInstancia();
    private static DiaDAO instancia;

    public static DiaDAO getInstancia() {
        if (instancia == null) {
            instancia = new DiaDAO();
        }

        return instancia;
    }
    
    public void save(Dia dia) throws SQLException, ClassNotFoundException{
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = conexao.prepareStatement("");
            stmt.setDate(1, dia.getData());
            
            stmt.executeUpdate();
            
            
            for(Turno turno:dia.getTurnos()){
                //Salvar os turnos que compõem o dia
            }
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void update(Dia dia) throws SQLException, ClassNotFoundException{
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = conexao.prepareStatement("");
            stmt.setDate(1, dia.getData());
            
            stmt.executeUpdate();
            //Atualizar os turnos que compõem o dia
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void find(Dia dia) throws SQLException, ClassNotFoundException{
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = conexao.prepareStatement("");
            stmt.setInt(1, dia.getId());
            result = stmt.executeQuery();
            
            while (result.next()) {
                dia.setData(result.getDate(""));
                
                //Buscar os Turnos que o compõem e setar no dia
            }
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void delete(Dia dia) throws SQLException, ClassNotFoundException{
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("");
            stmt.setInt(1, dia.getId());
            stmt.executeUpdate();
            
            
            for(Turno turno : dia.getTurnos()){
                TurnoDAO.getInstancia().delete(turno);
                dia.getTurnos().remove(turno);
            }
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
}

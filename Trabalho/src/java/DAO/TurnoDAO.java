/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Alimento;
import Models.Turno;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Marcelo
 */
public class TurnoDAO {
    private ConnectionFactory dao = ConnectionFactory.getInstancia();
    private static TurnoDAO instancia;

    public static TurnoDAO getInstancia() {
        if (instancia == null) {
            instancia = new TurnoDAO();
        }

        return instancia;
    }
    
    public void save(Turno turno) throws SQLException, ClassNotFoundException{
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = conexao.prepareStatement("");
            stmt.setString(1, turno.getNomeTurno());
            
            stmt.executeUpdate();
            
            for(Alimento alimento : turno.getAlimentos()){
                stmt = conexao.prepareStatement("");
                stmt.setInt(1, turno.getId());
                stmt.setInt(2, alimento.getId());
                stmt.executeUpdate();
            }
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void update(Turno turno) throws SQLException, ClassNotFoundException{
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = conexao.prepareStatement("");
            stmt.setInt(1, turno.getId());
            stmt.setString(2, turno.getNomeTurno());
            
            stmt.executeUpdate();
            
            ArrayList<Alimento> listaAlimentos = AlimentoDAO.getInstancia().getAlimentos();
            
            for(Alimento alimento : turno.getAlimentos()){
                stmt = conexao.prepareStatement("");
                
                //if(){
                    stmt.setInt(1, turno.getId());
                    stmt.setInt(2, alimento.getId());
                    stmt.executeUpdate();
                //}
            }
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void find(Turno turno) throws SQLException, ClassNotFoundException{
        
    }
    
    public void delete(Turno turno) throws SQLException, ClassNotFoundException{
        
    }
}

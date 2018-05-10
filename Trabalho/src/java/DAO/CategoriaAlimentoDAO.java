/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.CategoriaAlimento;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Marcelo Morera
 */
public class CategoriaAlimentoDAO {
    private ConnectionFactory dao = ConnectionFactory.getInstancia();
    private static CategoriaAlimentoDAO instancia;

    public static CategoriaAlimentoDAO getInstancia() {
        if (instancia == null) {
            instancia = new CategoriaAlimentoDAO();
        }

        return instancia;
    }
    
    public void save(CategoriaAlimento categoriaAlimento) throws SQLException, ClassNotFoundException{
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = conexao.prepareStatement("INSERT INTO CATEGORIA VALUES (0, ?)");
            stmt.setString(1, categoriaAlimento.getNomeCategoria());
            
            stmt.executeUpdate();
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void update(CategoriaAlimento categoriaAlimento) throws SQLException, ClassNotFoundException{
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = conexao.prepareStatement("UPDATE CATEGORIA SET NOME = ? WHERE ID = ?");
            stmt.setString(1, categoriaAlimento.getNomeCategoria());
            stmt.setInt(2, categoriaAlimento.getId());
            
            stmt.executeUpdate();
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void delete(CategoriaAlimento categoriaAlimento) throws SQLException, ClassNotFoundException{
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = conexao.prepareStatement("DELETE FROM CATEGORIA WHERE ID = ?");
            stmt.setInt(1, categoriaAlimento.getId());
            
            stmt.executeUpdate();
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void find(CategoriaAlimento categoriaAlimento) throws SQLException, ClassNotFoundException{
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        
        try{
            stmt = conexao.prepareStatement("SELECT NOME FROM CATEGORIA WHERE ID = ?");
            stmt.setInt(1, categoriaAlimento.getId());
            result = stmt.executeQuery();
            
            while(result.next()){
                categoriaAlimento.setNomeCategoria(result.getString("NOME"));
            }
            
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
}

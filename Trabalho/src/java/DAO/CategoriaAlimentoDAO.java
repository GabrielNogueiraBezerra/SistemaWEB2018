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
            stmt = conexao.prepareStatement("");
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
            stmt = conexao.prepareStatement("");
            stmt.setString(1, categoriaAlimento.getNomeCategoria());
            
            stmt.executeUpdate();
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void delete(CategoriaAlimento categoriaAlimento) throws SQLException, ClassNotFoundException{
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = conexao.prepareStatement("");
            stmt.setString(1, categoriaAlimento.getNomeCategoria());
            
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
            stmt = conexao.prepareStatement("");
            stmt.setString(1, categoriaAlimento.getNomeCategoria());
            
            stmt.executeUpdate();
            categoriaAlimento.setId(result.getInt(""));
            categoriaAlimento.setNomeCategoria(result.getString(""));
            
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Alimento;
import Models.CategoriaAlimento;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Marcelo Moreira
 */
public class AlimentoDAO {
    private ConnectionFactory dao = ConnectionFactory.getInstancia();
    private static AlimentoDAO instancia;

    public static AlimentoDAO getInstancia() {
        if (instancia == null) {
            instancia = new AlimentoDAO();
        }

        return instancia;
    }
    
    
    public void save(Alimento alimento) throws SQLException, ClassNotFoundException{
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = conexao.prepareStatement("");
            stmt.setString(1, alimento.getNome());
            stmt.setInt(2, alimento.getCategoriaAlimento().getId());
            stmt.setFloat(3, alimento.getQuantidadeCalorias());
            stmt.setFloat(4, alimento.getQuantidadeCarboidratos());
            stmt.setFloat(5, alimento.getQuantidadeFibras());
            
            stmt.executeUpdate();
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void update(Alimento alimento) throws SQLException, ClassNotFoundException{
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = conexao.prepareStatement("");
            stmt.setString(1, alimento.getNome());
            stmt.setInt(2, alimento.getCategoriaAlimento().getId());
            stmt.setFloat(3, alimento.getQuantidadeCalorias());
            stmt.setFloat(4, alimento.getQuantidadeCarboidratos());
            stmt.setFloat(5, alimento.getQuantidadeFibras());
            
            stmt.executeUpdate();
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void delete(Alimento alimento) throws SQLException, ClassNotFoundException{
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = conexao.prepareStatement("");
            stmt.setString(1, alimento.getNome());
            stmt.setInt(2, alimento.getCategoriaAlimento().getId());
            stmt.setFloat(3, alimento.getQuantidadeCalorias());
            stmt.setFloat(4, alimento.getQuantidadeCarboidratos());
            stmt.setFloat(5, alimento.getQuantidadeFibras());
            
            stmt.executeUpdate();
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void find(Alimento alimento) throws SQLException, ClassNotFoundException{
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        
        try{
            stmt = conexao.prepareStatement("");
            stmt.setString(1, alimento.getNome());
            stmt.setInt(2, alimento.getCategoriaAlimento().getId());
            stmt.setFloat(3, alimento.getQuantidadeCalorias());
            stmt.setFloat(4, alimento.getQuantidadeCarboidratos());
            stmt.setFloat(5, alimento.getQuantidadeFibras());
            
            stmt.executeUpdate();
            
            alimento.setId(result.getInt(""));
            CategoriaAlimento categoriaAlimento = new CategoriaAlimento(0, "");
            categoriaAlimento.find(result.getInt(""));
            alimento.setCategoriaAlimento(categoriaAlimento);
            alimento.setNomeCategoria(result.getString(""));
            
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
}

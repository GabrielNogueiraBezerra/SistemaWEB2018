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
import java.util.ArrayList;

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
    
    public void save(CategoriaAlimento categoriaAlimento) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("INSERT INTO CATEGORIA VALUES (0, ?)");
            stmt.setString(1, categoriaAlimento.getNomeCategoria());
            
            stmt.executeUpdate();
            
            categoriaAlimento.setId(this.find());
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void update(CategoriaAlimento categoriaAlimento) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("UPDATE CATEGORIA SET NOME = ? WHERE ID = ?");
            stmt.setString(1, categoriaAlimento.getNomeCategoria());
            stmt.setInt(2, categoriaAlimento.getId());
            
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void delete(CategoriaAlimento categoriaAlimento) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("DELETE FROM CATEGORIA WHERE ID = ?");
            stmt.setInt(1, categoriaAlimento.getId());
            
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void find(CategoriaAlimento categoriaAlimento) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        
        try {
            stmt = conexao.prepareStatement("SELECT NOME FROM CATEGORIA WHERE ID = ?");
            stmt.setInt(1, categoriaAlimento.getId());
            result = stmt.executeQuery();
            
            while (result.next()) {
                categoriaAlimento.setNomeCategoria(result.getString("NOME"));
            }
            
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public ArrayList<CategoriaAlimento> buscarTodos() throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        ArrayList<CategoriaAlimento> categorias = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM CATEGORIA");
            result = stmt.executeQuery();
            
            while (result.next()) {
                CategoriaAlimento categoriaAlimento = new CategoriaAlimento();
                categoriaAlimento.setId(result.getInt("id"));
                categoriaAlimento.setNomeCategoria(result.getString("NOME"));
                categorias.add(categoriaAlimento);
            }
            
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
            return categorias;
        }
    }
    
    private int find() throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        int resultado = 0;
        
        try {
            stmt = conexao.prepareStatement("SELECT AUTO_INCREMENT as id FROM information_schema.tables WHERE table_name = 'categoria' AND table_schema = 'bancoweb'");
            result = stmt.executeQuery();
            
            while (result.next()) {
                resultado = result.getInt("id");
            }
            
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
            return resultado - 1;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Cardapio;
import Models.Dia;
import Models.Usuario;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Marcelo
 */
public class CardapioDAO {
    private ConnectionFactory dao = ConnectionFactory.getInstancia();
    private static CardapioDAO instancia;

    public static CardapioDAO getInstancia() {
        if (instancia == null) {
            instancia = new CardapioDAO();
        }

        return instancia;
    }
    
    public void save(Cardapio cardapio) throws SQLException, ClassNotFoundException{
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = conexao.prepareStatement("");
            stmt.setInt(1, cardapio.getUsuario().getId());
            stmt.setDate(2, cardapio.getDatainicio());
            stmt.setDate(3, cardapio.getDatafim());
            
            
            stmt.executeUpdate();
            
            
            for(Dia dia:cardapio.getDias()){
                //Salvar os dias que compõem o cardápio
            }
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void update(Cardapio cardapio) throws SQLException, ClassNotFoundException{
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = conexao.prepareStatement("");
            stmt.setInt(1, cardapio.getUsuario().getId());
            stmt.setDate(2, cardapio.getDatainicio());
            stmt.setDate(3, cardapio.getDatafim());
            
            
            stmt.executeUpdate();
            
            
            for(Dia dia:cardapio.getDias()){
                //Atualizar os dias que compõem o cardápio
            }
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void find(Cardapio cardapio) throws SQLException, ClassNotFoundException{
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = conexao.prepareStatement("");
            stmt.setInt(1, cardapio.getId());
            result = stmt.executeQuery();
            
            while (result.next()) {
                Usuario usuario = new Usuario();
                usuario.find(result.getInt(""));
                cardapio.setUsuario(usuario);
                cardapio.setDatainicio(result.getDate(""));
                cardapio.setDatafim(result.getDate(""));
                
                //Buscar os Dias que o compõem e setar no cardápio
            }
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void delete(Cardapio cardapio) throws SQLException, ClassNotFoundException{
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("");
            stmt.setInt(1, cardapio.getId());
            stmt.executeUpdate();
            
            for(Dia dia : cardapio.getDias()){
                DiaDAO.getInstancia().delete(dia);
                cardapio.getDias().remove(dia);
            }
            
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
}

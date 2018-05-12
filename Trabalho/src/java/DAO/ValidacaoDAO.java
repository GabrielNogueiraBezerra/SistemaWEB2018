package DAO;

import Models.Validacao;
import conexao.ConnectionFactory;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Gabriel
 */
public class ValidacaoDAO {
    
    private ConnectionFactory dao = ConnectionFactory.getInstancia();
    private static ValidacaoDAO instancia;
    
    public static ValidacaoDAO getInstancia() {
        if (instancia == null) {
            instancia = new ValidacaoDAO();
        }
        
        return instancia;
    }
    
    public void save(Validacao validacao) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("INSERT INTO `validacao`(`login`, `senha`) VALUES (?, ?)");
            stmt.setString(1, validacao.getLogin());
            stmt.setString(2, validacao.getSenha());
            stmt.executeUpdate();
            
            validacao.setId(this.find());
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void update(Validacao validacao) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("UPDATE `validacao` SET `login` = ?,`senha` = ? WHERE `id` = ?");
            stmt.setString(1, validacao.getLogin());
            stmt.setString(2, validacao.getSenha());
            stmt.setInt(3, validacao.getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void delete(Validacao validacao) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("DELETE FROM `validacao` WHERE `id` = ?");
            stmt.setInt(1, validacao.getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void find(Validacao validacao) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = conexao.prepareStatement("SELECT LOGIN, SENHA FROM VALIDACAO WHERE ID = ?");
            stmt.setInt(1, validacao.getId());
            result = stmt.executeQuery();
            
            while (result.next()) {
                validacao.setLogin(result.getString("LOGIN"));
                validacao.setSenha(result.getString("SENHA"));
            }
            
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    private int find() throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        int resultado = 0;
        
        try {
            stmt = conexao.prepareStatement("SELECT AUTO_INCREMENT as id FROM information_schema.tables WHERE table_name = 'validacao' AND table_schema = 'bancoweb'");
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

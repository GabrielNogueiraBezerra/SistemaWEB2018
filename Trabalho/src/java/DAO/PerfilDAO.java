package DAO;

import Models.Perfil;
import conexao.ConnectionFactory;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Gabriel
 */
public class PerfilDAO {

    private ConnectionFactory dao = ConnectionFactory.getInstancia();
    private static PerfilDAO instancia;

    public static PerfilDAO getInstancia() {
        if (instancia == null) {
            instancia = new PerfilDAO();
        }

        return instancia;
    }

    public void save(Perfil perfil) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("INSERT INTO PERFIL (DESCRICAO, VALOR) VALUES (?, ?)");
            stmt.setString(1, perfil.getDescricao());
            stmt.setFloat(2, perfil.getValor());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void update(Perfil perfil) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("UPDATE PERFIL SET DESCRICAO = ?, VALOR = ? WHERE ID = ?");
            stmt.setString(1, perfil.getDescricao());
            stmt.setFloat(2, perfil.getValor());
            stmt.setInt(3, perfil.getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void delete(Perfil perfil) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("DELETE FROM PERFIL WHERE ID = ?");
            stmt.setInt(1, perfil.getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void find(Perfil perfil) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = conexao.prepareStatement("SELECT VALOR, DESCRICAO FROM PERFIL WHERE ID = ?");
            stmt.setInt(1, perfil.getId());
            result = stmt.executeQuery();
            while (result.next()) {
                perfil.setDescricao(result.getString("DESCRICAO"));
                perfil.setValor(result.getFloat("VALOR"));
            }
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
}

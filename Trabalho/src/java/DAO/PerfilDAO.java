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
            stmt = conexao.prepareStatement("");
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
            stmt = conexao.prepareStatement("");
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
            stmt = conexao.prepareStatement("");
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
            stmt = conexao.prepareStatement("");
            stmt.setInt(1, perfil.getId());
            stmt.executeQuery();

            perfil.setDescricao(result.getString(""));
            perfil.setValor(result.getFloat(""));

        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
}

package DAO;

import Models.Item;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class ItemDAO {

    private ConnectionFactory dao = ConnectionFactory.getInstancia();
    private static ItemDAO instancia;

    public static ItemDAO getInstancia() {
        if (instancia == null) {
            instancia = new ItemDAO();
        }

        return instancia;
    }

    public void save(Item item) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("");
            stmt.setString(1, item.getPeriodo());
            stmt.setInt(2, item.getIdHistorico());
            stmt.setDate(3, item.getData());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void update(Item item) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("");
            stmt.setString(1, item.getPeriodo());
            stmt.setInt(2, item.getIdHistorico());
            stmt.setDate(3, item.getData());
            stmt.setInt(4, item.getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void delete(Item item) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("");
            stmt.setInt(1, item.getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void find(Item item) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = conexao.prepareStatement("");
            stmt.setInt(1, item.getId());
            stmt.executeQuery();

            item.setData(result.getDate(""));
            item.setIdHistorico(result.getInt(""));
            item.setPeriodo(result.getString(""));

        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
}

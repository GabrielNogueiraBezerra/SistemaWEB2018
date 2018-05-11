package DAO;

import Models.Historico;
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
            stmt = conexao.prepareStatement("INSERT INTO ITEMHISTORICO (PERIODO, DATA) VALUES (?,?)");
            stmt.setString(1, item.getPeriodo());
            stmt.setDate(2, item.getData());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void update(Item item) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("UPDATE ITEMHISTORICO SET PERIODO = ?, DATA = ? WHERE ID = ?");
            stmt.setString(1, item.getPeriodo());
            stmt.setDate(2, item.getData());
            stmt.setInt(3, item.getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void delete(Item item) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("DELETE FROM ITEMHISTORICO WHERE ID = ?");
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
            stmt = conexao.prepareStatement("SELECT DATA, PERIODO FROM ITEMHISTORICO WHERE ID = ?");
            stmt.setInt(1, item.getId());
            result = stmt.executeQuery();
            
            while(result.next()){
                item.setData(result.getDate("DATA"));
                item.setPeriodo(result.getString("PERIODO"));
            }
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void find(Historico historico) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = conexao.prepareStatement("SELECT ID, IDHISTORICO, DATA, PERIODO FROM ITEMHISTORICO WHERE IDHISTORICO = ?");
            stmt.setInt(1, historico.getId());
            stmt.executeQuery();

            while (result.next()) {
                Item item = new Item(result.getInt("IDHISTORICO"), result.getDate("DATA"), result.getString("PERIODO"));
                item.setId(result.getInt("ID"));
                historico.addItem(item);
            }

        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
}

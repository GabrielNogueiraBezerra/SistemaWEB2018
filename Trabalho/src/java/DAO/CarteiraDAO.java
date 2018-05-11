package DAO;

import Models.Carteira;
import conexao.ConnectionFactory;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Gabriel
 */
public class CarteiraDAO {

    private ConnectionFactory dao = ConnectionFactory.getInstancia();
    private static CarteiraDAO instancia;

    public static CarteiraDAO getInstancia() {
        if (instancia == null) {
            instancia = new CarteiraDAO();
        }

        return instancia;
    }

    public void save(Carteira carteira) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("INSERT INTO CARTEIRA (VALIDADE, SALDO) VALUES (?, ?)");
            stmt.setString(1, carteira.getValidade());
            stmt.setFloat(2, carteira.getValorSaldo());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void update(Carteira carteira) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("UPDATE CARTEIRA SET VALIDADE = ?, SALDO = ? WHERE ID = ?");
            stmt.setString(1, carteira.getValidade());
            stmt.setFloat(2, carteira.getValorSaldo());
            stmt.setInt(3, carteira.getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void delete(Carteira carteira) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("DELETE FROM CARTEIRA WHERE ID = ?");
            stmt.setInt(1, carteira.getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void find(Carteira carteira) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = conexao.prepareStatement("SELECT VALIDADE, SALDO FROM CARTEIRA WHERE ID = ?");
            stmt.setInt(1, carteira.getId());
            result = stmt.executeQuery();
            
            while(result.next()){
                carteira.setValidade(result.getString("VALIDADE"));
                carteira.setValorSaldo(result.getFloat("SALDO"));
            }

        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
}

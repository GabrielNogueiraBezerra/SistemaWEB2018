/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Alimento;
import Models.Turno;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Marcelo
 */
public class TurnoDAO {

    private ConnectionFactory dao = ConnectionFactory.getInstancia();
    private static TurnoDAO instancia;

    public static TurnoDAO getInstancia() {
        if (instancia == null) {
            instancia = new TurnoDAO();
        }

        return instancia;
    }

    public void save(Turno turno) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("INSERT INTO `turno` VALUES (0, ?, ?)");
            stmt.setString(1, turno.getNomeTurno());
            stmt.setDate(2, turno.getDate());

            stmt.executeUpdate();

            turno.setId(this.find());
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }

    }

    public void save(Turno turno, Alimento alimento) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("INSERT INTO `itemalimento` VALUES (0, ?, ?)");
            stmt.setInt(1, turno.getId());
            stmt.setInt(2, alimento.getId());

            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void update(Turno turno) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("UPDATE `turno` SET `turno` = ?,`data` = ? WHERE `id` = ?");
            stmt.setString(1, turno.getNomeTurno());
            stmt.setDate(2, turno.getDate());
            stmt.setInt(3, turno.getId());

            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void find(Turno turno) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = conexao.prepareStatement("SELECT `turno`, `data` FROM `turno` WHERE `id` = ?");
            stmt.setInt(1, turno.getId());
            result = stmt.executeQuery();

            while (result.next()) {
                turno.setNomeTurno(result.getString("turno"));
                turno.setDate(result.getDate("data"));
            }

            stmt = conexao.prepareStatement("SELECT `idTurno`, `idAlimento` FROM `itemalimento` WHERE `idTurno` = ?");
            stmt.setInt(1, turno.getId());
            result = stmt.executeQuery();
            
            ArrayList<Alimento> alimentos = new ArrayList<Alimento>();

            while (result.next()) {
                Alimento alimento = new Alimento();
                alimento.find(result.getInt("idAlimento"));
                alimentos.add(alimento);
            }
            
            turno.setAlimentos(alimentos);

        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void delete(Turno turno) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("DELETE FROM `itemalimento` WHERE `idTurno` = ?");
            stmt.setInt(1, turno.getId());
            stmt.executeUpdate();

            stmt = conexao.prepareStatement("DELETE FROM `turno` WHERE `id` = ?");
            stmt.setInt(1, turno.getId());
            stmt.executeUpdate();

        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void delete(Turno turno, Alimento alimento) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            
            stmt = conexao.prepareStatement("DELETE FROM `itemalimento` WHERE `idTurno` = ? AND `idAlimento` = ?");
            stmt.setInt(1, turno.getId());
            stmt.setInt(2, alimento.getId());
            stmt.executeUpdate();

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
            stmt = conexao.prepareStatement("SELECT AUTO_INCREMENT as id FROM information_schema.tables WHERE table_name = 'turno' AND table_schema = 'bancoweb'");
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

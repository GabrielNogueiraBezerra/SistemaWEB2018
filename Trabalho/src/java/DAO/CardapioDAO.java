/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Cardapio;
import Models.Turno;
import Models.Usuario;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public CardapioDAO() {
        super();
    }

    public void save(Cardapio cardapio) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("INSERT INTO `cardapio` VALUES (0, ?, ?, ?)");
            stmt.setDate(1, cardapio.getDatainicio());
            stmt.setDate(2, cardapio.getDatafim());
            stmt.setInt(3, cardapio.getUsuario().getId());

            stmt.executeUpdate();

            cardapio.setId(this.find());
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void save(Cardapio cardapio, Turno turno) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("INSERT INTO `turnocardapio` VALUES (0, ?, ?)");
            stmt.setInt(1, turno.getId());
            stmt.setInt(2, cardapio.getId());

            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void update(Cardapio cardapio) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("UPDATE `cardapio` SET `datainicio` = ?, `datafim` = ?,`idusuario` = ? WHERE `id` = ?");
            stmt.setDate(1, cardapio.getDatainicio());
            stmt.setDate(2, cardapio.getDatafim());
            stmt.setInt(3, cardapio.getUsuario().getId());
            stmt.setInt(4, cardapio.getId());

            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void find(Cardapio cardapio, String data) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = conexao.prepareStatement("SELECT * FROM `cardapio` WHERE ? BETWEEN datainicio and datafim");
            stmt.setString(1, data);
            result = stmt.executeQuery();

            while (result.next()) {
                Usuario usuario = new Usuario();
                usuario.find(result.getInt("idusuario"));
                cardapio.setId(result.getInt("id"));
                cardapio.setUsuario(usuario);
                cardapio.setDatainicio(result.getDate("datainicio"));
                cardapio.setDatafim(result.getDate("datafim"));
            }

            stmt = conexao.prepareStatement("SELECT `idTurno`, `idCardapio` FROM `turnocardapio` WHERE `idCardapio` = ?");
            stmt.setInt(1, cardapio.getId());
            result = stmt.executeQuery();

            ArrayList<Turno> turnos = new ArrayList<Turno>();

            while (result.next()) {
                Turno turno = new Turno();
                turno.find(result.getInt("idTurno"));
                turnos.add(turno);
            }

            cardapio.setTurnos(turnos);

        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void find(Cardapio cardapio) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = conexao.prepareStatement("SELECT `datainicio`, `datafim`, `idusuario` FROM `cardapio` WHERE `id` = ?");
            stmt.setInt(1, cardapio.getId());
            result = stmt.executeQuery();

            while (result.next()) {
                Usuario usuario = new Usuario();
                usuario.find(result.getInt("idusuario"));
                cardapio.setUsuario(usuario);
                cardapio.setDatainicio(result.getDate("datainicio"));
                cardapio.setDatafim(result.getDate("datafim"));
            }

            stmt = conexao.prepareStatement("SELECT `idTurno`, `idCardapio` FROM `turnocardapio` WHERE `idCardapio` = ?");
            stmt.setInt(1, cardapio.getId());
            result = stmt.executeQuery();

            ArrayList<Turno> turnos = new ArrayList<Turno>();

            while (result.next()) {
                Turno turno = new Turno();
                turno.find(result.getInt("idTurno"));
                turnos.add(turno);
            }

            cardapio.setTurnos(turnos);

        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void delete(Cardapio cardapio) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {

            // deletar todos os turnos da tabela + o registro dos turnos vinculados com os alimentos
            for (Turno turno : cardapio.getTurnos()) {
                if (turno != null) {
                    this.delete(cardapio, turno);
                }
            }

            stmt = conexao.prepareStatement("DELETE FROM `cardapio` WHERE `id` = ?");
            stmt.setInt(1, cardapio.getId());
            stmt.executeUpdate();

        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void delete(Cardapio cardapio, Turno turno) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("DELETE FROM `turnocardapio` WHERE `idCardapio` = ? AND `idTurno` = ?");
            stmt.setInt(1, cardapio.getId());
            stmt.setInt(2, turno.getId());
            stmt.executeUpdate();

            turno.delete();

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
            stmt = conexao.prepareStatement("SELECT AUTO_INCREMENT as id FROM information_schema.tables WHERE table_name = 'cardapio' AND table_schema = 'bancoweb'");
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

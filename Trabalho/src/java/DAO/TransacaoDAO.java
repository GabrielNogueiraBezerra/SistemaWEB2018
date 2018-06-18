/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.TipoTransacao;
import Models.Transacao;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author gabri
 */
public class TransacaoDAO {

    private ConnectionFactory dao = ConnectionFactory.getInstancia();
    private static TransacaoDAO instancia;

    public static TransacaoDAO getInstancia() {
        if (instancia == null) {
            instancia = new TransacaoDAO();
        }

        return instancia;
    }

    public void save(Transacao transacao) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("insert into transacao (tipo, data, valor) values (? , ?, ?, ?)");
            if (transacao.getTipoTransacao() == TipoTransacao.DEBITO) {
                stmt.setInt(1, 0);
            } else {
                stmt.setInt(1, 1);
            }
            Date date = new Date(transacao.getDate().getYear(), transacao.getDate().getMonthValue(), transacao.getDate().getDayOfMonth());
            stmt.setDate(2, date);
            stmt.setFloat(3, transacao.getValor());

            stmt.executeUpdate();

            transacao.setId(this.find());
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }

    }

    public void update(Transacao transacao) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("UPDATE `transacao` SET `tipo` = ?, `data` = ?, `valor` = ? WHERE `id` = ?");
            if (transacao.getTipoTransacao() == TipoTransacao.DEBITO) {
                stmt.setInt(1, 0);
            } else {
                stmt.setInt(1, 1);
            }
            Date date = new Date(transacao.getDate().getYear(), transacao.getDate().getMonthValue(), transacao.getDate().getDayOfMonth());
            stmt.setDate(2, date);
            stmt.setFloat(3, transacao.getValor());
            stmt.setInt(4, transacao.getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void find(Transacao transacao) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = conexao.prepareStatement("SELECT * FROM `transacao` WHERE `id` = ?");
            stmt.setInt(1, transacao.getId());
            result = stmt.executeQuery();

            while (result.next()) {
                //transacao.setDate((LocalDate) result.getDate("data"));
                transacao.setValor(result.getFloat("valor"));
                switch (result.getInt("tipo")) {
                    case 0: {
                        transacao.setTipoTransacao(TipoTransacao.DEBITO);
                        break;
                    }
                    case 1: {
                        transacao.setTipoTransacao(TipoTransacao.CREDITO);
                    }

                }
                transacao.setTipoTransacao(TipoTransacao.DEBITO);
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
            stmt = conexao.prepareStatement("SELECT AUTO_INCREMENT as id FROM information_schema.tables WHERE table_name = 'transacao' AND table_schema = 'bancoweb'");
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

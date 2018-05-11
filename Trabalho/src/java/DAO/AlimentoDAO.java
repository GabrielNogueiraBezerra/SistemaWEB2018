/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Alimento;
import Models.CategoriaAlimento;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Marcelo Moreira
 */
public class AlimentoDAO {

    private ConnectionFactory dao = ConnectionFactory.getInstancia();
    private static AlimentoDAO instancia;

    public static AlimentoDAO getInstancia() {
        if (instancia == null) {
            instancia = new AlimentoDAO();
        }

        return instancia;
    }

    public void save(Alimento alimento) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("INSERT INTO `alimento`(`idCategoria`, `nome`, `fibras`, `carboidratos`, `calorias`) VALUES (?, ?, ?, ?, ?)");
            stmt.setInt(1, alimento.getCategoriaAlimento().getId());
            stmt.setString(2, alimento.getNome());
            stmt.setFloat(3, alimento.getQuantidadeFibras());
            stmt.setFloat(4, alimento.getQuantidadeCarboidratos());
            stmt.setFloat(5, alimento.getQuantidadeCalorias());

            stmt.executeUpdate();

            alimento.setId(this.find());
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void update(Alimento alimento) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("UPDATE `alimento` SET `idCategoria` = ?,`nome` = ?,`fibras` = ?,`carboidratos` = ?,`calorias` = ? WHERE `id` = ?");
            stmt.setInt(1, alimento.getCategoriaAlimento().getId());
            stmt.setString(2, alimento.getNome());
            stmt.setFloat(3, alimento.getQuantidadeFibras());
            stmt.setFloat(4, alimento.getQuantidadeCarboidratos());
            stmt.setFloat(5, alimento.getQuantidadeCalorias());
            stmt.setInt(6, alimento.getId());

            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void delete(Alimento alimento) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("DELETE FROM `alimento` WHERE `id` = ?");
            stmt.setInt(1, alimento.getId());

            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void find(Alimento alimento) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            stmt = conexao.prepareStatement("SELECT `idCategoria`, `nome`, `fibras`, `carboidratos`, `calorias` FROM `alimento` WHERE `id` = ?");
            stmt.setInt(1, alimento.getId());
            result = stmt.executeQuery();

            while (result.next()) {

                // BUSCAR CATEGORIA ALIMENTO
                CategoriaAlimento categoriaAlimento = new CategoriaAlimento(0, "");
                categoriaAlimento.find(result.getInt("idCategoria"));
                alimento.setCategoriaAlimento(categoriaAlimento);

                alimento.setNome(result.getString("nome"));
                alimento.setQuantidadeCalorias(result.getFloat("calorias"));
                alimento.setQuantidadeCarboidratos(result.getFloat("carboidratos"));
                alimento.setQuantidadeFibras(result.getFloat("fibras"));

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
            stmt = conexao.prepareStatement("SELECT AUTO_INCREMENT as id FROM information_schema.tables WHERE table_name = 'alimento' AND table_schema = 'bancoweb'");
            result = stmt.executeQuery();

            while (result.next()) {
                resultado = result.getInt("id");
            }

        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
            return resultado - 1;
        }
    }

    public ArrayList<Alimento> getAlimentos() throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        ArrayList<Alimento> alimentos = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement("SELECT `idCategoria`, `nome`, `fibras`, `carboidratos`, `calorias` FROM `alimento`");
            while (result.next()) {
                Alimento alimento = new Alimento();

                alimento.setId(result.getInt(""));
                alimento.setNome(result.getString(""));
                alimento.setQuantidadeCalorias(result.getFloat(""));
                alimento.setQuantidadeCarboidratos(result.getFloat(""));
                alimento.setQuantidadeFibras(result.getFloat(""));

                CategoriaAlimento categoria = new CategoriaAlimento();
                categoria.find(result.getInt(""));
                alimento.setCategoriaAlimento(categoria);
                alimentos.add(alimento);
            }
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
            return alimentos;
        }
    }
}

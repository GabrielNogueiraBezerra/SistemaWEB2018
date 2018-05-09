package DAO;

import Models.Carteira;
import Models.Historico;
import Models.Perfil;
import Models.Usuario;
import Models.Validacao;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class UsuarioDAO {

    private ConnectionFactory dao = ConnectionFactory.getInstancia();
    private static UsuarioDAO instancia;

    public static UsuarioDAO getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioDAO();
        }

        return instancia;
    }

    public void save(Usuario usuario) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("");
            stmt.setString(1, usuario.getNome());
            stmt.setInt(2, usuario.getIdMatricula());
            stmt.setInt(3, usuario.getCarteira().getId());
            stmt.setInt(4, usuario.getHistorico().getId());
            stmt.setInt(5, usuario.getPerfil().getId());
            stmt.setInt(5, usuario.getValidacao().getId());
            stmt.setBoolean(6, usuario.isAtivo());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void update(Usuario usuario) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("");
            stmt.setString(1, usuario.getNome());
            stmt.setInt(2, usuario.getIdMatricula());
            stmt.setInt(3, usuario.getCarteira().getId());
            stmt.setInt(4, usuario.getHistorico().getId());
            stmt.setInt(5, usuario.getPerfil().getId());
            stmt.setInt(5, usuario.getValidacao().getId());
            stmt.setBoolean(6, usuario.isAtivo());
            stmt.setInt(7, usuario.getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void delete(Usuario usuario) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("");
            stmt.setInt(1, usuario.getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public void find(Usuario usuario) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = conexao.prepareStatement("");
            stmt.setInt(1, usuario.getId());
            stmt.executeQuery();

            usuario.setAtivo(result.getBoolean(""));

            // BUSCAR CARTEIRA USUARIO
            Carteira carteira = new Carteira(0, "");
            carteira.find(result.getInt(""));
            usuario.setCarteira(carteira);

            //BUSCA HISTORICO USUARIO
            Historico historico = new Historico(result.getInt(""));
            usuario.setHistorico(historico);

            usuario.setIdMatricula(result.getInt(""));
            usuario.setNome(result.getString(""));

            //BUSCAR PERFIL USUARIO
            Perfil perfil = new Perfil("", 0);
            perfil.find(result.getInt(""));
            usuario.setPerfil(perfil);

            //BUSCAR VALIDACAO USUARIO
            Validacao validacao = new Validacao("", "");
            validacao.find(result.getInt(""));
            usuario.setValidacao(validacao);
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
}

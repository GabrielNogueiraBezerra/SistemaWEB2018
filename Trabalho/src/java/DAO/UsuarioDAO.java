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
            stmt = conexao.prepareStatement("INSERT INTO `usuario`(`idMatricula`, `idValidacao`, `nome`, `idCarteira`, `idHistorico`, `idPerfil`, `ativo`) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, usuario.getIdMatricula());
            stmt.setInt(2, usuario.getValidacao().getId());
            stmt.setString(3, usuario.getNome());
            stmt.setInt(4, usuario.getCarteira().getId());
            stmt.setInt(5, usuario.getHistorico().getId());
            stmt.setInt(6, usuario.getPerfil().getId());
            stmt.setBoolean(7, usuario.isAtivo());
            stmt.executeUpdate();
            
            usuario.setId(this.find());
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void update(Usuario usuario) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("UPDATE `usuario` SET `idMatricula` = ?,`idValidacao` = ?,`nome` = ?,`idCarteira` = ?,`idHistorico` = ?, `idPerfil` = ?,`ativo` = ? WHERE `id` = ?");
            stmt.setInt(1, usuario.getIdMatricula());
            stmt.setInt(2, usuario.getValidacao().getId());
            stmt.setString(3, usuario.getNome());
            stmt.setInt(4, usuario.getCarteira().getId());
            stmt.setInt(5, usuario.getHistorico().getId());
            stmt.setInt(6, usuario.getPerfil().getId());
            stmt.setBoolean(7, usuario.isAtivo());
            stmt.setInt(8, usuario.getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void delete(Usuario usuario) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("DELETE FROM USUARIO WHERE ID = ?");
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
            stmt = conexao.prepareStatement("SELECT `idMatricula`, `idValidacao`, `nome`, `idCarteira`, `idHistorico`, `idPerfil`, `ativo` FROM `usuario` WHERE `id` = ?");
            stmt.setInt(1, usuario.getId());
            stmt.executeQuery();
            
            usuario.setAtivo(result.getBoolean("ativo"));

            // BUSCAR CARTEIRA USUARIO
            Carteira carteira = new Carteira(0, "");
            carteira.find(result.getInt("idCarteira"));
            usuario.setCarteira(carteira);

            //BUSCA HISTORICO USUARIO
            Historico historico = new Historico(result.getInt("idHistorico"));
            usuario.setHistorico(historico);
            
            usuario.setIdMatricula(result.getInt("idMatricula"));
            usuario.setNome(result.getString("nome"));

            //BUSCAR PERFIL USUARIO
            Perfil perfil = new Perfil("", 0);
            perfil.find(result.getInt("idPerfil"));
            usuario.setPerfil(perfil);

            //BUSCAR VALIDACAO USUARIO
            Validacao validacao = new Validacao("", "");
            validacao.find(result.getInt("idValidacao"));
            usuario.setValidacao(validacao);
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
            stmt = conexao.prepareStatement("SELECT AUTO_INCREMENT as id FROM information_schema.tables WHERE table_name = 'usuario' AND table_schema = 'bancoweb'");
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

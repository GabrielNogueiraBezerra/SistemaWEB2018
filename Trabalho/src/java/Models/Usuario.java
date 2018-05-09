package Models;

import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class Usuario implements InterfaceManipulable {

    private int id;
    private int idMatricula;
    private String nome;
    private Validacao validacao;
    private Carteira carteira;
    private Historico historico;
    private Perfil perfil;
    private boolean ativo;

    public Usuario(int idMatricula, String nome, Validacao validacao, Carteira carteira, Historico historico, Perfil perfil, boolean ativo) {
        this.idMatricula = idMatricula;
        this.nome = nome;
        this.validacao = validacao;
        this.carteira = carteira;
        this.historico = historico;
        this.perfil = perfil;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (this.id > 0) {
            this.id = id;
        }
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        if (idMatricula > 0) {
            this.idMatricula = idMatricula;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null) {
            this.nome = nome;
        }
    }

    public Validacao getValidacao() {
        return validacao;
    }

    public void setValidacao(Validacao validacao) {
        if (validacao != null) {
            this.validacao = validacao;
        }
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        if (carteira != null) {
            this.carteira = carteira;
        }
    }

    public Historico getHistorico() {
        return historico;
    }

    public void setHistorico(Historico historico) {
        if (historico != null) {
            this.historico = historico;
        }
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        if (perfil != null) {
            this.perfil = perfil;
        }
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public void save() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void find(int codigo) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

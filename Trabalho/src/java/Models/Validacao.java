package Models;

import DAO.ValidacaoDAO;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class Validacao implements InterfaceManipulable {

    private int id;
    private String login;
    private String senha;

    public Validacao(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login != null) {
            this.login = login;
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha != null) {
            this.senha = senha;
        }
    }

    public boolean validarAcesso() {
        if (this.login != null && this.senha != null) {

        }

        return false;
    }

    @Override
    public void save() throws SQLException, ClassNotFoundException {
        if (this.login != null && this.senha != null) {
            if (this.id == 0) {
                ValidacaoDAO.getInstancia().save(this);
            } else {
                this.update();
            }
        }
    }

    @Override
    public void update() throws SQLException, ClassNotFoundException {
        if (this.id > 0) {
            ValidacaoDAO.getInstancia().update(this);
        }
    }

    @Override
    public void find(int codigo) throws SQLException, ClassNotFoundException {
        if (codigo > 0) {
            ValidacaoDAO.getInstancia().find(this);
        }
    }

    @Override
    public void delete() throws SQLException, ClassNotFoundException {
        if (this.id > 0) {
            ValidacaoDAO.getInstancia().delete(this);
        }
    }

}

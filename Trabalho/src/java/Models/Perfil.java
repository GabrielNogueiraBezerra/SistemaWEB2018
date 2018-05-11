package Models;

import DAO.PerfilDAO;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class Perfil implements InterfaceManipulable {

    private int id;
    private String descricao;
    private float valor;

    public Perfil(){
        
    }
    
    public Perfil(String descricao, float valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao != null) {
            this.descricao = descricao;
        }
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        if (valor >= 0.0) {
            this.valor = valor;
        }
    }

    @Override
    public void save() throws SQLException, ClassNotFoundException {
        if (this.descricao != null && this.valor >= 0.0) {
            if (this.id == 0) {
                PerfilDAO.getInstancia().save(this);
            } else {
                this.update();
            }
        }

    }

    @Override
    public void update() throws SQLException, ClassNotFoundException {
        if (this.id > 0) {
            PerfilDAO.getInstancia().update(this);
        }

    }

    @Override
    public void find(int codigo) throws SQLException, ClassNotFoundException {
        if (codigo > 0) {
            this.id = codigo;
            PerfilDAO.getInstancia().find(this);
        }
    }

    @Override
    public void delete() throws SQLException, ClassNotFoundException {
        if (this.id > 0) {
            PerfilDAO.getInstancia().delete(this);
        }
    }
    
    public float calculaValor(int quantidade){
        return quantidade * this.valor;    
    }

}

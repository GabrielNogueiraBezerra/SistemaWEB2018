package Models;

import DAO.CarteiraDAO;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class Carteira implements InterfaceManipulable {

    private int id;
    private float valorSaldo;
    private String validade;

    public Carteira(){
        
    }
    
    public Carteira(float valorSaldo, String validade) {
        this.setValidade(validade);
        this.setValorSaldo(valorSaldo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public float getValorSaldo() {
        return valorSaldo;
    }

    public void setValorSaldo(float valorSaldo) {
        if (valorSaldo >= 0.0) {
            this.valorSaldo = valorSaldo;
        }
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        if (validade != null) {
            this.validade = validade;
        }
    }

    @Override
    public void save() throws SQLException, ClassNotFoundException {
        if (this.validade != null && this.valorSaldo >= 0.0) {
            if (this.id == 0) {
                CarteiraDAO.getInstancia().save(this);
            } else {
                this.update();
            }
        }
    }

    @Override
    public void update() throws SQLException, ClassNotFoundException {
        if (this.id > 0) {
            CarteiraDAO.getInstancia().update(this);
        }
    }

    @Override
    public void find(int codigo) throws SQLException, ClassNotFoundException {
        if(codigo > 0){
            this.id = codigo;
            
            CarteiraDAO.getInstancia().find(this);
        }
    }

    @Override
    public void delete() throws SQLException, ClassNotFoundException {
        if(this.id > 0){
            CarteiraDAO.getInstancia().delete(this);
        }
    }

}

package Models;

import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class Carteira implements InterfaceManipulable {

    private int id;
    private float valorSaldo;
    private String validade;

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

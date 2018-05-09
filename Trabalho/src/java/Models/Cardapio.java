package Models;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Cardapio implements InterfaceManipulable {

    private int id;
    private Usuario usuario;
    private Date datainicio;
    private Date datafim;
    private ArrayList<Dia> dias;

    public Cardapio(Usuario usuario, Date datainicio, Date datafim) {
        this.setDatafim(datafim);
        this.setDatainicio(datainicio);
        this.setUsuario(usuario);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        if (usuario != null) {
            this.usuario = usuario;
        }
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        if (datainicio != null) {
            this.datainicio = datainicio;
        }
    }

    public Date getDatafim() {
        return datafim;
    }

    public void setDatafim(Date datafim) {
        if (datafim != null) {
            this.datafim = datafim;
        }
    }

    public ArrayList<Dia> getDias() {
        return dias;
    }

    public void setDias(ArrayList<Dia> dias) {
        if (dias != null) {
            this.dias = dias;
        }
    }

    public void addDia(Dia dia) {
        if (dia != null) {
            this.dias.add(dia);
        }
    }

    public void removeDia(Dia dia) {
        if (dia != null) {
            this.dias.remove(dia);
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

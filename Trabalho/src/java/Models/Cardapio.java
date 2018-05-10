package Models;

import DAO.CardapioDAO;
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

    private Cardapio(){
        dias = new ArrayList<>();
    }
    
    public Cardapio(Usuario usuario, Date datainicio, Date datafim) {
        this();
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
        if(usuario != null && datainicio != null && datafim != null && dias != null){
            if(this.id == 0){
                CardapioDAO.getInstancia().save(this);
            }else{
                this.update();
            }
        }
    }

    @Override
    public void update() throws SQLException, ClassNotFoundException {
        if(this.id > 0){
            CardapioDAO.getInstancia().update(this);
        }
    }

    @Override
    public void find(int codigo) throws SQLException, ClassNotFoundException {
        if(this.id > 0){
            CardapioDAO.getInstancia().find(this);
        }
    }

    @Override
    public void delete() throws SQLException, ClassNotFoundException {
        if(this.id > 0){
            CardapioDAO.getInstancia().delete(this);
        }
    }

}

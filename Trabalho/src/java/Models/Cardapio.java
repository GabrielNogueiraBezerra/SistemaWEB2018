package Models;

import interfaces.InterfaceManipulable;
import DAO.CardapioDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
    private ArrayList<Turno> turnos;

    public Cardapio() {
        turnos = new ArrayList<>();
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

    public Turno retornaTurno(String data) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        if (data != null) {
            for (Turno turno : this.getTurnos()) {
                if (df.format(turno.getDate()).equals(data)) {
                    return turno;
                }
            }
        }

        return null;
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

    public ArrayList<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(ArrayList<Turno> turnos) {
        if (turnos != null) {
            this.turnos = turnos;
        }
    }

    public void addTurno(Turno turno) throws SQLException, ClassNotFoundException {
        if (turno != null && turno.getId() > 0) {
            CardapioDAO.getInstancia().save(this, turno);
            this.turnos.add(turno);
        }
    }

    public void removeTurno(Turno turno) throws SQLException, ClassNotFoundException {
        if (turno != null && turno.getId() > 0) {
            CardapioDAO.getInstancia().delete(this, turno);
            this.turnos.remove(turno);
        }
    }

    @Override
    public void save() throws SQLException, ClassNotFoundException {
        if (usuario != null && datainicio != null && datafim != null && turnos != null) {
            if (this.id == 0) {
                CardapioDAO.getInstancia().save(this);
            } else {
                this.update();
            }
        }
    }

    @Override
    public void update() throws SQLException, ClassNotFoundException {
        if (this.id > 0) {
            CardapioDAO.getInstancia().update(this);
        }
    }

    @Override
    public void find(int codigo) throws SQLException, ClassNotFoundException {
        if (codigo > 0) {
            this.id = codigo;

            CardapioDAO.getInstancia().find(this);
        }
    }

    public void find(String data) throws SQLException, ClassNotFoundException {
        if (data != null) {
            CardapioDAO.getInstancia().find(this, data);
        }
    }

    @Override
    public void delete() throws SQLException, ClassNotFoundException {
        if (this.id > 0) {
            CardapioDAO.getInstancia().delete(this);
        }
    }

}

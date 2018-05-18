package Models;

import interfaces.InterfaceManipulable;
import DAO.DiaDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Dia implements InterfaceManipulable {
    private int id;
    private Date data;
    private ArrayList<Turno> turnos;

    private Dia(){
        turnos = new ArrayList<>();
    }
    
    public Dia(Date data) {
        this();
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id >= 0){
            this.id = id;
        }
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        if (data != null) {
            this.data = data;
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

    public void addTurno(Turno turno) {
        if (turno != null) {
            this.turnos.add(turno);
        }
    }

    public void removeTurno(Turno turno) {
        if (turno != null) {
            this.turnos.remove(turno);
        }
    }

    @Override
    public void save() throws SQLException, ClassNotFoundException {
        if(data != null && turnos != null){
            if(this.id == 0){
                DiaDAO.getInstancia().save(this);
            }else{
                this.update();
            }
        }
    }

    @Override
    public void update() throws SQLException, ClassNotFoundException {
        if(this.id > 0){
            DiaDAO.getInstancia().update(this);
        }
    }

    @Override
    public void find(int codigo) throws SQLException, ClassNotFoundException {
        if(this.id > 0){
            DiaDAO.getInstancia().find(this);
        }
    }

    @Override
    public void delete() throws SQLException, ClassNotFoundException {
        if(this.id > 0){
            DiaDAO.getInstancia().delete(this);
        }
    }

}

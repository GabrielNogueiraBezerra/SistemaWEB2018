package Models;

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

    public Dia(Date data) {
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
        
    }

    @Override
    public void update() throws SQLException, ClassNotFoundException {
        
    }

    @Override
    public void find(int codigo) throws SQLException, ClassNotFoundException {
        
    }

    @Override
    public void delete() throws SQLException, ClassNotFoundException {
        
    }

}

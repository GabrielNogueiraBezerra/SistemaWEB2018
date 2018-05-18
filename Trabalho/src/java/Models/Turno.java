package Models;

import interfaces.InterfaceManipulable;
import DAO.TurnoDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Turno implements InterfaceManipulable {

    private int id;
    private String nomeTurno;
    private ArrayList<Alimento> alimentos;
    private Date date;

    public Turno() {
        alimentos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public String getNomeTurno() {
        return nomeTurno;
    }

    public ArrayList<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(ArrayList<Alimento> alimentos) {
        if (alimentos != null) {
            this.alimentos = alimentos;

        }
    }

    public Alimento getAlimento(Alimento alimento) {
        for (Alimento a : alimentos) {
            if (alimento.getId() == a.getId()) {
                return a;
            }
        }
        return null;
    }

    public void setNomeTurno(String nomeTurno) {
        if (nomeTurno != null) {
            this.nomeTurno = nomeTurno;
        }
    }

    public void addAlimento(Alimento alimento) throws SQLException, ClassNotFoundException {
        if (alimento != null && alimento.getId() > 0) {
            TurnoDAO.getInstancia().save(this, alimento);
            alimentos.add(alimento);
        }
    }

    public void removeAlimento(Alimento alimento) throws SQLException, ClassNotFoundException {
        if (alimento != null && alimento.getId() > 0) {
            TurnoDAO.getInstancia().delete(this, alimento);
            alimentos.remove(alimento);
        }
    }

    @Override
    public void save() throws SQLException, ClassNotFoundException {
        if (nomeTurno != null && alimentos != null) {
            if (this.id == 0) {
                TurnoDAO.getInstancia().save(this);
            } else {
                this.update();
            }
        }
    }

    @Override
    public void update() throws SQLException, ClassNotFoundException {
        if (id > 0) {
            TurnoDAO.getInstancia().update(this);
        }
    }

    @Override
    public void find(int codigo) throws SQLException, ClassNotFoundException {
        if (codigo > 0) {
            this.id = codigo;
            
            TurnoDAO.getInstancia().find(this);
        }
    }

    @Override
    public void delete() throws SQLException, ClassNotFoundException {
        if (id > 0) {
            TurnoDAO.getInstancia().delete(this);
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        if (date != null) {
            this.date = date;
        }
    }

}

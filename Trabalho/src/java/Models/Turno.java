package Models;

import DAO.TurnoDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Turno implements InterfaceManipulable{
    private int id;
    private String nomeTurno;
    private ArrayList<Alimento> alimentos;

    public Turno(){
        alimentos = new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id > 0){
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
        this.alimentos = alimentos;
    }

    public void setNomeTurno(String nomeTurno) {
        if(nomeTurno != null){
            this.nomeTurno = nomeTurno;
        }
    }
    
    public void addAlimento(Alimento alimento){
        if(alimento != null && alimento.getId() >= 0){
            alimentos.add(alimento);
        }
    }
    
    public Alimento getAlimento(Alimento alimento){
        for(Alimento a:alimentos){
            if(alimento.getId() == a.getId()){
                return a;
            }
        }
        return null;
    }
    
    @Override
    public void save() throws SQLException, ClassNotFoundException {
        if(nomeTurno != null && alimentos != null){
            if(this.id == 0){
                TurnoDAO.getInstancia().save(this);
            }else{
                this.update();
            }
        }
    }

    @Override
    public void update() throws SQLException, ClassNotFoundException {
        if(id > 0){
            TurnoDAO.getInstancia().update(this);
        }
    }

    @Override
    public void find(int codigo) throws SQLException, ClassNotFoundException {
        if(id > 0){
            TurnoDAO.getInstancia().find(this);
        }
    }

    @Override
    public void delete() throws SQLException, ClassNotFoundException {
        if(id > 0){
            TurnoDAO.getInstancia().delete(this);
        }
    }
    
    
}

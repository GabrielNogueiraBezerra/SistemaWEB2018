package Models;

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

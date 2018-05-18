package Models;

import interfaces.InterfaceManipulable;
import DAO.CategoriaAlimentoDAO;
import java.sql.SQLException;

/**
 *
 * @author Marcelo Moreira
 */
public class CategoriaAlimento implements InterfaceManipulable{
    private int id;
    private String nomeCategoria;
    
    public CategoriaAlimento(){
        
    }
    
    public CategoriaAlimento(int id, String nomeCategoria){
        this.id = id;
        this.nomeCategoria = nomeCategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id >= 0){
            this.id = id;
        }
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        if(nomeCategoria != null){
            this.nomeCategoria = nomeCategoria;
        }
    }
    
    
    
    @Override
    public void save() throws SQLException, ClassNotFoundException {
        if(id >= 0 && nomeCategoria != null){
            if(id == 0){
                CategoriaAlimentoDAO.getInstancia().save(this);
            }else{
                this.update();
            }
        }
    }

    @Override
    public void update() throws SQLException, ClassNotFoundException {
        if(id > 0){
            CategoriaAlimentoDAO.getInstancia().update(this);
        }
    }

    @Override
    public void find(int codigo) throws SQLException, ClassNotFoundException {
        if(codigo > 0){
            this.id = codigo;
            CategoriaAlimentoDAO.getInstancia().find(this);
        }
    }

    @Override
    public void delete() throws SQLException, ClassNotFoundException {
        if(id > 0){
            CategoriaAlimentoDAO.getInstancia().delete(this);
        }
    }
    
}

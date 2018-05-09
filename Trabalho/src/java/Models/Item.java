package Models;

import DAO.ItemDAO;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class Item implements InterfaceManipulable{

    private int id;
    private int idHistorico;
    private Date data;
    private String periodo;

    public Item(int idHistorico, Date data, String periodo) {
        this.idHistorico = idHistorico;
        this.data = data;
        this.periodo = periodo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        if (idHistorico > 0) {
            this.idHistorico = idHistorico;
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

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        if (periodo != null) {
            this.periodo = periodo;
        }
    }

    @Override
    public void save() throws SQLException, ClassNotFoundException {
        if(this.data != null && this.idHistorico > 0 && this.periodo != null){
            if(this.id == 0){
                ItemDAO.getInstancia().save(this);
            }else{
                this.update();
            }
        }
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

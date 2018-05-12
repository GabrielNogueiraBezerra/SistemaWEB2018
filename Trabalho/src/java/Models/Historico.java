package Models;

import DAO.ItemDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Historico {

    private int id;
    private ArrayList<Item> itens = new ArrayList<Item>();

    public Historico(int id) throws SQLException, ClassNotFoundException {
        this.setId(id);
        this.retornaItens();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        if (itens != null) {
            this.itens = itens;
        }
    }

    public void addItem(Item item) {
        if (item != null) {
            this.itens.add(item);
        }
    }

    public void removeItem(Item item) {
        if (item != null) {
            this.itens.remove(item);
        }
    }

    private void retornaItens() throws SQLException, ClassNotFoundException {
        if (this.id > 0) {
            ItemDAO.getInstancia().find(this);
        }
    }

}

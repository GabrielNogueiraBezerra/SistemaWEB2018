package Models;

import interfaces.InterfaceManipulable;
import DAO.AlimentoDAO;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class Alimento implements InterfaceManipulable {

    private int id;
    private String nome;
    private CategoriaAlimento categoriaAlimento;
    private float quantidadeFibras;
    private float quantidadeCalorias;
    private float quantidadeCarboidratos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null) {
            this.nome = nome;
        }
    }

    public CategoriaAlimento getCategoriaAlimento() {
        return categoriaAlimento;
    }

    public void setCategoriaAlimento(CategoriaAlimento categoriaAlimento) {
        if (categoriaAlimento != null) {
            this.categoriaAlimento = categoriaAlimento;
        }
    }

    public float getQuantidadeFibras() {
        return quantidadeFibras;
    }

    public void setQuantidadeFibras(float quantidadeFibras) {
        if (quantidadeFibras >= 0) {
            this.quantidadeFibras = quantidadeFibras;
        }
    }

    public float getQuantidadeCalorias() {
        return quantidadeCalorias;
    }

    public void setQuantidadeCalorias(float quantidadeCalorias) {
        if (quantidadeCalorias >= 0) {
            this.quantidadeCalorias = quantidadeCalorias;
        }
    }

    public float getQuantidadeCarboidratos() {
        return quantidadeCarboidratos;
    }

    public void setQuantidadeCarboidratos(float quantidadeCarboidratos) {
        if (quantidadeCarboidratos >= 0) {
            this.quantidadeCarboidratos = quantidadeCarboidratos;
        }
    }

    @Override
    public void save() throws SQLException, ClassNotFoundException {
        if (this.categoriaAlimento != null && this.nome != null && this.quantidadeCalorias >= 0.0 && this.quantidadeCarboidratos >= 0.0 && this.quantidadeFibras >= 0.0) {
            if (this.id == 0) {
                AlimentoDAO.getInstancia().save(this);
            } else {
                this.update();
            }
        }
    }

    @Override
    public void update() throws SQLException, ClassNotFoundException {
        if (this.id > 0) {
            AlimentoDAO.getInstancia().update(this);
        }
    }

    @Override
    public void find(int codigo) throws SQLException, ClassNotFoundException {
        if (codigo > 0) {
            this.id = codigo;

            AlimentoDAO.getInstancia().find(this);
        }
    }

    @Override
    public void delete() throws SQLException, ClassNotFoundException {
        if (this.id > 0) {
            AlimentoDAO.getInstancia().delete(this);
        }
    }

}

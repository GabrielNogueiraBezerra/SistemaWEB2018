package Teste;

import Models.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class Teste {

    public static void main(String[] args) {
        try {
            //CategoriaAlimento categoria = new CategoriaAlimento();
            //categoria.setNomeCategoria("Categoria A");
            //categoria.save();
            //System.out.println(categoria.getId());

            //CategoriaAlimento cate1 = new CategoriaAlimento();
            //cate1.setNomeCategoria("Categoria B");
            //cate1.save();
            CategoriaAlimento categoria = new CategoriaAlimento();
            categoria.find(5);

            //Alimento alimento = new Alimento();
            //alimento.setCategoriaAlimento(categoria);
            //alimento.setNome("Cuscuz");
            //alimento.setQuantidadeCalorias(100);
            //alimento.setQuantidadeCarboidratos(100);
            //alimento.setQuantidadeFibras(100);
            //alimento.save();

            //System.out.println(alimento.getId());
            
            //Alimento alimento = new Alimento();
            //alimento.find(2);
            //alimento.delete();
        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

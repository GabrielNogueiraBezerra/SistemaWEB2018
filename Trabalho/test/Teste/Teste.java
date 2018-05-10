package Teste;

import Models.CategoriaAlimento;
import Models.Perfil;
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
            Perfil perfil = new Perfil("", 0);
            perfil.find(2);
            perfil.delete();
        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

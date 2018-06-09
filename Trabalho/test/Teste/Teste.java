package Teste;

import DAO.TurnoDAO;
import Models.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class Teste {

    public static void main(String[] args) {
        try {
            Turno t = new Turno();
            t.find(5);
            
            Perfil p = new Perfil();
            p.find(4);
            
            
            Carteira c = new Carteira();
            c.find(16);
            
            Historico h = new Historico(2);
            
            Usuario u = new Usuario();
            u.find(12);  
            
            Cardapio card = new Cardapio();
            card.find(5);

        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

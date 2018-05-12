package Teste;

import Models.*;
import java.sql.Date;
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
            
            Usuario usuario = new Usuario();
            usuario.setAtivo(true);
            
            Carteira carteira = new Carteira(100, "A");
            carteira.save();
            usuario.setCarteira(carteira);
            
            Item item = new Item(1, new Date(1000), "Tarde");
            item.save();
            
            Historico historico = new Historico(1);
            historico.addItem(item);
            
            usuario.setHistorico(historico);
            
            usuario.setIdMatricula(390233);
            
            usuario.setNome("Gabriel Nogueira Bezerra");
            
            Perfil perfil = new Perfil();
            perfil.find(1);
            
            usuario.setPerfil(perfil);
            
            Validacao validacao = new Validacao("390233", "390233");
            validacao.save();
            
            usuario.setValidacao(validacao);
            
            usuario.save();
            
            
            Turno turno = new Turno();
            turno.find(3);
            
            Cardapio cardapio = new Cardapio(usuario, new Date(1000), new Date(1000));
            
            cardapio.save();
            
            cardapio.addTurno(turno);
            
            cardapio.update();
            
            cardapio.delete();
            
        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

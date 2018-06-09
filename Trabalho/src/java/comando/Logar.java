/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comando;


import DAO.UsuarioDAO;
import Models.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcelo
 */
public class Logar implements interfaces.Comando{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
       
        
        try {
            Usuario usuario = UsuarioDAO.getInstancia().logar(login, senha);
            
            if(usuario != null){
                request.getSession().setAttribute("usuarioLogadoSessao", usuario);
                
                RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Logar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Logar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(Logar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Logar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

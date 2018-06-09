/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comando;

import java.io.IOException;
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
public class Sair implements interfaces.Comando{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("usuarioLogadoSessao");
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(Sair.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sair.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

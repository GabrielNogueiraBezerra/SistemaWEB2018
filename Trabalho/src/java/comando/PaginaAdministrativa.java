/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comando;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
public class PaginaAdministrativa implements interfaces.Comando {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            if (request.getSession().getAttribute("usuarioLogadoSessao") != null) {
                RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

}

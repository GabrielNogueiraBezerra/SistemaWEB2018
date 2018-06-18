/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comando;

import Models.CategoriaAlimento;
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
 * @author aluno
 */
public class AlterarCategoria implements interfaces.Comando {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            if (request.getSession().getAttribute("usuarioLogadoSessao") != null) {

                String id = request.getParameter("id");
                if (id != null) {
                    RequestDispatcher rd = request.getRequestDispatcher("AlterarCategoria.jsp");
                    rd.forward(request, response);
                }

                RequestDispatcher rd = request.getRequestDispatcher("CadastrarCategoria.jsp");
                rd.forward(request, response);
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

}

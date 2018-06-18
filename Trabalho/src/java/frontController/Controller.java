/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontController;

import comando.Index;
import comando.NotFounded;
import interfaces.Comando;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException, ServletException {

        Comando comando = new NotFounded();

        try {

            if (request.getParameter("comando") != null) {
                comando = (Comando) Class.forName("comando." + request.getParameter("comando")).newInstance();
            } else {
                if (request.getSession().getAttribute("user") == null) {
                    comando = new Index();
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("notFound.jsp");
                    rd.forward(request, response);
                }
            }

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            ex.printStackTrace();
        } finally {
            comando.execute(request, response);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}

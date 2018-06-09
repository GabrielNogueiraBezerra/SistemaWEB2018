/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontController;

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
            if(request.getSession().getAttribute("user") == null){
                
                //Comandos do if abaixo são executados sem precisar estar logado
                if(request.getParameter("comando").equals("Logar")){
                    comando = (Comando) Class.forName("comando." + request.getParameter("comando")).newInstance();
                }else{
                    //Se n for nenhum comando permitido fazer sem estar logado
                    //Redireciona para alguma pagina
                }
            }else{
                comando = (Comando) Class.forName("comando." + request.getParameter("comando")).newInstance();
            }
            
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
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

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
public class AdicionarCategorias implements interfaces.Comando {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            if (request.getSession().getAttribute("usuarioLogadoSessao") != null) {

                String nome = request.getParameter("nome");
                String id = request.getParameter("id").trim();
                if ((nome != null && !(nome.equals("")))) {
                    if (id != null) {
                        if (id.equals("")) {
                            CategoriaAlimento categoria = new CategoriaAlimento();
                            categoria.setNomeCategoria(nome);
                            categoria.save();
                        } else {
                            CategoriaAlimento categoria = new CategoriaAlimento();
                            categoria.find(Integer.parseInt(id));
                            categoria.setNomeCategoria(nome);
                            categoria.update();
                        }
                    }
                }

                RequestDispatcher rd = request.getRequestDispatcher("CadastrarCategoria.jsp");
                rd.forward(request, response);
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(AdicionarCategorias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdicionarCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

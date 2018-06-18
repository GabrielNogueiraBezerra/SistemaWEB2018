/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comando;

import Models.Alimento;
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
public class AdicionarAlimentos implements interfaces.Comando {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            if (request.getSession().getAttribute("usuarioLogadoSessao") != null) {

                String id = request.getParameter("id").trim();
                String nome = request.getParameter("nome");
                String fibras = request.getParameter("fibras");
                String carboidratos = request.getParameter("carboidratos");
                String calorias = request.getParameter("calorias");
                String categoria = request.getParameter("categoria").trim();

                if (nome == null || nome.equals("")) {
                    RequestDispatcher rd = request.getRequestDispatcher("CadastrarAlimentos.jsp");
                    rd.forward(request, response);
                    return;
                }

                if (fibras == null || fibras.equals("")) {
                    RequestDispatcher rd = request.getRequestDispatcher("CadastrarAlimentos.jsp");
                    rd.forward(request, response);
                    return;
                }

                if (carboidratos == null || carboidratos.equals("")) {
                    RequestDispatcher rd = request.getRequestDispatcher("CadastrarAlimentos.jsp");
                    rd.forward(request, response);
                    return;
                }

                if (calorias == null || calorias.equals("")) {
                    RequestDispatcher rd = request.getRequestDispatcher("CadastrarAlimentos.jsp");
                    rd.forward(request, response);
                    return;
                }

                if (categoria == null || categoria.equals("")) {
                    RequestDispatcher rd = request.getRequestDispatcher("CadastrarAlimentos.jsp");
                    rd.forward(request, response);
                    return;
                }
                if (id == null) {
                    CategoriaAlimento categoriaAlimento = new CategoriaAlimento();
                    categoriaAlimento.find(Integer.parseInt(categoria));
                    Alimento alimento = new Alimento();
                    alimento.setCategoriaAlimento(categoriaAlimento);
                    alimento.setNome(nome);
                    alimento.setQuantidadeCalorias(Float.parseFloat(calorias));
                    alimento.setQuantidadeCarboidratos(Float.parseFloat(carboidratos));
                    alimento.setQuantidadeFibras(Float.parseFloat(fibras));
                    alimento.save();
                } else {
                    if (!id.equals("")) {
                        Alimento alimento = new Alimento();
                        alimento.find(Integer.parseInt(id));
                        CategoriaAlimento categoriaAlimento = new CategoriaAlimento();
                        categoriaAlimento.find(Integer.parseInt(categoria));

                        alimento.setCategoriaAlimento(categoriaAlimento);
                        alimento.setNome(nome);
                        alimento.setQuantidadeCalorias(Float.parseFloat(calorias));
                        alimento.setQuantidadeCarboidratos(Float.parseFloat(carboidratos));
                        alimento.setQuantidadeFibras(Float.parseFloat(fibras));
                        alimento.save();
                    }
                }

                RequestDispatcher rd = request.getRequestDispatcher("CadastrarAlimentos.jsp");
                rd.forward(request, response);
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(AdicionarAlimentos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdicionarAlimentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

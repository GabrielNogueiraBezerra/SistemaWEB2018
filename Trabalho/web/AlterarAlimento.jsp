<%-- 
    Document   : CadastrarCategoria
    Created on : 10/06/2018, 10:56:19
    Author     : gabri
--%>

<%@page import="Models.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.CategoriaAlimentoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Categorias</title>
    </head>
    <body>
        <a href="/Trabalho?comando=index">Pagina Administrativa</a>

        <%
            Alimento alimento = new Alimento();
            alimento.find(Integer.parseInt(request.getParameter("id")));
        %>
        <h1>Alterar Alimento</h1>

        <form method="post" action="/Trabalho/Controller?comando=AdicionarAlimentos">
            <input value="<%out.println(alimento.getId());%>" type="hidden" name="id" id="id" ><br/><br/>
            <input value="<%out.println(alimento.getNome());%>" type="text" name="nome" id="nome" placeholder="nome"><br/><br/>
            <input value="<%out.println(alimento.getQuantidadeFibras());%>" type="text" name="fibras" id="fibras" placeholder="fibras"><br/><br/>
            <input value="<%out.println(alimento.getQuantidadeCarboidratos());%>" type="text" name="carboidratos" id="carboidratos" placeholder="carboidratos"><br/><br/>
            <input value="<%out.println(alimento.getQuantidadeCalorias());%>" type="text" name="calorias" id="calorias" placeholder="calorias"><br/><br/>
            <select id="categoria" name="categoria">
                <%
                    ArrayList<CategoriaAlimento> categorias = CategoriaAlimentoDAO.getInstancia().buscarTodos();
                    for (CategoriaAlimento categoriaAlimento : categorias) {
                        if (alimento.getCategoriaAlimento().getId() == categoriaAlimento.getId()) {
                            out.println("<option selected value='" + String.valueOf(categoriaAlimento.getId()) + "'>"
                                    + categoriaAlimento.getNomeCategoria()
                                    + "</option>");
                        } else {
                            out.println("<option value='" + String.valueOf(categoriaAlimento.getId()) + "'>"
                                    + categoriaAlimento.getNomeCategoria()
                                    + "</option>");
                        }
                    }
                %>
            </select><br/><br/>
            <input type="submit" value="Cadastrar">
        </form>
        <br>
    </body>
</html>

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
            CategoriaAlimento categoria = new CategoriaAlimento();
            categoria.find(Integer.parseInt(request.getParameter("id")));
        %>
        <h1>Alterar Categoria</h1>

        <form method="post" action="/Trabalho?comando=AdicionarCategorias">
            <input value="<%out.println(categoria.getId());%>" type="hidden" name="id" id="id">
            <input value="<%out.println(categoria.getNomeCategoria());%>" type="text" name="nome" id="nome" placeholder="nome"><br><br>
            <input type="submit" value="Alterar">
        </form>
        <br>
    </body>
</html>

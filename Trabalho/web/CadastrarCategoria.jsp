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
        <%
            if (session.getAttribute("usuarioLogadoSessao") != null) {
                Usuario usuarioLogadoSessao = (Usuario) session.getAttribute("usuarioLogadoSessao");
        %>
        <h3>
            <a href="/Trabalho?comando=PaginaAdministrativa">
                Pagina Administrativa
            </a>
        </h3>
        <h3>
            Usuario: <%=usuarioLogadoSessao.getNome()%>
        </h3>



        <a href="/Trabalho?comando=Sair">
            Sair
        </a>

        <%
            }
        %>
        <hr>
        <h1>Cadastrar Categorias</h1>

        <form method="post" action="/Trabalho?comando=AdicionarCategorias">
            <input type="hidden" name="id" id="id">
            <input type="text" name="nome" id="nome" placeholder="nome"><br><br>
            <input type="submit" value="Cadastrar">
        </form>
        <br>
        <hr>
        <%
            ArrayList<CategoriaAlimento> categorias = CategoriaAlimentoDAO.getInstancia().buscarTodos();

            for (CategoriaAlimento categoria : categorias) {
                out.println(categoria.getNomeCategoria() + " <a href='/Trabalho?comando=AlterarCategoria&id=" + categoria.getId() + "'>Alterar</a> | <a href='/Trabalho?comando=ExcluirCategoria&id=" + categoria.getId() + "'>Excluir</a> <br>");
            }


        %>
    </body>
</html>

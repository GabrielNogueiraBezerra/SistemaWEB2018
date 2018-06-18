<%-- 
    Document   : menu
    Created on : 09/06/2018, 12:02:00
    Author     : Marcelo
--%>

<%@page import="Models.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Usuario usuarioLogadoSessao = (Usuario) session.getAttribute("usuarioLogadoSessao");
        %>
        <h3><a href="/Trabalho?comando=Index">
                Pagina Inicial
            </a></h3>
        <h3>
            Usuario: <%=usuarioLogadoSessao.getNome()%>
        </h3>
        <a href="/Trabalho?comando=Sair">
            Sair
        </a>
        <hr/>

        <h1>Menu</h1>
        <%
            Usuario usuario = (Usuario) session.getAttribute("usuarioLogadoSessao");
            if (usuario != null) {
                if (usuario.getPerfil().getDescricao().equals("ADMINISTRADOR")) {

        %>
        <a href="/Trabalho/Pagina?comando=CadastrarCategoria"> Categorias </a><br>
        <a href="/Trabalho/Pagina?comando=CadastrarAlimentos"> Alimentos </a><br>
        <a href="#"> Cardapio </a><br>
        <%                }
            }
        %>
    </body>
</html>

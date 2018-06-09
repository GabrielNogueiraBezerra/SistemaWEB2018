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
        <h1>Menu</h1>
        <h3>
            Usuario: <%=usuarioLogadoSessao.getNome() %>
        </h3>
        <form method="post" action="/Trabalho/Pagina?comando=Sair">
            <input type="submit" value="Sair">
        </form>
        <hr/>
    </body>
</html>

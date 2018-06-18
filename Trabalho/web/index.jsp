<%-- 
    Document   : index
    Created on : 18/05/2018, 18:41:14
    Author     : Marcelo
--%>

<%@page import="Models.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        if (application.getAttribute("DATAHOJE") == null) {
            Date hoje = new Date();
            SimpleDateFormat df;
            df = new SimpleDateFormat("yyyy-MM-dd");
            application.setAttribute("DATAHOJE", df.format(hoje));
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
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
        } else {
        %>
        <h1>
            Autenticação
        </h1>
        <form method="post" action="/Trabalho/Pagina?comando=Logar">
            <label>
                Login: <input type="text" name="login">
            </label><br/><br/>
            <label>
                Senha: <input type="password" name="senha">
            </label><br/><br/>
            <input type="submit" value="Entrar">
        </form>
        <%
            }
        %>
        <hr/>
        <h1 style="">Cardápio</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>
                        Segunda
                    </th>
                    <th>
                        Terça
                    </th>
                    <th>
                        Quarta
                    </th>
                    <th>
                        Quinta
                    </th>
                    <th>
                        Sexta
                    </th>
                </tr>
            </thead>
            <tbody>
                <%
                    try {
                        int i = 0;
                        Cardapio cardapio = new Cardapio();
                        cardapio.find((String) application.getAttribute("DATAHOJE"));
                        for (Turno turno : cardapio.getTurnos()) {
                            if (i == 0) {
                                out.println("<td>");
                            }
                            for (Alimento alimento : turno.getAlimentos()) {
                                out.println(alimento.getNome());
                                //out.println("<br>");
                            }
                            i++;
                            if (i == 2) {
                                i = 0;
                                out.println("</td>");;
                            }
                        }
                    } catch (Exception ex) {
                        out.println(ex.getMessage());
                    }
                %>
            </tbody>
        </table>
    </body>
</html>

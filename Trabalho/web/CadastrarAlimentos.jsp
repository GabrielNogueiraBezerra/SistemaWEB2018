<%-- 
    Document   : CadastrarAlimentos
    Created on : 10/06/2018, 10:51:48
    Author     : gabri
--%>

<%@page import="DAO.AlimentoDAO"%>
<%@page import="Models.Alimento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.CategoriaAlimentoDAO"%>
<%@page import="Models.Usuario"%>
<%@page import="Models.CategoriaAlimento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Alimentos</title>
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

        <h1>Cadastrar Alimentos</h1>

        <form method="post" action="/Trabalho/Controller?comando=AdicionarAlimentos">
            <input type="text" name="nome" id="nome" placeholder="nome"><br/><br/>
            <input type="text" name="fibras" id="fibras" placeholder="fibras"><br/><br/>
            <input type="text" name="carboidratos" id="carboidratos" placeholder="carboidratos"><br/><br/>
            <input type="text" name="calorias" id="calorias" placeholder="calorias"><br/><br/>
            <select id="categoria" name="categoria">
                <%
                    ArrayList<CategoriaAlimento> categorias = CategoriaAlimentoDAO.getInstancia().buscarTodos();
                    for (CategoriaAlimento categoriaAlimento : categorias) {
                        out.println("<option value='" + String.valueOf(categoriaAlimento.getId()) + "'>"
                                + categoriaAlimento.getNomeCategoria()
                                + "</option>");
                    }
                %>
            </select><br/><br/>
            <input type="submit" value="Cadastrar">
        </form>

        <br>
        <hr>
        <%
            ArrayList<Alimento> alimentos = AlimentoDAO.getInstancia().buscarTodos();

            for (Alimento alimento : alimentos) {
                out.println(alimento.getNome()+ " <a href='/Trabalho?comando=AlterarAlimento&id=" + alimento.getId() + "'>Alterar</a> | <a href='/Trabalho?comando=ExcluirAlimento&id=" + alimento.getId() + "'>Excluir</a> <br>");
            }


        %>
    </body>
</html>

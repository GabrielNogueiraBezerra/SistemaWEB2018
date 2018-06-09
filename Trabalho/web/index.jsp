<%-- 
    Document   : index
    Created on : 18/05/2018, 18:41:14
    Author     : Marcelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1>
            Autenticação
        </h1>
        <form method="post" action="/Trabalho/Pagina?comando=Logar">
            <label>
                Login:<input type="text" name="login">
            </label><br/><br/>
            <label>
                Senha:<input type="password" name="senha">
            </label><br/><br/>
            <input type="submit" value="Entrar">
        </form>
        <hr/>
        <h1>Cardápio</h1>
    </body>
</html>

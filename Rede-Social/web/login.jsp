<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entrar</title>
    </head>
    <body>
        <header>
            <h1>Bem-Vind@ de Volta!</h1>
        </header>
        <section>
            <div>
                <form name="loginusuario" action="LoginUsuario" method="post">
                    <table>
                        <th>
                            <h2>Insira suas credenciais para entrar</h2>
                        </th>
                        <tr>
                            <td><label>E-mail:</label></td>
                            <td><input type="text" name="emailusuario"></td>
                        </tr>
                        <tr>
                            <td><label>Senha:</label></td>
                            <td><input type="text" name="senhausuario"></td>
                        </tr>
                        <tr>
                            <td><input class="esp" type="submit" value="Salvar" name="logar"></td>
                            <td><input class="esp" type="reset" value="Limpar"></td>
                        </tr>
                    </table> 
                    <h4>Não tem uma conta? <a href="cadastrarusuario.jsp">Clique aqui</a></h4>
                    ${mensagem}
                    <a href="index.jsp">Voltar</a>
                </form>
            </div>
        </section>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastre-se</title>
        <link rel="stylesheet" type="text/css" href="../estilos/style.css" media="screen" />
    </head>
    <body>
        <header>
            <h1>Junte-se á Nós</h1>
        </header>
        <section>
            <div>
                <form name="cadastrarusuario" action="CadastrarUsuario" method="post">
                    <table>
                        <tr>
                            <td><label>Nome:</label></td>
                            <td><input type="text" name="primeironomeusuario"></td>
                        </tr>
                        <tr>
                            <td><label>Sobrenome:<label></td>
                            <td><input type="text" name="sobrenomeusuario"></td>
                        </tr>
                        <tr>
                            <td><label>Telefone</label></td>
                            <td><input type="text" name="telefoneusuario"></td>
                        </tr>
                        <tr>
                            <td><label for="genero">Gênero:</label></td>
                            <td>
                                <select name="genero" id="genero">
                                  <option value="Masculino">Masculino</option>
                                  <option value="Feminino">Feminino</option>
                                  <option value="Outro">Outro</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label>Crie seu E-mail:</label></td>
                            <td><input type="text" name="emailusuario"></td>
                        </tr>
                        <tr>
                            <td><label>Senha:</label></td>
                            <td><input type="text" name="senhausuario"></td>
                        </tr>
                        <tr>
                            <td><input class="esp" type="submit" value="Salvar" name="cadastrar"></td>
                            <td><input class="esp" type="reset" value="Limpar"></td>
                        </tr>
                    </table> 
                    ${mensagem}
                    <a href="index.jsp">Voltar</a>
                </form>
            </div>
        </section>
    </body>
</html>
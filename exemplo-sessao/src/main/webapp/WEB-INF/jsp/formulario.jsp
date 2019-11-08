<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulário</title>
    </head>
    <body>
        <h1>Formulário</h1>
        <form action="${pageContext.request.contextPath}/salvar-formulario" method="post">
            <div>
                <label>Texto</label>
                <input type="text" name="texto" />
            </div>
            <fieldset>
                <legend>Selecionar o método para apresentar resultado do texto digitado</legend>
                <div><input type="radio" name="resultado" id="normal" value="1" checked /> <label for="normal">Normal</label></div>
                <div><input type="radio" name="resultado" id="prg" value="2" /> <label for="prg">POST-REDIRECT-GET</label></div>
            </fieldset>
            <button type="submit">Enviar</button>
        </form>
    </body>
</html>

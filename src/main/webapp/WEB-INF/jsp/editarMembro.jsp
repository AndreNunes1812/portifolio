<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Membro</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h1>Editar Membro</h1>
    <form action="salvarEdicaoMembro" method="post">
        <div class="form-group">
            <label for="projeto">Projeto:</label>
             <select class="form-control" id="projeto" name="projeto">
                     <c:forEach var="projeto" items="${projetos}">
                        <option value="${membro.projeto.id}">${membro.projeto.nome}</option>
                    </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="pessoa">Pessoa:</label>
            <select class="form-control" id="pessoa" name="pessoa" >
                <option value="${membro.pessoa.id}">${membro.pessoa.nome}</option>
            </select>
        </div>
        <input type="hidden" id="idProjeto" name="idProjeto" value="${idProjeto}">
        <input type="hidden" id="idPessoa" name="idPessoa" value="${idPessoa}">
        <button type="submit" class="btn btn-primary">Salvar</button>
        <a href="/membros" class="btn btn-secondary">Voltar</a>
    </form>
</div>

</body>
</html>

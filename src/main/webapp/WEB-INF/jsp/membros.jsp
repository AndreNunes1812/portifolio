<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Membros</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 70vh;
        }

        .table tbody tr:nth-child(even) {
            background-color: #f2f2f2; /* Cor de fundo para linhas pares */
        }
    </style>
</head>
<body>

    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger" role="alert">
            ${errorMessage}
        </div>
    </c:if>

    <div class="container">
        <div class="text-center">
            <h1>Lista de Membros</h1>
            <a href="menu" class="btn btn-secondary">Voltar</a>
            <table class="table">
                <thead>
                    <tr>
                        <th>Nome da Pesosa</th>
                        <th>Nome do Projeto</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>

                <c:forEach var="membro" items="${membros}">
                    <tr>
                        <td>${membro.pessoa.nome}</td>
                        <td>${membro.projeto.nome}</td>
                        <td>
                            <a href="/membros/editarMembro?idProjeto=${membro.idProjeto}&idPessoa=${membro.idPessoa}" class="btn btn-primary mr-1">Editar</a>
                            <a href="/membros/excluirMembro?idProjeto=${membro.idProjeto}&idPessoa=${membro.idPessoa}" class="btn btn-danger btn-excluir" onclick="return confirm('Tem certeza que deseja excluir este membro?')">Excluir</a>
                         </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>

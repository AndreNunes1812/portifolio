-<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Projetos</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Centraliza o conteúdo */
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 80vh;
        }
        /* Espaçamento entre os botões */
        .btn {
            margin-right: 20px;
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
    <div class="col-md-12">
        <h2 class="mb-6">Lista de Projetos</h2>
        <a href="/menu" class="btn btn-primary">Voltar</a>
        <a href="/projetos/project" class="btn btn-success">Cadastrar Projeto</a>
        <div class="table-responsive mt-6">
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Descrição</th>
                        <th>Status</th>
                        <th>Orçamento</th>
                        <th>Risco</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${projetos}" var="projeto">
                        <tr>
                            <td>${projeto.id}</td>
                            <td>${projeto.nome}</td>
                            <td>${projeto.descricao}</td>
                            <td>${projeto.status}</td>
                            <td>${projeto.orcamento}</td>
                            <td>${projeto.risco}</td>
                            <td>
                                <div class="btn-group" role="group">
                                    <a href="/projetos/editarProjeto?id=${projeto.id}" class="btn btn-primary">Editar</a>
                                    <a href="/projetos/excluirProjeto?id=${projeto.id}" class="btn btn-danger" onclick="return confirm('Tem certeza que deseja excluir este projeto?')">Excluir</a>
                                 </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>

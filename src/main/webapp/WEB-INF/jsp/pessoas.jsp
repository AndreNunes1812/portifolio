<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Pessoas</title>
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
    <div class="container">
        <div class="text-center">
            <h1>Lista de Pessoas</h1>
            <a href="cadastrar" class="btn btn-primary mr-3">Cadastrar Pessoa</a>
            <a href="menu" class="btn btn-secondary">Voltar</a>
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Gerente</th>
                        <th>Funcionário</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>

                <c:forEach var="pessoa" items="${pessoas}">
                    <tr>
                        <td>${pessoa.id}</td>
                        <td>${pessoa.nome}</td>
                        <td>${pessoa.cpf}</td>
                        <td>${pessoa.gerente ? 'Sim' : 'Não'}</td>
                        <td>${pessoa.funcionario ? 'Sim' : 'Não'}</td>
                         <td>
                            <a href="editarPessoa?id=${pessoa.id}" class="btn btn-primary mr-1">Editar</a>
                            <a href="excluirPessoa?id=${pessoa.id}" class="btn btn-danger btn-excluir" onclick="return confirm('Tem certeza que deseja excluir esta pessoa?')">Excluir</a>
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

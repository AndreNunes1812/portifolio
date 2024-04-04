<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!DOCTYPE html>
<html lang="en">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Pessoa</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Centraliza o formulário */
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 70vh;
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
    <div class="col-md-6">
        <h2 class="mb-4">Cadastrar Pessoa</h2>
        <form action="/cadastrar" method="POST">
            <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" class="form-control" id="nome" name="nome" required>
            </div>
            <div class="form-group">
                <label for="dataNascimento">Data de Nascimento:</label>
                <input type="date" class="form-control" id="dataNascimento" name="dataNascimento" required>
            </div>
            <div class="form-group">
                <label for="cpf">CPF:</label>
                <input type="text" class="form-control" id="cpf" name="cpf" required>
            </div>
            <div class="form-group form-check">
                <input type="checkbox" class="form-check-input" id="funcionario" name="funcionario">
                <label class="form-check-label" for="funcionario">Funcionário</label>
            </div>
            <div class="form-group form-check">
                <input type="checkbox" class="form-check-input" id="gerente" name="gerente">
                <label class="form-check-label" for="gerente">Gerente</label>
            </div>
            <button type="submit" class="btn btn-primary mr-2">Cadastrar</button>
            <a href="/menu" class="btn btn-secondary">Voltar para o Menu</a>
        </form>
    </div>
</div>

</body>
</html>

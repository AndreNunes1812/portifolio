<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Pessoa</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Ajustar o tamanho do formulário */
        form {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            background-color: #f8f9fa;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        /* Espaçamento entre os elementos do formulário */
        .form-group {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <form action="editarPessoa" method="POST">
        <h2 class="mb-4">Editar Pessoa</h2>
        <input type="hidden" name="id" value="${pessoa.id}">
        <div class="form-group">
            <label for="nome">Nome:</label>
            <input type="text" class="form-control" id="nome" name="nome" value="${pessoa.nome}" required>
        </div>
        <div class="form-group">
            <label for="dataNascimento">Data de Nascimento:</label>
            <input type="date" class="form-control" id="dataNascimento" name="dataNascimento" value="${pessoa.dataNascimento}" pattern="\d{2}/\d{2}/\d{4}" required>
        </div>
        <div class="form-group">
            <label for="cpf">CPF:</label>
            <input type="text" class="form-control" id="cpf" name="cpf" value="${pessoa.cpf}" required>
        </div>
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="funcionario" name="funcionario" ${pessoa.funcionario ? 'checked' : ''}>
            <label class="form-check-label" for="funcionario">Funcionário</label>
        </div>
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="gerente" name="gerente" ${pessoa.gerente ? 'checked' : ''}>
            <label class="form-check-label" for="gerente">Gerente</label>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-primary mr-2">Salvar</button>
            <a href="pessoas" class="btn btn-secondary">Voltar</a>
        </div>
    </form>
</div>

</body>
</html>

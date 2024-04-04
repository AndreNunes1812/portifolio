<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Projeto</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Ajustes para distanciar do topo */
        body {
            padding-top: 20px;
        }
        /* Ajustes para adicionar barra de rolagem */
        .container {
            height: 70vh;
            overflow-y: auto;
        }
        /* Estilo para cada campo de formulário */
        .form-group {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-6">
            <h2 class="mb-4">Cadastrar Projeto</h2>
            <form action="/inProject" method="POST">
                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input type="text" class="form-control" id="nome" name="nome" required>
                </div>
                <div class="form-group">
                    <label for="descricao">Descrição:</label>
                    <textarea class="form-control" id="descricao" name="descricao" rows="3" required></textarea>
                </div>
                <div class="form-group">
                    <label for="dataInicio">Data de Início:</label>
                    <input type="date" class="form-control" id="dataInicio" name="dataInicio" required>
                </div>
                <div class="form-group">
                    <label for="dataPrevisaoFim">Data de Previsão de Término:</label>
                    <input type="date" class="form-control" id="dataPrevisaoFim" name="dataPrevisaoFim" required>
                </div>
                <div class="form-group">
                      <label for="dataFim">Data Fim:</label>
                      <input type="date" class="form-control" id="dataFim" name="dataFim" required>
                </div>
                 <div class="form-group">
                      <label for="risco">Risco:</label>
                      <select class="form-control" id="status" name="status" required>
                         <c:forEach items="${statusValues}" var="status">
                            <option value="${status}">${status}</option>
                         </c:forEach>
                      </select>
                 </div>
                <div class="form-group">
                    <label for="orcamento">Orçamento:</label>
                    <input type="number" class="form-control" id="orcamento" name="orcamento" step="0.01" required>
                </div>
                <div class="form-group">
                    <label for="risco">Risco:</label>
                    <select class="form-control" id="risco" name="risco" required>
                        <c:forEach items="${riscoValues}" var="risco">
                            <option value="${risco}">${risco}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                     <label for="gerente">Gerente:</label>
                     <select class="form-control" id="gerencial" name="gerencial" required>
                       <c:forEach items="${gerentes}" var="gerente">
                          <option value="${gerente.id}">${gerente.nome}</option>
                       </c:forEach>
                     </select>
                </div>
                <button type="submit" class="btn btn-primary mr-2">Cadastrar</button>
                <a href="/menu" class="btn btn-secondary">Voltar</a>
            </form>
        </div>
    </div>
</div>

</body>
</html>

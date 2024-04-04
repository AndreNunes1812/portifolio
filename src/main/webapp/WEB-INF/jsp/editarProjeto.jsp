<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Projeto</title>
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
            <h2 class="mb-4">Editar Projeto</h2>
            <form action="/editarProjeto" method="POST">
                <input type="hidden" name="id" value="${projeto.id}">
                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input type="text" class="form-control" id="nome" name="nome" value="${projeto.nome}" required>
                </div>
                <div class="form-group">
                    <label for="descricao">Descrição:</label>
                    <textarea class="form-control" id="descricao" name="descricao" rows="3" required>${projeto.descricao}</textarea>
                </div>
                <div class="form-group">
                    <label for="dataInicio">Data de Início:</label>
                    <input type="date" class="form-control" id="dataInicio" name="dataInicio" value="${projeto.dataInicio}" required>
                </div>
                <div class="form-group">
                    <label for="dataPrevisaoFim">Data de Previsão de Término:</label>
                    <input type="date" class="form-control" id="dataPrevisaoFim" name="dataPrevisaoFim" value="${projeto.dataPrevisaoFim}" required>
                </div>
                <div class="form-group">
                    <label for="dataFim">Data Fim:</label>
                    <input type="date" class="form-control" id="dataFim" name="dataFim" value="${projeto.dataFim}" required>
                </div>
                <div class="form-group">
                    <label for="status">Status:</label>
                    <select class="form-control" id="status" name="status" required>
                        <c:forEach items="${statusValues}" var="status">
                            <option value="${status}" ${projeto.status eq status ? 'selected' : ''}>${status}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="orcamento">Orçamento:</label>
                    <input type="number" class="form-control" id="orcamento" name="orcamento" step="0.01" value="${projeto.orcamento}" required>
                </div>
                <div class="form-group">
                    <label for="risco">Risco:</label>
                    <select class="form-control" id="risco" name="risco" required>
                        <c:forEach items="${riscoValues}" var="risco">
                            <option value="${risco}" ${projeto.risco eq risco ? 'selected' : ''}>${risco}</option>
                        </c:forEach>
                    </select>
                </div>
                 <div class="form-group">
                      <label for="gerencial">Gerente:</label>
                      <select class="form-control" id="gerencial" name="gerencial" required>
                         <c:forEach items="${gerentes}" var="gerente">
                           <option value="${gerente.id}" ${projeto.gerencial.id eq gerente.id ? 'selected' : ''}>${gerente.nome}</option>
                         </c:forEach>
                      </select>
                   </div>
                <button type="submit" class="btn btn-primary mr-2">Salvar</button>
                <a href="/projetos" class="btn btn-secondary">Voltar</a>
            </form>
        </div>
    </div>
</div>

</body>
</html>

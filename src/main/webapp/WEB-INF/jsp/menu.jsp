<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
         .menu-background {
                background-color: #f8f9fa;
                padding: 20px;
                border-radius: 5px;
         }
         .btn-group > a {
                     margin-right: 20px;
         }
        .centered-buttons {
            display: flex;
            flex-direction: row;
            align-items: center;
            justify-content:  space-between;;
            height: 100vh;
        }
    </style>
</head>
<body>
    <h1 class="mb-5">Menu</h1>
    <div class="menu-background">
         <div class="btn-group">
              <a href="pessoas" class="btn btn-primary btn-lg">Pessoas</a>
              <a href="projetos" class="btn btn-primary btn-lg">Projetos</a>
              <a href="membros" class="btn btn-primary btn-lg">Membros</a>
          </div>
    </div>
</body>
</html>

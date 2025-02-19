<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Livros de Java, Android, iPhone, PHP, Ruby e muito mais -
        Casa do Código</title>
</head>
<body>

<form action="/casadocodigo/produtos" method="post">
    <div>
        <label>Titulo</label> <input type="text" name="titulo">
    </div>
    <div>
        <label>Descrição</label>
        <textarea rows="10" cols="20" name="descricao"></textarea>
    </div>
    <div>
        <label>Páginas</label> <input type="text" name="paginas">
    </div>
    <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
        <div>
            <label>${tipoPreco}</label>
            <input type="text" name="precos[${status.index}].valor">
            <input type="hidden" name="precos[${status.index}].tipo" value="${tipoPreco}">
        </div>
    </c:forEach>
    <button type="submit">Cadastrar</button>
</form>
</body>
</html>
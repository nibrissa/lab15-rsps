<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Редактирование типов счетов</title>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script defer src="js/jquery-3.6.4.js"></script>
    <script defer src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <jsp:include page="header.jsp" />
    <div class="container-fluid">
        <div class="row justify-content-start ">
            <div class="col-8 border bg-light px-4">
                <h3>Список типов</h3>
                <table class="table">
                    <thead>
                    <th scope="col">ID</th>
                    <th scope="col">Тип</th>
                    </thead>
                    <tbody>
                    <c:forEach var="type" items="${types}">
                        <tr>
                            <td>${type.id}</td>
                            <td>${type.type}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-4 border px-4">
                <form method="POST" action="">
                    <h3>Редактирование</h3>
                    <div class="mb-3">
                        <br>

                        <div class="col-sm-6">
                            <label>
                                <label for="id" class="col-sm-3 col-form-label">ID</label>
                                <input type="text" name="id" readonly value="${edit.id}" class="form-control" id="id"/>
                            </label>
                        </div>

                        <div class="col-sm-6">
                            <label>
                                <label for="type" class="col-sm-3 col-form-label">Тип</label>
                                <input type="text" name="type" value="${edit.type}" class="form-control" id="type"/>
                            </label>
                        </div>

                    </div>
                    <p>
                        <br> <br> <br>
                        <button type="submit" class="btn btn-primary">Редактировать</button>
                        <a href='<c:url value="/Type" />' role="button" class="btn btn-secondary">Отмена</a>
                        <br>
                    </p>
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp" />
</div>
</body>
</html>
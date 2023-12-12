<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Редактирование договора</title>
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
                <h3>Список договоров</h3>
                <table class="table">
                    <thead>
                    <th scope="col">ID</th>
                    <th scope="col">Номер</th>
                    <th scope="col">Дата открытия</th>
                    <th scope="col">Дата закрытия</th>
                    <th scope="col">Пояснения</th>
                    </thead>
                    <tbody>
                    <c:forEach var="agreement" items="${agreements}">
                        <tr>
                            <td>${agreement.id}</td>
                            <td>${agreement.number}</td>
                            <td>${agreement.dataOpen}</td>
                            <td>${agreement.dataClose}</td>
                            <td>${agreement.note}</td>
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
                                <label for="number" class="col-sm-3 col-form-label">Номер договора</label>
                                <input type="text" name="number" value="${edit.number}" class="form-control" id="number"/>
                            </label>
                        </div>

                        <div class="col-sm-6">
                            <label>
                                <label for="open" class="col-sm-3 col-form-label">Дата открытия</label>
                                <input type="date" name="open" value="${edit.dataOpen}" class="form-control" id="open"/>
                            </label>
                        </div>

                        <div class="col-sm-6">
                            <label>
                                <label for="close" class="col-sm-3 col-form-label">Дата закрытия</label>
                                <input type="date" name="close" value="${edit.dataClose}" class="form-control" id="close"/>
                            </label>
                        </div>

                        <div class="col-sm-6">
                            <label>
                                <label for="note" class="col-sm-3 col-form-label">Пояснение</label>
                                <input type="text" name="note" value="${edit.note}" class="form-control" id="note"/>
                            </label>
                        </div>

                    </div>

                    <p>
                        <br> <br> <br>
                        <button type="submit" class="btn btn-primary">Редактировать</button>
                        <a href='<c:url value="/Agreement" />' role="button" class="btn btn-secondary">Отмена</a>
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
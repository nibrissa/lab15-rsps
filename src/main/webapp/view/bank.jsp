<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Банки</title>
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
                <h3>Список банков</h3>
                <table class="table">
                    <thead>
                    <th scope="col">ID</th>
                    <th scope="col">Полное название</th>
                    <th scope="col">Короткое название</th>
                    <th scope="col">ИНН</th>
                    <th scope="col">БИК</th>
                    <th scope="col">Кор. счет</th>
                    <th scope="col">Банковский счет</th>
                    <th scope="col">Город</th>
                    <th scope="col"> Редактировать</th>
                    <th scope="col">Удалить</th>
                    </thead>
                    <tbody>
                    <c:forEach var="bank" items="${banks}">
                        <tr>
                            <td>${bank.id}</td>
                            <td>${bank.fullname}</td>
                            <td>${bank.shortname}</td>
                            <td>${bank.inn}</td>
                            <td>${bank.bik}</td>
                            <td>${bank.coraccount}</td>
                            <td>${bank.account}</td>
                            <td>${bank.city}</td>
                            <td><a href='<c:url value="/EditBank?id=${bank.getId()}" />' class="btn btn-outline-primary"><img src="images/edit.png" alt="Редактировать"/></a></td>
                            <td><a href='<c:url value="/DeleteBank?id=${bank.getId()}" />' role="button" class="btn btn-outline-primary"><img alt="Удалить" src="images/delete.png"></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-4 border px-4">
                <form method="POST" action="">
                    <h3>Новый клиент</h3>
                    <div class="mb-3">
                        <br>

                        <div class="col-sm-6">
                            <label>
                                <label for="fullname" class="col-sm-3 col-form-label">Полное название</label>
                                <input type="text" name="fullname" class="form-control" id="fullname"/>
                            </label>
                        </div>

                        <div class="col-sm-6">
                            <label>
                                <label for="shortname" class="col-sm-3 col-form-label">Короткое название</label>
                                <input type="text" name="shortname" class="form-control" id="shortname"/>
                            </label>
                        </div>

                        <div class="col-sm-6">
                            <label>
                                <label for="inn" class="col-sm-3 col-form-label">ИНН</label>
                                <input type="number" name="inn" class="form-control" id="inn"/>
                            </label>
                        </div>

                        <div class="col-sm-6">
                            <label>
                                <label for="bik" class="col-sm-3 col-form-label">БИК</label>
                                <input type="text" name="bik" class="form-control" id="bik"/>
                            </label>
                        </div>

                        <div class="col-sm-6">
                            <label>
                                <label for="coraccount" class="col-sm-3 col-form-label">Кор. счет</label>
                                <input type="text" name="coraccount" class="form-control" id="coraccount"/>
                            </label>
                        </div>

                        <div class="col-sm-6">
                            <label>
                                <label for="account" class="col-sm-3 col-form-label">Банковский счет</label>
                                <input type="number" name="account" class="form-control" id="account"/>
                            </label>
                        </div>


                        <div class="col-sm-6">
                            <label>
                                <label for="city" class="col-sm-3 col-form-label">Город</label>
                                <input type="text" name="city" class="form-control" id="city"/>
                            </label>
                        </div>


                    </div>
                    <p>
                        <br> <br> <br>
                        <button type="submit" class="btn btn-primary">Добавить</button>
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
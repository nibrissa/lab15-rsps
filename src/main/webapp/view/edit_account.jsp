<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Редактриование счета</title>
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
                <h3>Список счетов</h3>
                <table class="table">
                    <thead>
                    <th scope="col">ID</th>
                    <th scope="col">Банк</th>
                    <th scope="col">Договор</th>
                    <th scope="col">Тип</th>
                    <th scope="col">Счет</th>
                    </thead>
                    <tbody>
                    <c:forEach var="account" items="${accounts}">
                        <tr>
                            <td>${account.id}</td>
                            <td>${account.bank.shortname}</td>
                            <td>${account.agreement.number}</td>
                            <td>${account.type.type}</td>
                            <td>${account.account}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-4 border px-4">
                <form method="POST" action="">
                    <h3>Новый договор</h3>
                    <div class="mb-3">
                        <br>

                        <div class="mb-3 row">
                            <label for="type" class="col-sm-3 col-form-label">ID</label>
                            <div class="col-sm-7">
                                <input type="text" name="id" readonly value="${edit.id}" class="form-control" id="id"/>
                            </div>
                        </div>


                        <div class="mb-3 row">
                            <label for="type" class="col-sm-3 col-form-label">Тип счета</label>
                            <div class="col-sm-7">
                                <select name="type" id="type" class="form-control">
                                    <option value="${edit.type}">${edit.type.type}</option>
                                    <c:forEach var="type" items="${types}">
                                        <option value="${type}"><c:out value="${type.type}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="mb-3 row">
                            <label for="bank" class="col-sm-3 col-form-label">Банк</label>
                            <div class="col-sm-7">
                                <select name="bank" id="bank" class="form-control">
                                    <option value="${edit.bank}">${edit.bank.shortname}</option>
                                    <c:forEach var="bank" items="${banks}">
                                        <option value="${bank}"><c:out value="${bank.shortname}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="mb-3 row">
                            <label for="agreement" class="col-sm-3 col-form-label">Договор</label>
                            <div class="col-sm-7">
                                <select name="agreement" id="agreement" class="form-control">
                                    <option value="${edit.agreement}">${edit.agreement.number}</option>
                                    <c:forEach var="agreement" items="${agreements}">
                                        <option value="${agreement}"><c:out value="${agreement.number}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <label>
                                <label for="account" class="col-sm-3 col-form-label">Счет</label>
                                <input type="text" name="account" value="${edit.account}" class="form-control" id="account"/>
                            </label>
                        </div>

                    </div>

                    <p>
                        <br> <br> <br>
                        <button type="submit" class="btn btn-primary">Редактировать</button>
                        <a href='<c:url value="/Account" />' role="button" class="btn btn-secondary">Отмена</a>
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
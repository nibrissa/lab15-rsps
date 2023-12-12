<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru" style="height: 100%;">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <title>Управление счетами</title>
</head>
<body class="bodys">
<div class="container-fluid" style="background: #0a6464">
    <jsp:include page="header.jsp" />
    <div class="container" style="background: #0a6464; flex: 1 0 auto">
        <br><br><br>
        <div class="list-group text-center py-3 px-3">
            <h2>Функции системы</h2>
            <a class="list-group-item list-group-itemprimary item hrefitem" href="Account">Счета</a>
            <a class="list-group-item list-group-iteminfo item hrefitem"  href="Bank">Банки</a>
            <a class="list-group-item list-group-iteminfo item hrefitem"  href="Agreement">Договора</a>
            <a class="list-group-item list-group-iteminfo item hrefitem"  href="Type">Типы счета</a>
        </div>
        <br><br>
    </div>
    <jsp:include page="footer.jsp" />
</div>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 14.04.2021
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Admin</title>
        <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/pages/drinks.jsp">Coffee machine</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="${pageContext.request.contextPath}/profile">Profile</a></li>
                        <li><a href="${pageContext.request.contextPath}/ordersList">My orders</a></li>
                        <li><a href="${pageContext.request.contextPath}/admin">Admin</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="p-3 mb-4">
                <div class="d-flex align-items-center justify-content-center">
                    <div class="col-example" style="margin-top:10%">
                        <table class="table">
                            <thead class="thead-dark">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Ingredient name</th>
                                <th scope="col">Cost</th>
                                <th scope="col">Amount</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${ingredients}" var="ingredient" varStatus="сounter">
                                <tr>
                                    <th scope="row">${сounter.count}</th>
                                    <td>${ingredient.getName()}</td>
                                    <td>${ingredient.getCost()}</td>
                                    <td>${ingredient.getAmount()}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <form class="main-form first" action="${pageContext.request.contextPath}/admin?updated=true" method="post">
                <div class="input-group mb-3 d-flex">
                    <div class="input-group-append" style="margin-top: 15px">
                        <button id = "depositButton" class="btn btn-outline-secondary" type="submit">Fill!</button>
                    </div>
                </div>
                <input type="hidden" id="finalMoneyAmountH" name="finalMoneyAmountHName" value="1">
            </form>

        </div>
    </body>
</html>

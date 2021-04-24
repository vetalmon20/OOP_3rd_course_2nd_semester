<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 14.04.2021
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>My orders</title>
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
                                    <th scope="col">Drink name</th>
                                    <th scope="col">Date</th>
                                    <th scope="col">Cost</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${orders}" var="order" varStatus="сounter">
                                <tr>
                                    <th scope="row">${сounter.count}</th>
                                    <td>${order.getDrinkName()}</td>
                                    <td>${order.getDate()}</td>
                                    <td>${order.getCost()}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                    </table>
                    </div>
                </div>
            </div>


        </div>

    </body>
</html>

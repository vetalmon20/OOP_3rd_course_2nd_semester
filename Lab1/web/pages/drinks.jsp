<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 11.04.2021
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>

<html lang="en">
<head>
    <title>Drinks</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
    <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    <style>
        <%@include file="../styles/drinks.css" %>
    </style>
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

    <div class="container d-flex justify-content-center mt-100">
        <div class="row">
            <c:forEach items="${drinks}" var="drink">
                <div class="col-md-3">
                    <div class="product-wrapper mb-45 text-center">
                        <div class="product-img">
<%--                            <a href="#" data-abc="true"><img src="${pageContext.request.contextPath}../img/test.jpg" alt="drink12"></a>--%>
                                <a href="${pageContext.request.contextPath}/order?drink=${drink.getId()}" data-abc="true"><img src="https://image.freepik.com/free-photo/paper-cup-coffee-isolated-white-background_93675-84436.jpg" alt="drink12" style="height: 100%; width: 100%"></a>
                            <span style="background-color: #fcba03; border-radius: 5px;"><i class="fa fa-rupee" style="color: white">${drink.getCost()}</i></span>
                            <div>
                                <span class="name"><i class="fa fa-rupee" style="font-size: 16px">${drink.getName()}</i></span>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>



</body>
</html>

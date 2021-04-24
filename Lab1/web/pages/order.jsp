<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 11.04.2021
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Order</title>
        <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script type="text/javascript">
            <%@include file="../js/counter.js" %>
        </script>
        <style>
            <%@include file="../styles/counter.css" %>
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
        <c:choose>
            <c:when test="${drinkName != null}">
                <div class="container d-flex justify-content-center mt-100">
                    <div class="row d-flex justify-content-center">
                        <div class="col-md-4 justify-content-center" style="height: 200px; width: 150px; margin-left: 40%" >
                            <form name="orderForm" class="main-form first" action="${pageContext.request.contextPath}/order?test=5" method="post">
                                <div class="product-wrapper mb-45 text-center">
                                    <div class="product-img">
                                        <a href="#" data-abc="true">
                                            <img src="https://image.freepik.com/free-photo/paper-cup-coffee-isolated-white-background_93675-84436.jpg" alt="drink12" style="height: 100%; width: 100%">
                                        </a>
                                        <div style="margin-bottom: 5px;">
                                            <span class="name"><i class="fa fa-rupee" style="font-size: 16px;">${drinkName}</i></span>
                                        </div>

                                    </div>
                                    <c:forEach items="${drinkIngr}" var="ingr">
                                        <p class="name"><i class="fa fa-rupee" style="font-size: 10px; line-height: 1px">-${ingr}</i></p>
                                    </c:forEach>
                                    <!-- Change the `data-field` of buttons and `name` of input field's for multiple plus minus buttons-->
                                    <div class="qty mt-5">
                                        <span class="minus bg-dark">-</span>
                                        <label>
                                            <input type="number" class="count" name="qty" value="1" onchange="changeSum()">
                                        </label>
                                        <span class="plus bg-dark">+</span>
                                    </div>
                                    <c:forEach items="${allIngr}" var="ingr">
                                        <div style=" margin-bottom: -9px">
                                            <input onclick="changeSum()" type="checkbox" id="checkbox${ingr.getId()}" name="checkboxName${ingr.getId()}"
                                                   style="width: 0.7em;height: 0.7em;">
                                            <label for="checkboxName${ingr.getId()}" style="font-size: 11px">${ingr.getName()}</label>
                                            <input type="hidden" id="${ingr.getId()}h" value="${ingr.getCost()}">
                                        </div>

                                    </c:forEach>
                                    <div style="margin-top: 15px">
                                        <span style="background-color: #fcba03; border-radius: 5px;"><i id="sumId" class="fa fa-rupee" style="color: white; ">SUM:${drinkCost}</i></span>
                                    </div>

                                    <button id="button" type="submit" class="btn btn-success" style="margin-top: 8px">ORDER</button>
                                    <input type="hidden" id="drinkCostH" value="${drinkCost}">
                                    <input type="hidden" id="finalCostH" name="finalCostHName" value="${drinkCost}">
                                    <input type="hidden" id="finalDrinkIdH" name="finalDrinkIdHName" value="${drinkId}">
                                    <input type="hidden" id="finalDrinkIngrsH" name="finalDrinkIngrsHName" value="">
                                    <input type="hidden" id="finalDrinkQuantH" name="finalDrinkQuantHName" value="1">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div class="container">
                    <div class="row" style="width: 100%; height: 100%;">
                        <div class="col-md-6 col-md-offset-3">
                            <p style="padding-top: 40%">The order is completed!</p>
                        </div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>

    </body>
</html>

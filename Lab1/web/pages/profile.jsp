<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 14.04.2021
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Profile</title>
        <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <style>
            <%@include file="../styles/profile.css" %>
        </style>
        <script type="text/javascript">
            <%@include file="../js/money.js" %>
        </script>
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
        <div class="page-content page-container" id="page-content" style="padding-top: 10%">
            <div class="padding">
                <div class="row container d-flex justify-content-center">
                    <div class="col-xl-6 col-md-12">
                        <div class="card user-card-full">
                            <div class="row m-l-0 m-r-0">
                                <div class="col-sm-4 bg-c-lite-green user-profile">
                                    <div class="card-block text-center text-white">
                                        <div class="m-b-25"> <img src="https://img.icons8.com/bubbles/100/000000/user.png" class="img-radius" alt="User-Profile-Image"> </div>
                                        <h6 class="f-w-600">Name:${user.getName()}</h6>
                                        <p>Role:${user.getRole()}</p> <i class=" mdi mdi-square-edit-outline feather icon-edit m-t-10 f-16"></i>
                                    </div>
                                </div>
                                <div class="col-sm-8">
                                    <div class="card-block">
                                        <h6 class="m-b-20 p-b-5 b-b-default f-w-600">Information</h6>
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <p class="m-b-10 f-w-600">Email</p>
                                                <h6 class="text-muted f-w-400">${user.getEmail()}</h6>
                                            </div>
                                            <div class="col-sm-6">
                                                <p class="m-b-10 f-w-600">Money</p>
                                                <h6 name="moneyTextName" id= "moneyText" class="text-muted f-w-400">${user.getMoney()}</h6>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <form class="main-form first" action="${pageContext.request.contextPath}/profile?deposit=true" method="post">
                            <div class="input-group mb-3 d-flex">
                                <input min = "0" value="0" id="moneyToDeposit" type="number" class="form-control" placeholder="Enter money to deposit" aria-label="Enter money to deposit" aria-describedby="basic-addon2">
                                <div class="input-group-append" style="margin-top: 15px">
                                    <button id = "depositButton" onclick="depositMoney()" class="btn btn-outline-secondary" type="submit">Deposit!</button>
                                </div>
                            </div>
                            <input type="hidden" id="finalMoneyAmountH" name="finalMoneyAmountHName" value="1">
                        </form>

                    </div>

                </div>

            </div>
        </div>

    </body>
</html>

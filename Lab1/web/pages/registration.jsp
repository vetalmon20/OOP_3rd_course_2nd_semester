<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 21.03.2021
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <title>Registration</title>
        <style>
            <%@include file="../styles/login.css" %>
        </style>
    </head>
    <body>

        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <form class="main-form first" action="${pageContext.request.contextPath}/registration" method="post">
                        <h2>Sign up</h2>
                        <div class="form-group">
                            <label for="name" class="control-label">Username</label>
                            <input id="name" class="form-control" name="username"/>
                        </div>
                        <div class="form-group">
                            <label for="email" class="control-label">Email</label>
                            <input id="email" class="form-control" name="email"/>
                        </div>
                        <div class="form-group">
                            <label for="password" class="control-label">Password</label>
                            <input id="password" class="form-control" type="password"
                                   name="password"/>
                        </div>

                        <div class="form-group">
                            <button id="button" type="submit" class="btn btn-success">Register</button>
                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/login">Log in</a>
                        </div>
                    </form>
                    <c:if test="${errorRegister != null}">
                        <div class="bar">
                            <div class="bar error">
                                <div class="close"></div>
                                <i class="ico">&#9747;</i> ${errorRegister}
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>

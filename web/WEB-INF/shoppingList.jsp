<%-- 
    Document   : shoppingList
    Created on : Oct 4, 2018, 12:12:56 PM
    Author     : 659159
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1><br>

        <h3>Hello, ${username} <a href="?action=logout">Logout</a></h3><br>

        <h3>List</h3>
        <form  action="" method="POST">
            <input type="text" name="item">
            <input type="hidden" name="action" value="add" >
            <input type="submit" value="Add" >
        </form>

         <c:if test="${shopitem != null}">
        <form action="" method="POST">
            <ul>
                <c:forEach var="item" items="${shopitem}" >
                    <li><input type="radio" name="radioButton" value="${item}" >${item}</li><br>
                </c:forEach>
            </ul>
            <input type="hidden" name="action" value="delete" >
            <input type="submit" value="Delete" >
        </form>
    </c:if>
    </body>
</html>

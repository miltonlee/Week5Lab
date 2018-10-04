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
        <h1>Shopping List</h1>
        <div>${welcome}</div>
        <h2>List</h2>
        Add item:<input type="text">
        <input type="button" value="Add">
          <c:forEach var="account" items="${shopitems}">
                <tr>
                    <td></td>
              
                </tr>
            </c:forEach> 
    </body>
</html>

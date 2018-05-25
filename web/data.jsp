<%-- 
    Document   : index
    Created on : 2015-04-13, 19:03:49
    Author     : sebastian
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello <%=request.getRemoteUser()%></h1>
        <table border='1'>
            <c:forEach items="${userData}" var="item">
                <tr>
                <form method="POST" action="MainServlet?command=edit&id=${item.id}">
                    <td>${item.id}</td>
                    <td><input type="text" name="name" value="${item.name}"/></td>
                    <td><input type="text" name="surname" value="${item.surname}"/></td>
                    <td><button type="submit">edit</button></td>
                </form>
                <td><a href="MainServlet?command=del&id=${item.id}"><button>del</button></a></td>

            </tr>
        </c:forEach>
        <tr>
        <form method="POST" action="MainServlet?command=add">
            <td><input name="name" type="text" placeholder="name"/></td>
            <td><input name="surname" type="text" placeholder="surname"/></td>
            <td><button type="submit">add</button></td>
        </form>
    </tr>
</table>
        <p>
            <a href="logout.jsp"><button>Logout</button></a>
        </p>
</body>
<!--    <script src="extra/jquery-2.1.3.min.js"></script>
    <script>
        $("#edit").click(function(){
            
        });
    </script>-->
</html>

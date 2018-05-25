<%-- 
    Document   : logout
    Created on : 2018-05-25, 13:12:58
    Author     : Mateusz Suchorab <suchorab.mateusz@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ page session="true"%>

        User '<%=request.getRemoteUser()%>' has been logged out.

        <% session.invalidate();%>

        <br/><br/>
        <a href="MainServlet">Click here to login</a>
    </body>
</html>

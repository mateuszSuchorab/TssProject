<%-- 
    Document   : logout
    Created on : 2015-05-06, 18:34:32
    Author     : sebastian
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

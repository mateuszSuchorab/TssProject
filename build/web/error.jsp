<%-- 
    Document   : error
    Created on : 2015-05-02, 21:15:25
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
        <h1>Error</h1>
        <h3>Wrong login or password</h3>
        <%
        response.setHeader("Refresh", "5; URL=index.jsp");
        %>
    </body>
</html>

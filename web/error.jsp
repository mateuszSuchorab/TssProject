<%-- 
    Document   : error
    Created on : 2018-05-25, 13:12:22
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
        <h1>Error</h1>
        <h3>Wrong login or password</h3>
        <%
        response.setHeader("Refresh", "5; URL=index.jsp");
        %>
    </body>
</html>

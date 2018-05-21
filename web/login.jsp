<%-- 
    Document   : index
    Created on : 2015-05-02, 20:56:32
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
        <form method=post action="j_security_check">
            <p>
                <span>Username:</span> <br /> <input type="text" name="j_username">
            </p>
            <p>
                <span>Password:</span> <br /> <input type="password"
                                                     name="j_password">
            </p>
            <p>
                <input type="submit" value="Login">
            </p>
        </form>
    </body>
</html>

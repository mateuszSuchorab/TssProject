<%-- 
    Document   : login
    Created on : 2018-05-25, 13:12:39
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

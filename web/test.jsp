<%-- 
    Document   : test
    Created on : 13/03/2024, 2:40:21 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="AddProductToCartServlet" method="post">
            Product id: <input value="1" name="productId" />
            Quantity: <input value="5" name="quantity" />
            <input type="submit" value="Add"/>
        </form>
    </body>
</html>

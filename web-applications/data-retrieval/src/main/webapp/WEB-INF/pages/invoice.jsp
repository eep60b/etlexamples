<%-- 
    Document   : invoice
    Created on : 12-Aug-2015, 11:35:36
    Author     : Zhipeng Chang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>ID</td>
                <td>Book ID</td>
                <td>Customer ID</td>
                <td>amount</td>
            </tr>
            <tr>
                <td>${invoice.id}</td>
                <td>${invoice.bookId}</td>
                <td>${invoice.customerId}</td>
                <td>${invoice.amount}</td>
            </tr>
        </table>
    </body>
</html>

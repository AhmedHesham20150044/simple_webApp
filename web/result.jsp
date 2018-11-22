<%-- 
    Document   : result
    Created on : Nov 20, 2018, 7:26:17 PM
    Author     : Ahmed_Hesham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>result Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style3.css">
    </head>
    <body>
         <script src="validation.js">
        </script>
        <div class="loginbox">
            <img src="css/login.png" class="avatar">
            <table align = "center">
                <tr>
                    <td id="frist" colspan="5"> <h1>result of search</h1></td>
                </tr>
                <tr>
                    <th>ID</th>
                    <th>name</th>
                    <th>address</th>
                    <th>old GPA</th>
                    <th>new GPA</th>
                </tr>
                <%
                     HttpSession s = request.getSession();
                %>
                <tr>
                    <td><%=s.getAttribute("ID") %></td>
                    <td><%=s.getAttribute("name")%></td>
                    <td><%=s.getAttribute("address")%></td>
                    <td><%=s.getAttribute("oldGPA")%></td>
                    <td><%=s.getAttribute("newGPA")%></td>
                </tr>
            </table>
            <br><br>
            <form action = "index.html">
                <input type="submit" name="add" value="back"><br> 
            </form>
        </div>
    </body>
</html>

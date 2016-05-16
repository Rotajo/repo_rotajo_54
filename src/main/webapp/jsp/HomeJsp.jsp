<%-- 
    Document   : HomeJsp
    Created on : 16 mai 2016, 16:19:53
    Author     : Jordan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page
import = "java.util.List"
import = "javax.servlet.ServletException"
import = "javax.servlet.http.HttpServlet"
import = "javax.servlet.http.HttpServletRequest"
import = "javax.servlet.http.HttpServletResponse"
import = "javax.servlet.http.HttpSession"
import = "lo54.projetlo54.core.entity.Course" %>
    
    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <center><h1>Affichage global</h1></center>
    
        <table>
            <tr>
                <th>Code UV</th>
                <th>Titre</th>
            </tr>
        </table>
    </body>
</html>

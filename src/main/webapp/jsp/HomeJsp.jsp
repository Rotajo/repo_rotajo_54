<%-- 
    Document   : HomeJsp
    Created on : 16 mai 2016, 16:19:53
    Author     : Jordan
--%>

<%@page import="lo54.projetlo54.core.repository.CourseDao"%>
<%@page import="lo54.projetlo54.core.repository.CourseSessionDao"%>
<%@page import="lo54.projetlo54.core.repository.ClientDao"%>
<%@page import="lo54.projetlo54.core.entity.Client"%>
<%@page import="lo54.projetlo54.core.entity.CourseSession"%>
<%@page import="lo54.projetlo54.core.repository.LocationDao"%>
<%@page import="lo54.projetlo54.core.entity.Location"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.util.List"
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
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    </head>
    <body>
        <center><h1>Affichage global</h1></center>
        
        <%
        List<Course> listCourse = new CourseDao().recupererTout();
        List<Location> listLocation = new LocationDao().recupererTout();
        List<CourseSession> listCourseSession = new CourseSessionDao().recupererTout();
        List<Client> listClient = new ClientDao().recupererTout();    
        %>
    
        <c:forEach items="${listCourse}" var="course">
            <c:out value="<h1>${course.code} </h1>"></c:out>
        </c:forEach>
        
        <table>
            <tr>
                <th>Code UV</th>
                <th>Titre</th>
            </tr>
        </table>
    </body>
</html>

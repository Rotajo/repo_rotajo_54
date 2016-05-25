<%-- 
    Document   : filtre
    Created on : May 20, 2016, 6:30:41 PM
    Author     : Syntiche
--%>

<%@page import="lo54.projetlo54.core.repository.LocationDao"%>
<%@page import="lo54.projetlo54.core.entity.Location"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chercher une UV</title>
        <link rel='stylesheet' href='CSS/style.css' type='text/css' media='screen' />
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    </head>
    <body>
        
        <div class="title"> <h1>Recherche liste des formations</h1></div>
        
        <%
        List<Location> location = new LocationDao().recupererTout();
        request.setAttribute("location", location);
        %>
        <div class="main_content">
        <form method='POST' action='../ProjetLO54/search'>
            <p><label>Par titre</label> : <input type='text' name='title'/></p>
            <p><label>Par date: (jj mm aaaa)</label> : 
            <input type='text' name='day' size="3"/>
            &nbsp;<input type='text' name='month' size="3"/>
            &nbsp;<input type='text' name='year' size="4"/>
            </p>
            <p><label>Par lieu</label> : <select name='location'>
                    <option value="0"></option> 
                <c:forEach items="${location}" var="location">
                    <option value="${location.idLocation}"><c:out value="${location.city}" /></option>
                </c:forEach>
            </select>
            </p>
            <input type='submit' value='Valider'/>
        </form>
        </div>
    </body>
</html>

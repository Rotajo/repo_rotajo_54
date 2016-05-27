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
        <div class="title">
            <a href="index.html">
                <img class="image" id="head_logo" src="UTBM_Logo.jpg" alt="UTBM Logo"/>
            </a>
            <h1>Inscription aux UV en ligne</h1>
            <h3>PROJET LO54 </h3>            
        </div>
        
        <div class='navigation'>
            <ul class='navigation'>
                <li class='navigation'><a href='../ProjetLO54/home'>Accéder aux tables</a></li>
                <li class='navigation'><a href='../ProjetLO54/form'>Inscription</a></li>
                <li class='navigation'><a href='search.jsp'>Rechercher</a></li>
            </ul>
        </div>
        
        <div class='main_content'>
        <h2>Recherche liste des formations</h2>
        
        <%
        List<Location> location = new LocationDao().recupererTout();
        request.setAttribute("location", location);
        %>
        
        <form method='POST' action='../ProjetLO54/search'>
            <table>
                <tr>
                    <td>Par titre</td>
                    <td><input type='text' name='title' autofocus/></td>
                </tr>
                <tr>
                    <td>Par date (jj mm aaaa)</td>
                    <td><input type='text' name='day' size="3" maxlength="2" placeholder="JJ"/>
                        &nbsp;<input type='text' name='month' size="1" maxlength="2" placeholder="MM"/>
                        &nbsp;<input type='text' name='year' size="3" maxlength="4" placeholder="AAAA"/>
                    </td>
                </tr>
                <tr>
                    <td>Par lieu</td>
                    <td>
                        <select name='location'>
                            <option value="0"></option> 
                            <c:forEach items="${location}" var="location">
                                <option value="${location.idLocation}"><c:out value="${location.city}" /></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <p style="text-align:center"><input type='submit' value='Valider'/></p>
        </form>
        </div>
    </body>
</html>

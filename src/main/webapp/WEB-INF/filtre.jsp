<%-- 
    Document   : filtre
    Created on : May 20, 2016, 6:30:41 PM
    Author     : Syntiche
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Recherche liste des formations</h1>
        
        <form method='GET' action='../ProjetLO54/session'>
            <p><label>Par titre</label> : <input type='text' name='title'/></p>
            <p><label>Par date</label> : <input type='text' name='date'/></p>
            <p><label>Par lieu</label> : <select name='location'>
                <c:forEach items="${location}" var="location">
                    <option value="${location.idLocation}"><c:out value="${location.city}" /></option>
                </c:forEach>
            </select>
            </p>
            <input type='submit' value='Valider'/>
        </form>
    </body>
</html>

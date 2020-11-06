<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import ="no.hvl.dat108.UserDAO" %>
<%@ page import ="no.hvl.dat108.User" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Participants-list</title>
</head>
<body>
	<h2>Participants-list</h2>
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th>Gender</th>
			<th align="left">Name</th>
			<th align="left">Phone number</th>
		</tr>
		
        <c:forEach items="${list}" var="i">
            <c:choose>
                <c:when test="${i.phone == user.phone}">
                    <tr bgcolor="#aaffaa">
                        <td align="center">${i.gender == "MALE" ? "&#9794;" : "&#9792;"}</td>
                        <td>${i.firstname} ${i.lastname}</td>
                        <td>${i.phone}</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr bgcolor="#ffffff">
                        <td align="center">${i.gender == "MALE" ? "&#9794;" : "&#9792;"}</td>
                        <td>${i.firstname} ${i.lastname}</td>
                        <td>${i.phone}</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </table>

			<form action="ParticipantListServlet" method="post" class="pure-form pure-form-aligned">
	<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Log out</button>
			</div>
	</form>
</body>
</html>
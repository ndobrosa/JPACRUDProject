<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NBA Warm Welcome</title>
</head>
<body>

<%-- 	<c:if test=${playerDeleted }=='true'>
   	 	<p>Player Deleted</p>
	</c:if> --%>
	
	<c:set var="playerDeleted" value="${playerDeleted }"/>
	<c:if test="${playerDeleted == true}">
 	<i><h3><c:out value="Player successfully deleted"/></h3></i>
	</c:if>
	
	
	<form action="getPlayer.do" method="GET">
		<input type="number" name="pid" required/> <input type="submit"
			value="Find Player by ID" />
	</form>
	<br>
	<form action="getAllPlayers.do" method="GET">
		<input type="submit"
			value="Find All Players" />
	</form>
	<br>
		<form action="startPlayerCreation.do" method="GET">
		<input type="submit"
			value="Add a Player" />
	</form>


</body>
</html>
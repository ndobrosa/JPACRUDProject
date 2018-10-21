<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:choose>
	
	<c:when test="${not empty player }">
		<h3>Edit Player</h3>
	<form action="confirmedit.do" method="POST">
		<label for="first_name">First Name: </label>
		<input type="text" value="${player.firstName }" name="first_name" required/><br>
		
		<label for="last_name">Last Name: </label>
		<input type="text" value="${player.lastName }" name="last_name" required/><br>
		
		<label for="position">Position:</label>
		<input type="text" value="${player.position }" name="position"/><br>
		
		<label for="age">Age:</label>
		<input type="number" value="${player.age }" name="age" required/><br>
		
		<label for="team">Team:</label>
		<input type="text" value="${player.team}" name="team"/><br>
		
		<label for="nationality">Nationality:</label>
		<input type="text" value="${player.nationality }" name="nationality" required/><br>
		
		<input type="hidden" value="${player.id }" name="pid" />
		
		<input type="submit" value="Edit Player" />
	</form>
	</c:when>
	
	
	<c:otherwise>
		<h3>Create Player</h3>
		<form action="newplayer.do" method="POST">
		<label for="first_name">First Name:</label>
		<input type="text" name="first_name" required/><br>
		
		<label for="last_name">Last Name:</label>
		<input type="text" name="last_name" required/><br>
		
		<label for="position">Position:</label>
		<input type="text" name="position"/><br>
		
		<label for="age">Age:</label>
		<input type="number" name="age" required/><br>
		
		<label for="team">Team:</label>
		<input type="text" name="team"/><br>
		
		<label for="nationality">Nationality:</label>
		<input type="text" name="nationality" required/><br>
		
		<input type="submit" value="Add New Player" />
	</form>
	</c:otherwise>
	</c:choose>

</body>
</html>
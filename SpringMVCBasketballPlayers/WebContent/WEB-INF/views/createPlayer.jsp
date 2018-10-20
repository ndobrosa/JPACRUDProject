<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
</body>
</html>
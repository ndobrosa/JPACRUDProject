<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NBA Warm Welcome</title>
</head>
<body>
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
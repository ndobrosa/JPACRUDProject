<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Result</title>
<link rel="stylesheet" href="css/customHeader.css">
</head>
<body>
<center>

	<div class="topnav">
		<a class="home.do" href="home.do">Home</a>&emsp; <a
			href="getAllPlayers.do">Player List</a>&emsp; <a
			href="startPlayerCreation.do">Create a Player</a>
		<!--  <a href="#about">About</a> -->
	</div>
	<br>
	<c:choose>




		<c:when test="${not empty player }">
			<h2>${player.firstName }&nbsp; ${player.lastName }</h2>
			<p>Team: ${player.team }</p>
			<p>Age: ${player.age }</p>
			<p>Position: ${player.position }</p>
			<p>Nationality: ${player.nationality }</p>

			</form>
			<br>
			<form action="editPlayer.do" method="GET">
				<input type="submit" value="Edit player" /> <input type="hidden"
					value=${player.id } name="pid" />
			</form>

			</form>
			<br>
			<form action="deletePlayer.do" method="POST">
				<input type="submit" value="Delete player" /> <input type="hidden"
					value=${player.id } name="pid" />
			</form>
		</c:when>




		<c:when test="${not empty players }">

			<c:forEach items="${players }" var="p">
				<ul>
					<a href="getPlayer.do?pid=${p.id }">${p.firstName }
						${p.lastName }</a>
					</form>

					<form action="editPlayer.do" method="GET">
						<input type="submit" value="Edit player" /> <input type="hidden"
							value=${p.id } name="pid" />
					</form>

					<form action="deletePlayer.do" method="POST">
						<input type="submit" value="Delete player" /> <input
							type="hidden" value=${p.id } name="pid" />
					</form>

					<br>
				</ul>
				<%-- <h3>More Options</h3>
				<form action="editFilm.do" method="GET">
					<input type="hidden" name="id" value="${f.id }" /> <input
						type="submit" value="Edit Film" />
				</form>
				<br>
				<form action="deleteFilm.do" method="GET">
					<input type="hidden" name="id" value="${f.id }" /> <input
						type="submit" value="Delete Film" />
				</form>
				<br> --%>
				<hr>
			</c:forEach>
		</c:when>

		<c:otherwise>
			<h1>
				Sorry, but... <br> Your Request Failed Miserably...
			</h1>
		</c:otherwise>






	</c:choose>
	</center>
</body>
</html>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.Date"%>
<%@page import="Fetching.ContentFetch"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Silent Scribbles</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>
	<div class="Content">
		<div class="Card">
			<form action="Redirected" method="post">
				<label for="dropdown" id="LABEL">Choose an option:</label> <select
					class="options" name="option" id="dropdown"
					onchange="toggleInput()">
					<option id="Option" value="">--Select--</option>
					<option id="Option" value="option1">Single Day</option>
					<option id="Option" value="option2">Complete</option>
				</select>

				<div id="inputContainer">
					<label for="uderInput" id="LABEL">Enter the Date</label> <input
						name="Date" type="text" id="userInput" placeholder="Enter text...">
				</div>
				<button class="findbtn" type="submit">Find</button>
			</form>
		<script>
			function toggleInput() {
				var dropdown = document.getElementById("dropdown");
				var inputContainer = document.getElementById("inputContainer");
				inputContainer.style.display = "none";
				if (dropdown.value === "option1") {
					inputContainer.style.display = "block";
				} else {
					inputContainer.style.display = "none";
				}
			}
		</script>
</body>
</html>

<%@page import="Fetching.Encryption"%>
<%@page import="java.sql.ResultSet"%>
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
	<div class="ContentFetch">
		<%
		String text = "";
		String op = request.getParameter("option");
		//out.println(op.equals("option1"));
		if (op != null && op.equals("option1")) {
			String dt = request.getParameter("Date");
			SimpleDateFormat frmt = new SimpleDateFormat("yyyy-MM-dd");
			Date dtfinal = null;
			try {
				java.util.Date dtt = frmt.parse(dt);
				dtfinal = new Date(dtt.getTime());
			} catch (Exception e) {
				e.printStackTrace();
			}
			ContentFetch fetch = new ContentFetch();
			text = fetch.singleDay(dtfinal);
		%>
		<div class="Card1">
			<div class="">
				<div class="Container">
					<%
					out.println(text);
					%>
				</div>
			</div>
		</div>
		<%
		} else if (op != null && op.equals("option2")) {
		ContentFetch fetch = new ContentFetch();
		ResultSet dt = fetch.completeData();
		%>
		<div class="Card1">
			<div class="Container">
				<%
				Encryption encrypt=new Encryption();
				while (dt.next()) {
					System.out.println();
					int key=dt.getInt(3);
					text = dt.getString(2);// Fetch text column
					text=encrypt.decryption(key, text);
					String date = dt.getDate(1).toString(); 
					System.out.println(date);
					System.out.println(text);
					// Fetch date column
				%>
				<div class="entry">
					<p class="date"><%=date%></p>
					<p class="text"><%=text%></p>
				</div>
				<hr>
				<!-- Horizontal line for separation -->
				<%
				}
				}
				%>
			</div>
		</div>

	</div>
</body>
</html>

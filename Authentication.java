import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServlet;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
public class Authentication extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String password=request.getParameter("Password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String Query="select password from passcode";
			Statement stmt=con.createStatement();
			ResultSet set=stmt.executeQuery(Query);
			String password1="";
			while(set.next()) {
				password1=set.getString(1);
				break;
			}
			if(password.equals(password1)) {
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}
			else {
				out.println("<h3>You are unauthorized to access Devansh's Personal Space</h3>");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}


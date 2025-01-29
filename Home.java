package Fetching;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
public class Home extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			response.setContentType("text/html");
			String choice=request.getParameter("Page");
			if(choice.equals("Fetch")) {
				RequestDispatcher rd=request.getRequestDispatcher("Fetch.jsp");
				rd.forward(request, response);
			}
			else if(choice.equals("Write")) {
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.forward(request, response);
			}
	}

}

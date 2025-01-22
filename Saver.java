import java.io.PrintWriter;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServlet;
import java.sql.*;
import java.util.Random;
public class Saver extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String text=request.getParameter("thoughts");
		String dt=request.getParameter("date");
		Random rand = new Random();
        int randomNumber = rand.nextInt(10) + 1;
        Encryption excrypt=new Encryption();
        text=excrypt.encrytion(randomNumber, text);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String query="insert into diary(datedOn,Text, encryptKey) values(?,?,?)";
			Date date=new Date(System.currentTimeMillis());
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setDate(1, date);
			pstmt.setString(2, text);
			pstmt.setInt(3, randomNumber);
			pstmt.executeUpdate();
			out.println(text);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

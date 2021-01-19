import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PortfolioServlet", urlPatterns = "/portfolio")
public class PortfolioServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String content = "<h1>My Awesome Portfolio</h1>";
		content += "<p>welcome to my page!</p>";
		content += "<a href='/resume'>My Resume</a>";

		PrintWriter out = resp.getWriter();
		out.println(content);


	}
}

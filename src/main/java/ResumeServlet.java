import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResumeServlet", urlPatterns = "/resume")
public class ResumeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		String content = "<h1>My Resume </h1>";
		content += "<a href='https://github.com/'>My GitHub Profile</a><br>";
		content += "<a href='/portfolio'>My Portfolio</a>";

		PrintWriter out = resp.getWriter();
		out.println(content);

	}
}

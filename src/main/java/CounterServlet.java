import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "CounterServlet", urlPatterns = "/counter")
public class CounterServlet extends HttpServlet{
   private int counter = 0;

   @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
       resp.setContentType("text/html");
       String reset = req.getParameter("reset");

       PrintWriter out = resp.getWriter();

       if(reset != null){
           counter = 0;
       }
      counter += 1;
      resp.getWriter().println("<h1>The count is " + counter + ".<h1>");
  }
}

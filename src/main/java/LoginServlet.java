import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = (username.equals("admin") || username.equals("user") ) && password.equals("password");

        HttpSession session = request.getSession(); //gets current session

        if (validAttempt && username.equals("admin")) {
            // Admin Path - the person who logged in is an admin
            session.setAttribute("isAdmin", true);
            response.sendRedirect("/admin"); //servlet <-- url pattern

        } else if(validAttempt && username.equals("user")){
            //User path -- regular user logged in w/ a username of "user"
            session.setAttribute("isAdmin", false);
            response.sendRedirect("/profile");

        }
        else {
            response.sendRedirect("/login");
        }
    }
}
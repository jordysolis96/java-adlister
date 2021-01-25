import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ViewAdminDashboardServlet", urlPatterns = "/admin")
public class ViewAdminDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(); //get current session

        boolean isAdmin = (boolean) session.getAttribute("isAdmin");
        if(isAdmin == false){
            // user path
            resp.sendRedirect("/profile");
            return;
        }

        req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req, resp);
    }
}

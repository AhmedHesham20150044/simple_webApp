import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ahmed_Hesham
 */
@WebServlet(urlPatterns = {"/backCode"})
public class backCode extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ID = Integer.parseInt(request.getParameter("id"));
        
        Student sd = conn.getdata(ID);
        float newGPA = sd.GPA + (sd.GPA * (float)0.05) ;
        conn.updateID(ID, newGPA);
       HttpSession s = request.getSession();
       s.setAttribute("ID", sd.ID);
       s.setAttribute("name", sd.name);
       s.setAttribute("address", sd.address);
       s.setAttribute("oldGPA", sd.GPA);
       s.setAttribute("newGPA", newGPA);
        response.sendRedirect("result.jsp");
    }

}








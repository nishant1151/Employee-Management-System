import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/delete")
public class Delete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try{
        HttpSession session=req.getSession(false);
        Connection connection =(Connection) session.getAttribute("connection");
        PreparedStatement preparedStatement= (PreparedStatement) session.getAttribute("preparedStatement");
        preparedStatement=connection.prepareStatement("delete emp where empid=?");
        preparedStatement.setInt(1,Integer.parseInt(req.getParameter("eid")));
        preparedStatement.execute();
        resp.sendRedirect("/JSP/selection.html");
    }catch (SQLException e){
           e.printStackTrace();
       }
    }
}

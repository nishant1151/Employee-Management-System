import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;

@WebServlet("/insert")

public class InsertData extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try{
           HttpSession session=req.getSession(false);
           Connection connection =(Connection) session.getAttribute("connection");
        PreparedStatement preparedStatement= (PreparedStatement) session.getAttribute("preparedStatement");
              preparedStatement =connection.prepareStatement("insert into emp values(?,?,?,?)");
        preparedStatement.setInt(1,Integer.parseInt(req.getParameter("id")));
           preparedStatement.setString(2,req.getParameter("name"));
           preparedStatement.setString(3,req.getParameter("email"));
           preparedStatement.setInt(4,Integer.parseInt(req.getParameter("salary")));
           preparedStatement.execute();
           resp.sendRedirect("/JSP/selection.html");

           }catch (SQLException e){
           e.printStackTrace();
       }
    }
}

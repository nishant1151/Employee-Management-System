import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;

@WebServlet("/employee")
public class EmployeeDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession(false);
        try{
            if(session!=null){

        Connection connection =(Connection) session.getAttribute("connection");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from emp");
        ResultSet resultSet = preparedStatement.executeQuery();




            session.setAttribute("resultset",resultSet);
            resp.sendRedirect("/JSP/employeetable.jsp");


    }
            else{
                resp.sendRedirect("/jsp/index.html");
            }
        }
    catch ( SQLException e){
            e.printStackTrace();
    }}

}

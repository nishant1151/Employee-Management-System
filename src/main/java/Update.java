import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

@WebServlet("/update")
public class Update extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       try {
           HttpSession session= req.getSession(false);


        Connection connection= (Connection) session.getAttribute("connection");
        PreparedStatement preparedStatement= (PreparedStatement) session.getAttribute("preparedStatement");
        ResultSet resultSet= (ResultSet) session.getAttribute("resultSet");
        preparedStatement=connection.prepareStatement("select * from emp where empid=? ");
        preparedStatement.setInt(1,Integer.parseInt(req.getParameter("eid")));
        resultSet= preparedStatement.executeQuery();
        session.setAttribute("res",resultSet);
        resp.sendRedirect("/JSP/updateEmployee.jsp");

    }catch (SQLException e){
           e.printStackTrace();
       }
    }
}

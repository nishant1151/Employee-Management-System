import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;

@WebServlet("/validate")
public class ValidateServelet extends HttpServlet {
    private Connection connection;


    public void init () {
        try {
            ServletContext servletContext=getServletContext();
            Class.forName(servletContext.getInitParameter("className"));
            this.connection= DriverManager.getConnection(servletContext.getInitParameter("connectionName"),servletContext.getInitParameter("username"),servletContext.getInitParameter("password"));

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }


    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            boolean flag = false;


            PreparedStatement preparedStatement = connection.prepareStatement("select * from admin1");
            ResultSet resultSet = preparedStatement.executeQuery();
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            HttpSession session=req.getSession(true);
            session.setAttribute("resultSet",resultSet);
            session.setAttribute("preparedStatement",preparedStatement);
            session.setAttribute("connection",connection);
            while (resultSet.next()) {
                if (resultSet.getString(1).equals(username) && resultSet.getString(2).equals(password)) {

                   session.setAttribute("username",username);
                   session.setAttribute("password",password);


                    flag = true;
                    break;
                }
            }

            if (flag) {

                resp.sendRedirect("/JSP/selection.html");
            }
        }

        catch(SQLException e){
            throw new RuntimeException(e);
        }

    }


    public Connection getConnection(){
        System.out.println(this.connection);
        return this.connection;
    }





    }


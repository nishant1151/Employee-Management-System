<html>
<head>
<style>
                #table{
                                              left:550px;
                                              position:absolute;
                                              }
                                             s
                                       #insertdiv{
                                                  z-index: 5;
                                                  position: absolute;

                                                  height: 150px;
                                                  width: 150px;
                                              }
                                              #insertform{
                                                    top: 25px;
                                                    position: relative;
                                                    left: 25px;
                                                   }
                                                  s
                                                  s
                                                    #updatediv{
                                                  z-index: 6;
                                                  position: absolute;

                                                  height: 150px;
                                                  width: 150px;
                                              }
                                              #updateform{
                                                    top: 25px;
                                                    position: relative;
                                                    left: 25px;
                                                   }

                                                   #deletediv{
                                                  z-index: 6;
                                                  position: absolute;

                                                  height: 150px;
                                                  width: 150px;
                                              }
                                              #deleteform{
                                                    top: 25px;
                                                    position: relative;
                                                    left: 25px;
                                                   }
                        </style>
</head>

<body>
<%@ page import="java.sql.ResultSet" %>
<table cellpadding="1" id="table" cellspacing="0" border="1">
                            <tr>
                                <th>EID</th>
                                <th>First Name</th>
                                <th>Email</th>
                                <th>Salary</th>
                            </tr>
                            <%

                             ResultSet res= (ResultSet) session.getAttribute("resultset");
                              while(res.next()){
                               %>

                            <tr>
                             <td><%=res.getInt(1)%></td>
                             <td><%=res.getString(2)%></td>
                             <td><%=res.getString(3)%></td>
                             <td><%=res.getInt(4)%></td>
                             </tr>
                             <%
                              }
                            %>

                            <form action="/JSP/logout" method="get">
                            <input type="submit" value="logout">
                            </form>
</body>

</html>


<html>
<head></head>
<body>
<%@ page import="java.sql.ResultSet" %>
<% ResultSet resultset=(ResultSet) session.getAttribute("res");
while(resultset.next()){

%>
<form action="/JSP/" method="get">
<input type="text" placeholder="<%=resultset.getString(2)%>">
<input type="text" placeholder="<%=resultset.getString(3)%>">
<input type="text" placeholder="<%=resultset.getInt(4)%>">
</form>
<%}%>
</body>
</html>
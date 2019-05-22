<%--
  Created by IntelliJ IDEA.
  User: korni
  Date: 22.05.2019
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <jsp:useBean id="greeting" class="com.github.kornikkk.pocserver.Greeting"/>
  <h3>${greeting.hello}</h3>
  </body>
</html>

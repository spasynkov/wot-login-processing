<%@ page import="net.ukrtel.ddns.ff.tanki.entities.WotLoginResponse" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>

      <title>Страница входа</title>
  </head>

  <body>
    <%
        if (request.getAttribute("wotLoginResponse") != null) {
            WotLoginResponse wotLoginResponse = (WotLoginResponse) request.getAttribute("wotLoginResponse");

            out.println("<H1>Привет, " + wotLoginResponse.getNickname() + "!</H1>");
            out.println("<div>");
            out.println("\t<p>Твой id аккаунта: <i>" + wotLoginResponse.getAccountId() + "</i></p>");
            out.println("\t<p>Мы получили такой токен доступа: <i>" + wotLoginResponse.getToken() + "</i></p>");
            out.println("\t<p>Который действует до: <i>" + wotLoginResponse.getExpiresAt().toString() + "</i></p>");
            out.println("</div>");
            out.println("<a href=\"/info\">Инфо</a>");
        } else {
            out.println("<p style=\"color: red;\">Возникла какая-то ошибка. Извините</p>");
        }
    %>
    <a href="/logout">Выйти</a>
  </body>
</html>
<%@ page import="net.ukrtel.ddns.ff.tanki.WotResponse" %>
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
        if (request.getAttribute("wotResponse") != null) {
            WotResponse wotResponse = (WotResponse) request.getAttribute("wotResponse");

            out.println("<H1>Привет, " + wotResponse.getNickname() + "!</H1>");
            out.println("<div>");
            out.println("\t<p>Твой id аккаунта: <i>" + wotResponse.getAccountId() + "</i></p>");
            out.println("\t<p>Мы получили такой токен доступа: <i>" + wotResponse.getToken() + "</i></p>");
            out.println("\t<p>Который действует до: <i>" + wotResponse.getExpiresAt().toString() + "</i></p>");
            out.println("</div>");
            out.println("<a href=\"https://api.worldoftanks.ru/wot/account/info/?application_id=4e67660611202f132151e26f8cce5a27&access_token=" + wotResponse.getToken() + "&account_id=" + wotResponse.getAccountId() + "\">инфо</a>");
        } else {
            out.println("<p style=\"color: red;\">Возникла какая-то ошибка. Извините</p>");
        }
    %>
  </body>
</html>
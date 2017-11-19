<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Информация</title>

    <style>
        table {
            border-collapse: collapse;
        }

        table, tr, th, td {
            border: 1px solid gray;
            padding: 5px;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>Параметр</th>
        <th>Значение</th>
    </tr>
    <%
        Object attribute = request.getAttribute("props");
        if (attribute != null && attribute instanceof Map) {
            Map<String, String> properties = (Map<String, String>) attribute;
            for (Map.Entry<String, String> entry : properties.entrySet()) {
                out.println("<tr>");
                out.println("\t<td>" + entry.getKey() + "</td>");
                out.println("\t<td>" + entry.getValue() + "</td>");
                out.println("</tr>");
            }
        }
    %>
</table>

<a href="/logout">Выйти</a>
</body>
</html>

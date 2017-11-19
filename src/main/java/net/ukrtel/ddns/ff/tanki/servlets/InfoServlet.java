package net.ukrtel.ddns.ff.tanki.servlets;

import net.ukrtel.ddns.ff.tanki.utils.CookiesProcessing;
import net.ukrtel.ddns.ff.tanki.utils.HttpRequestsSender;
import net.ukrtel.ddns.ff.tanki.utils.Parser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static net.ukrtel.ddns.ff.tanki.utils.CookiesProcessing.getCookie;

public class InfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // базовая строка для получения информации с сервера
        String urlString = "https://api.worldoftanks.ru/wot/account/info/";

        // вытягиваем данные о пользователе из его куки
        String userId = getCookie(req, CookiesProcessing.CookieName.WOT_USER_ID),
                token = getCookie(req, CookiesProcessing.CookieName.WOT_TOKEN);

        // подготавливаем и отправляем POST запрос на получение информации о пользователе
        Map<String, String> urlParameters = new LinkedHashMap<>();
        urlParameters.put("application_id", "4e67660611202f132151e26f8cce5a27");
        urlParameters.put("access_token", token);
        urlParameters.put("account_id", userId);
        String jsonResponse = HttpRequestsSender.sendPost(urlString, urlParameters);
        // System.out.println(jsonResponse);

        // создаем парсер для разбора json-a (смотри описание класса, там можно его улучшить)
        Parser parser = new Parser(jsonResponse);

        // считываем данные из разобранного json-а
        Map<String, String> properties = new LinkedHashMap<>();     // храним в порядке добавления
        properties.put("nickname", parser.getByName("nickname"));
        properties.put("logout_at", parser.getByName("logout_at"));
        properties.put("gold", parser.getByName("gold"));
        properties.put(userId, parser.getByName(userId));                                   // значение поля - объект, а не конкретное значение
        properties.put("no-such-field", parser.getByName("no-such-field"));     // заведомо несуществующее поле
        // ... другие свойства тут ...

        req.setAttribute("props", properties);  // кладем результаты как атрибут чтоб передать во вьюху

        req.getRequestDispatcher("WEB-INF/views/info.jsp").forward(req, resp);  // передаем во вьюху
    }
}

package net.ukrtel.ddns.ff.tanki.servlets;

import net.ukrtel.ddns.ff.tanki.utils.CookiesProcessing;
import net.ukrtel.ddns.ff.tanki.utils.HttpRequestsSender;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static net.ukrtel.ddns.ff.tanki.utils.CookiesProcessing.CookieName;
import static net.ukrtel.ddns.ff.tanki.utils.CookiesProcessing.getCookie;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // удаляем токен с сервера WoT, отправив соответстующий запрос
        Map<String, String> parameters = new LinkedHashMap<>();
        parameters.put("application_id", "4e67660611202f132151e26f8cce5a27");
        parameters.put("access_token", getCookie(req, CookieName.WOT_TOKEN));
        HttpRequestsSender.sendPost("https://api.worldoftanks.ru/wot/auth/logout/", parameters);

        // удаляем все куки
        CookiesProcessing.killCookies(req, resp);

        // редиректим на главную
        // взял отсюда: https://stackoverflow.com/questions/27022741/redirecting-servlet-to-another-html-page
        resp.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        resp.setHeader("Location", "/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);   // перестраховочка, вдруг кто-то по POST-у попробует разлогиниться
    }
}

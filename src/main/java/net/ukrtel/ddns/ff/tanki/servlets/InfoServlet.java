package net.ukrtel.ddns.ff.tanki.servlets;

import com.google.gson.Gson;
import net.ukrtel.ddns.ff.tanki.entities.account.User;
import net.ukrtel.ddns.ff.tanki.entities.account.UserDetails;
import net.ukrtel.ddns.ff.tanki.entities.account.WotAccountInfoResponse;
import net.ukrtel.ddns.ff.tanki.entities.account.statistics.TeamAndHistoricalStatistic;
import net.ukrtel.ddns.ff.tanki.entities.error.WotErrorResponse;
import net.ukrtel.ddns.ff.tanki.utils.CookiesProcessing;
import net.ukrtel.ddns.ff.tanki.utils.HttpRequestsSender;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
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

        Gson gson = new Gson();
        if (jsonResponse.startsWith("{\"status\":\"ok\"")) {
            // разюбираем данные из json-а
            WotAccountInfoResponse accountInfo = gson.fromJson(jsonResponse, WotAccountInfoResponse.class);

            // выбираем нужные данные
            User user = accountInfo.getUsers().get(0);
            UserDetails details = user.getDetails();
            TeamAndHistoricalStatistic stats = (TeamAndHistoricalStatistic) details.getStats().getStatisticsList().get(1);

            Map<String, String> properties = new LinkedHashMap<>();     // храним в порядке добавления
            properties.put("ID пользователя", user.getId());
            properties.put("Ник", details.getNickname());
            properties.put("Аккаунт создан", new Date(details.getCreated_at() * 1000).toString());
            properties.put("Место в рейтинге", String.valueOf(details.getGlobal_rating()));
            properties.put("Последний бой", new Date(details.getLast_battle_time() * 1000).toString());
            properties.put("Последний раз заходил(а)", new Date(details.getLogout_at() * 1000).toString());
            properties.put("Золото", details.getPrivateData().getGold().toString());
            properties.put("Свободый опыт", details.getPrivateData().getFree_xp().toString());
            properties.put("Выиграно боев", String.valueOf(stats.getWins()));
            properties.put("Слито боев", String.valueOf(stats.getLosses()));
            properties.put("Ничьи", String.valueOf(stats.getDraws()));
            properties.put("Всего сражений", String.valueOf(stats.getBattles()));
            properties.put("Виживаний", String.valueOf(stats.getSurvived_battles()));
            properties.put("Сделано выстрелов", String.valueOf(stats.getShots()));
            properties.put("Попаданий", String.valueOf(stats.getHits()));
            properties.put("Убито вражеских танков", String.valueOf(stats.getFrags()));
            // ... другие свойства тут ...

            req.setAttribute("props", properties);  // кладем результаты как атрибут чтоб передать во вьюху
        } else {    // если в ответ пришла ошибка
            WotErrorResponse error = gson.fromJson(jsonResponse, WotErrorResponse.class);
            req.setAttribute("error", error);
        }

        req.getRequestDispatcher("WEB-INF/views/info.jsp").forward(req, resp);  // передаем во вьюху
    }
}

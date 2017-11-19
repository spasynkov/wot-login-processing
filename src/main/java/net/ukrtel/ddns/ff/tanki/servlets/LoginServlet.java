package net.ukrtel.ddns.ff.tanki.servlets;

import net.ukrtel.ddns.ff.tanki.entities.WotLoginResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static net.ukrtel.ddns.ff.tanki.utils.CookiesProcessing.*;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getParameterMap().isEmpty()) {     // если есть параметры
            // сначала проверяем статус
            String status = req.getParameter("status");
            if (status != null && !status.isEmpty()) {
                if ("ok".equalsIgnoreCase(status)) {
                    WotLoginResponse wotLoginResponse = parseParameters(req);     // парсим параметры
                    createCookies(resp, wotLoginResponse);                   // создаем куки

                    // избавляемся от параметров в строке, повторно загружая эту же страничку
                    resp.sendRedirect("/login");
                    return;
                } else if ("error".equalsIgnoreCase(status)) {
                    processingError(req);                               // обрабатываем ошибки
                    // проскакиваем блок else и выскакиваем во вьюху, строка с ошибкой будет там видна
                }
            }
        } else {    // если нет параметров
            // тогда вытаскиваем данные из куки
            String token = getCookie(req, CookieName.WOT_TOKEN);
            String nickname = getCookie(req, CookieName.WOT_USERNAME);
            String accountId = getCookie(req, CookieName.WOT_USER_ID);
            String expiresAt = getCookie(req, CookieName.WOT_EXPIRES);

            WotLoginResponse wotLoginResponse = new WotLoginResponse();
            wotLoginResponse.setToken(token);
            wotLoginResponse.setNickname(nickname);
            wotLoginResponse.setAccountId(Long.parseLong(accountId));
            wotLoginResponse.setExpiresAt(new Date(Long.parseLong(expiresAt) * 1000));

            req.setAttribute("wotLoginResponse", wotLoginResponse);
        }
        req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
    }

    private void createCookies(HttpServletResponse resp, WotLoginResponse wotLoginResponse) {
        String domain = "localhost";
        // готовим свойство max time для куки (срок годности), которое равно времени до окончания срока действия токена
        long currentTime = System.currentTimeMillis();
        int maxAge = (int) ((wotLoginResponse.getExpiresAt().getTime() - currentTime) / 1000);    // оно в секуднах, поэтому делим на 1000

        // выпекаем печеньки (куки)
        setCookie(resp,
                CookieName.WOT_USERNAME,
                wotLoginResponse.getNickname(),
                domain,
                maxAge);

        setCookie(resp,
                CookieName.WOT_USER_ID,
                String.valueOf(wotLoginResponse.getAccountId()),
                domain,
                maxAge);

        setCookie(resp,
                CookieName.WOT_TOKEN,
                wotLoginResponse.getToken(),
                domain,
                maxAge);

        setCookie(resp,
                CookieName.WOT_EXPIRES,
                String.valueOf(wotLoginResponse.getExpiresAt().getTime()),   // в куки нельзя хранить символы [ ] ( ) = , " / ? @ : ; поэтому дату будем хранить в милисекундах
                domain,
                maxAge);
    }

    private WotLoginResponse parseParameters(HttpServletRequest req) {
        String status = req.getParameter("status");
        String token = req.getParameter("access_token");
        String nickname = req.getParameter("nickname");
        String accountId = req.getParameter("account_id");
        String expiresAt = req.getParameter("expires_at");      // сервер WoT возвращает время в секеундах с 1970

        return new WotLoginResponse(
                status,
                token,
                nickname,
                Long.parseLong(accountId),
                new Date(Long.parseLong(expiresAt) * 1000));
    }

    private void processingError(HttpServletRequest req) {
        // тут обработка кодов с ошибками:
        // code - message - описание
        // 401 - AUTH_CANCEL - Пользователь отменил авторизацию для приложения
        // 403 - AUTH_EXPIRED - Превышено время ожидания авторизации пользователя
        // 410 - AUTH_ERROR - Ошибка аутентификации
        // детальнее тут: https://developers.wargaming.net/documentation/guide/getting-started/#common-errors
    }
}

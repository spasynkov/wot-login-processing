package net.ukrtel.ddns.ff.tanki;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class LoginProcessing extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String status = req.getParameter("status");
        if (status !=null && !status.isEmpty()) {
            if ("ok".equalsIgnoreCase(status)) {
                WotResponse response = parseParameters(req);
                req.setAttribute("wotResponse", response);
            } else if ("error".equalsIgnoreCase(status)) {
                processingError(req);
            }
        }

        req.getRequestDispatcher("WEB-INF/views/index.jsp").forward(req, resp);
    }

    private WotResponse parseParameters(HttpServletRequest req) {
        String status = req.getParameter("status");
        String token = req.getParameter("access_token");
        String nickname = req.getParameter("nickname");
        String accountId = req.getParameter("account_id");
        String expiresAt = req.getParameter("expires_at");      // in seconds from 1970

        return new WotResponse(
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

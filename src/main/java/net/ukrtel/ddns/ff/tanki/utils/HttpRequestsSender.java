package net.ukrtel.ddns.ff.tanki.utils;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

public class HttpRequestsSender {

    // взял в основном отсюда: https://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/

    public static String sendPost(String urlString, Map<String, String> urlParameters) throws IOException {
        String parameters = collectParameters(urlParameters);

        URL url = new URL(urlString);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        // adding request header
        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        // sending post request
        connection.setDoOutput(true);
        DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
        outputStream.writeBytes(parameters);
        outputStream.flush();
        outputStream.close();

        // выводим в консоль строку с отправленным запросом (удобно, что можно нажать и увидеть реальный json в ответ)
        System.out.println("POST request sent at: " + urlString + "?" + parameters);

        // getting response
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder result = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            result.append(inputLine);
        }
        in.close();

        return result.toString();
    }

    /**
     * Собираем параметры в строку вида:
     * param1=value1&param2=value2
     *
     * @param parameters карта с параметрами
     * @return готовая строка
     */
    private static String collectParameters(Map<String, String> parameters) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            stringBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf("&"));
        return stringBuilder.toString();
    }
}

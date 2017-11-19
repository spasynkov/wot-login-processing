package net.ukrtel.ddns.ff.tanki.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Map;
import java.util.Set;

/**
 * реальный парсинг ответа производится каждый раз при вызове метода getByName()
 * чем больше вызовов getByName() - тем дольше работает))
 * <p>
 * возможно, есть смысл переписать так, чтоб парсилось все за один раз, типа getByName(List<String> names)
 * <p>
 * или парсилось просто один раз при создании, и сразу создало бы объект Map в памяти с парами ключ/значение,
 * из которого брали бы просто нужные пары и передавали их во вьюху
 * <p>
 * но мне лень))
 */
public class Parser {
    private final JsonParser parser;
    private final JsonObject root;

    public Parser(String json) {
        parser = new JsonParser();
        root = parser.parse(json).getAsJsonObject();
    }

    public String getByName(String elementName) {
        JsonElement element = findElement(root, elementName);
        if (element != null) {
            if (element.isJsonPrimitive()) return element.getAsString();
            else return "Failed to get the value (maybe not a primitive)";
        }

        return "No such element found";
    }

    private JsonElement findElement(JsonElement root, String name) {
        // перебираем только составные объекты, игнорируя примитивы (они проверены на шаге раньше)
        if (root.isJsonObject()) {
            JsonObject jsonObject = root.getAsJsonObject();
            Set<Map.Entry<String, JsonElement>> set = jsonObject.entrySet();

            // сначала проходимся по всем элементам на этом уровне
            for (Map.Entry<String, JsonElement> entry : set) {
                if (name.equalsIgnoreCase(entry.getKey())) {
                    return entry.getValue();
                }
            }

            // если дошли до этих строк - значит на этом уровне нет нужного элемента.
            // углубляемся рекурсивно в каждую ветку
            for (Map.Entry<String, JsonElement> entry : set) {
                JsonElement element = findElement(entry.getValue(), name);
                if (element != null) return element;
            }
        }
        return null;
    }
}

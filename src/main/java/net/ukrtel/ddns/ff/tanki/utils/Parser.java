package net.ukrtel.ddns.ff.tanki.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.LinkedHashMap;
import java.util.Map;

public class Parser {
    private final JsonParser parser;
    private JsonObject root;

    private Map<String, String> elements = new LinkedHashMap<>();

    public Parser() {
        parser = new JsonParser();
    }

    public Parser(String jsonString) {
        this();
        root = parser.parse(jsonString).getAsJsonObject();
    }

    public void setJsonString(String jsonString) {
        root = parser.parse(jsonString).getAsJsonObject();
    }

    public String getByName(String elementName) {
        return elements.get(elementName);
    }

    public void parse() {
        parse(root);
    }

    public void parse(String jsonString) {
        setJsonString(jsonString);
        parse();
    }

    private void parse(JsonObject root) {
        JsonObject object = root.getAsJsonObject();

        String key;
        JsonElement value;
        for (Map.Entry<String, JsonElement> entry : object.entrySet()) {
            key = entry.getKey();
            value = entry.getValue();

            if (value.isJsonObject()) {
                put(key, null);
                parse(value.getAsJsonObject());
            } else if (value.isJsonNull()) {
                put(key, null);
            } else {
                put(key, value.getAsString());
            }
        }
    }

    private void put(String key, String value) {
        String previousValue = elements.put(key, value);
        if (previousValue != null) {
            // throw new ParseException("Duplicate element found with name '" + key + "'");
            System.err.println("Duplicate element found with name '" + key + "'");
            elements.put(key, "Duplicate elements found");
        }
    }

    public class ParseException extends RuntimeException {
        private ParseException(String message) {
            super(message);
        }
    }
}

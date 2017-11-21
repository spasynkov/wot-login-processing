package net.ukrtel.ddns.ff.tanki.entities.error;

public class Error {
    private String field;
    private String message;
    private int code;
    private String value;

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Error)) return false;

        Error error = (Error) o;

        if (code != error.code) return false;
        if (field != null ? !field.equals(error.field) : error.field != null) return false;
        if (message != null ? !message.equals(error.message) : error.message != null) return false;
        return value != null ? value.equals(error.value) : error.value == null;
    }

    @Override
    public int hashCode() {
        int result = field != null ? field.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + code;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Error{" +
                "field='" + field + '\'' +
                ", message='" + message + '\'' +
                ", code=" + code +
                ", value='" + value + '\'' +
                '}';
    }
}

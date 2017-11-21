package net.ukrtel.ddns.ff.tanki.entities.error;

public class WotErrorResponse {
    private String status;
    private Error error;

    public String getStatus() {
        return status;
    }

    public Error getError() {
        return error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WotErrorResponse)) return false;

        WotErrorResponse that = (WotErrorResponse) o;

        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        return error != null ? error.equals(that.error) : that.error == null;
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (error != null ? error.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WotErrorResponse{" +
                "status='" + status + '\'' +
                ", error=" + error +
                '}';
    }
}

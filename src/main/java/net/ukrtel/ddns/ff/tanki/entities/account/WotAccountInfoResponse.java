package net.ukrtel.ddns.ff.tanki.entities.account;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WotAccountInfoResponse {
    private String status;
    private Meta meta;
    private Map<String, UserDetails> data;
    private List<User> usersData;

    public String getStatus() {
        return status;
    }

    public Meta getMeta() {
        return meta;
    }

    public List<User> getUsers() {
        if (usersData == null) {
            usersData = data.entrySet().stream()
                    .map(x -> new User(x.getKey(), x.getValue()))
                    .collect(Collectors.toList());
        }
        return usersData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WotAccountInfoResponse)) return false;

        WotAccountInfoResponse that = (WotAccountInfoResponse) o;

        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (meta != null ? !meta.equals(that.meta) : that.meta != null) return false;
        return getUsers() != null ? usersData.equals(that.usersData) : that.usersData == null;
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (meta != null ? meta.hashCode() : 0);
        result = 31 * result + (getUsers() != null ? usersData.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WotAccountInfoResponse{" +
                "status='" + status + '\'' +
                ", meta=" + meta +
                ", usersData=" + getUsers() +
                '}';
    }
}

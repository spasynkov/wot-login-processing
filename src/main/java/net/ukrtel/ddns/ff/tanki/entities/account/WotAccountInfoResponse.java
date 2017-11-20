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

    public void setStatus(String status) {
        this.status = status;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<User> getUsersData() {
        if (usersData == null) {
            usersData = data.entrySet().stream()
                    .map(x -> new User(x.getKey(), x.getValue()))
                    .collect(Collectors.toList());
        }
        return usersData;
    }

    public void setData(Map<String, UserDetails> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WotAccountInfoResponse{" +
                "status='" + status + '\'' +
                ", meta=" + meta +
                ", users=" + usersData +
                '}';
    }
















}

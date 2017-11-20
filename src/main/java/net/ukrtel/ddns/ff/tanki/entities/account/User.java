package net.ukrtel.ddns.ff.tanki.entities.account;

public class User {
    private String id;
    private UserDetails details;

    User(String id, UserDetails details) {
        this.id = id;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserDetails getDetails() {
        return details;
    }

    public void setDetails(UserDetails details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", details=" + details +
                '}';
    }
}

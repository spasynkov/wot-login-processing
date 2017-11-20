package net.ukrtel.ddns.ff.tanki.entities.account;

public class User {
    private String id;
    private UserDetails details;

    public User() {
    }

    User(String id, UserDetails details) {
        this.id = id;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public UserDetails getDetails() {
        return details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        return details != null ? details.equals(user.details) : user.details == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (details != null ? details.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", details=" + details +
                '}';
    }
}

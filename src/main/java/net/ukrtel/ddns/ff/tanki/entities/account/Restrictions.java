package net.ukrtel.ddns.ff.tanki.entities.account;

public class Restrictions {
    private Long chat_ban_time;

    public Long getChat_ban_time() {
        return chat_ban_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restrictions)) return false;

        Restrictions that = (Restrictions) o;

        return chat_ban_time != null ? chat_ban_time.equals(that.chat_ban_time) : that.chat_ban_time == null;
    }

    @Override
    public int hashCode() {
        return chat_ban_time != null ? chat_ban_time.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Restrictions{" +
                "chat_ban_time=" + chat_ban_time +
                '}';
    }
}

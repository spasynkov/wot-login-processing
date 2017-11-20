package net.ukrtel.ddns.ff.tanki.entities.account;

public class Restrictions {
    private Long chat_ban_time;

    public Long getChat_ban_time() {
        return chat_ban_time;
    }

    public void setChat_ban_time(Long chat_ban_time) {
        this.chat_ban_time = chat_ban_time;
    }

    @Override
    public String toString() {
        return "{" +
                "chat_ban_time=" + chat_ban_time +
                '}';
    }
}

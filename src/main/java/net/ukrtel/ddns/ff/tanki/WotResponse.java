package net.ukrtel.ddns.ff.tanki;

import java.util.Date;

public class WotResponse {
    private String status;
    private String token;
    private String nickname;
    private long accountId;
    private Date expiresAt;

    public WotResponse() {
    }

    public WotResponse(String status, String token, String nickname, long accountId, Date expiresAt) {
        this.status = status;
        this.token = token;
        this.nickname = nickname;
        this.accountId = accountId;
        this.expiresAt = expiresAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WotResponse that = (WotResponse) o;

        if (accountId != that.accountId) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        return expiresAt != null ? expiresAt.equals(that.expiresAt) : that.expiresAt == null;
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (int) (accountId ^ (accountId >>> 32));
        result = 31 * result + (expiresAt != null ? expiresAt.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WotResponse{" +
                "status='" + status + '\'' +
                ", token='" + token + '\'' +
                ", nickname='" + nickname + '\'' +
                ", accountId=" + accountId +
                ", expiresAt=" + expiresAt +
                '}';
    }
}

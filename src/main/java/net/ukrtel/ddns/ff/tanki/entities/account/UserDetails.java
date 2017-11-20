package net.ukrtel.ddns.ff.tanki.entities.account;

import com.google.gson.annotations.SerializedName;
import net.ukrtel.ddns.ff.tanki.entities.account.statistics.AbstractStatistic;
import net.ukrtel.ddns.ff.tanki.entities.account.statistics.CompanyAndClanStatistic;
import net.ukrtel.ddns.ff.tanki.entities.account.statistics.StrongholdStatistic;
import net.ukrtel.ddns.ff.tanki.entities.account.statistics.TeamAndHistoricalStatistic;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserDetails {
    private String client_language;
    private Long last_battle_time;
    private Long account_id;
    private Long created_at;
    private Long updated_at;
    @SerializedName("private")                  // java keyword
    private PrivateData privateData;
    private int global_rating;
    private Long clan_id;
    private Map<String, Object> statistics;     // don't delete. filled by gson
    private TotalStats stats;
    private String nickname;
    private Long logout_at;

    public String getClient_language() {
        return client_language;
    }

    public Long getLast_battle_time() {
        return last_battle_time;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public Long getCreated_at() {
        return created_at;
    }

    public Long getUpdated_at() {
        return updated_at;
    }

    public PrivateData getPrivateData() {
        return privateData;
    }

    public int getGlobal_rating() {
        return global_rating;
    }

    public Long getClan_id() {
        return clan_id;
    }

    public TotalStats getStats() {
        if (stats == null) {
            int trees_cut = 0;
            List<AbstractStatistic> statsData = new LinkedList<>();
            List<Frag> frags = new LinkedList<>();

            String key;
            Object value;
            for (Map.Entry<String, Object> entry : statistics.entrySet()) {
                key = entry.getKey();
                value = entry.getValue();
                if ("trees_cut".equalsIgnoreCase(key)) trees_cut = ((Double) value).intValue();
                else if ("frags".equalsIgnoreCase(key)) {
                    frags = ((Map<String, Double>) value).entrySet().stream()
                            .map(x -> new Frag(Integer.valueOf(x.getKey()), x.getValue().intValue()))
                            .collect(Collectors.toList());
                } else {
                    if ("all".equalsIgnoreCase(key)
                            || "team".equalsIgnoreCase(key)
                            || "regular_team".equalsIgnoreCase(key)
                            || "historical".equalsIgnoreCase(key)) {
                        statsData.add(new TeamAndHistoricalStatistic(key, (Map<String, Double>) value));
                    } else if ("stronghold_skirmish".equalsIgnoreCase(key)
                            || "stronghold_defense".equalsIgnoreCase(key)) {
                        statsData.add(new StrongholdStatistic(key, (Map<String, Double>) value));
                    } else if ("clan".equalsIgnoreCase(key)
                            || "company".equalsIgnoreCase(key)) {
                        statsData.add(new CompanyAndClanStatistic(key, (Map<String, Double>) value));
                    } else {
                        throw new RuntimeException("Can't recognize stats with name '" + key + "'!");
                    }
                }
            }

            stats = new TotalStats(trees_cut, statsData, frags);
        }
        return stats;
    }

    public String getNickname() {
        return nickname;
    }

    public Long getLogout_at() {
        return logout_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDetails)) return false;

        UserDetails that = (UserDetails) o;

        if (global_rating != that.global_rating) return false;
        if (client_language != null ? !client_language.equals(that.client_language) : that.client_language != null)
            return false;
        if (last_battle_time != null ? !last_battle_time.equals(that.last_battle_time) : that.last_battle_time != null)
            return false;
        if (account_id != null ? !account_id.equals(that.account_id) : that.account_id != null) return false;
        if (created_at != null ? !created_at.equals(that.created_at) : that.created_at != null) return false;
        if (updated_at != null ? !updated_at.equals(that.updated_at) : that.updated_at != null) return false;
        if (privateData != null ? !privateData.equals(that.privateData) : that.privateData != null) return false;
        if (clan_id != null ? !clan_id.equals(that.clan_id) : that.clan_id != null) return false;
        if (getStats() != null ? !stats.equals(that.stats) : that.stats != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        return logout_at != null ? logout_at.equals(that.logout_at) : that.logout_at == null;
    }

    @Override
    public int hashCode() {
        int result = client_language != null ? client_language.hashCode() : 0;
        result = 31 * result + (last_battle_time != null ? last_battle_time.hashCode() : 0);
        result = 31 * result + (account_id != null ? account_id.hashCode() : 0);
        result = 31 * result + (created_at != null ? created_at.hashCode() : 0);
        result = 31 * result + (updated_at != null ? updated_at.hashCode() : 0);
        result = 31 * result + (privateData != null ? privateData.hashCode() : 0);
        result = 31 * result + global_rating;
        result = 31 * result + (clan_id != null ? clan_id.hashCode() : 0);
        result = 31 * result + (getStats() != null ? stats.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (logout_at != null ? logout_at.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "client_language='" + client_language + '\'' +
                ", last_battle_time=" + last_battle_time +
                ", account_id=" + account_id +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", privateData=" + privateData +
                ", global_rating=" + global_rating +
                ", clan_id=" + clan_id +
                ", stats=" + getStats() +
                ", nickname='" + nickname + '\'' +
                ", logout_at=" + logout_at +
                '}';
    }
}

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
    @SerializedName("private")          // java keyword
    private PrivateData privateData;
    private int global_rating;
    private Long clan_id;
    private Map<String, Object> statistics;
    private TotalStats stats;
    private String nickname;
    private Long logout_at;

        /*public void setStatistics(Map<String, Object> statistics) {
            int trees_cut = 0;
            List<Statistics> stats = new LinkedList<>();;
            List<Frag> frags = new LinkedList<>();

            String key;
            Object value;
            for (Map.Entry<String, Object> entry : statistics.entrySet()) {
                key = entry.getKey();
                value = entry.getValue();
                if ("trees_cut".equalsIgnoreCase(key)) trees_cut = (int) value;
                else if ("frags".equalsIgnoreCase(key)) {
                    frags = ((Map<String, Integer>) value).entrySet().stream()
                            .map(x -> new Frag(Integer.valueOf(x.getKey()), x.getValue()))
                            .collect(Collectors.toList());
                } else {
                    stats = ((Map<String, Object>) value).entrySet().stream()
                            .map(x -> new Statistics(x.getKey(), (Map<String, Integer>)x.getValue()))
                            .collect(Collectors.toList());
                }
            }

            this.statistics = new TotalStats(trees_cut, stats, frags);
        }*/

    public String getClient_language() {
        return client_language;
    }

    public void setClient_language(String client_language) {
        this.client_language = client_language;
    }

    public Long getLast_battle_time() {
        return last_battle_time;
    }

    public void setLast_battle_time(Long last_battle_time) {
        this.last_battle_time = last_battle_time;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public Long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Long created_at) {
        this.created_at = created_at;
    }

    public Long getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Long updated_at) {
        this.updated_at = updated_at;
    }

    public PrivateData getPrivateData() {
        return privateData;
    }

    public void setPrivateData(PrivateData privateData) {
        this.privateData = privateData;
    }

    public int getGlobal_rating() {
        return global_rating;
    }

    public void setGlobal_rating(int global_rating) {
        this.global_rating = global_rating;
    }

    public Long getClan_id() {
        return clan_id;
    }

    public void setClan_id(Long clan_id) {
        this.clan_id = clan_id;
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
                    /*stats = ((Map<String, Object>) value).entrySet().stream()
                            .map(x -> new Statistics(x.getKey(), (Map<String, Integer>)x.getValue()))
                            .collect(Collectors.toList());*/
                    //stats.add(new Statistics(key, (Map<String, Double>) value));
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

    public void setStatistics(Map<String, Object> statistics) {
        this.statistics = statistics;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getLogout_at() {
        return logout_at;
    }

    public void setLogout_at(Long logout_at) {
        this.logout_at = logout_at;
    }

    @Override
    public String toString() {
        return "{" +
                "client_language='" + client_language + '\'' +
                ", last_battle_time=" + last_battle_time +
                ", account_id=" + account_id +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", privateData=" + privateData +
                ", global_rating=" + global_rating +
                ", clan_id=" + clan_id +
                ", statistics=" + statistics +
                ", nickname='" + nickname + '\'' +
                ", logout_at=" + logout_at +
                '}';
    }
}

package net.ukrtel.ddns.ff.tanki.entities.account.statistics;

import java.util.Map;

public class StrongholdStatistic extends AbstractStatistic {
    protected int max_xp;
    protected Integer max_xp_tank_id;
    protected Integer max_frags_tank_id;
    protected Integer max_damage_tank_id;
    protected int max_damage;
    protected int max_frags;

    public StrongholdStatistic(String statisticSectionName, Map<String, Double> stats) {
        super(statisticSectionName, stats);
    }

    public int getMax_xp() {
        return max_xp;
    }

    public void setMax_xp(int max_xp) {
        this.max_xp = max_xp;
    }

    public Integer getMax_xp_tank_id() {
        return max_xp_tank_id;
    }

    public void setMax_xp_tank_id(Integer max_xp_tank_id) {
        this.max_xp_tank_id = max_xp_tank_id;
    }

    public Integer getMax_frags_tank_id() {
        return max_frags_tank_id;
    }

    public void setMax_frags_tank_id(Integer max_frags_tank_id) {
        this.max_frags_tank_id = max_frags_tank_id;
    }

    public Integer getMax_damage_tank_id() {
        return max_damage_tank_id;
    }

    public void setMax_damage_tank_id(Integer max_damage_tank_id) {
        this.max_damage_tank_id = max_damage_tank_id;
    }

    public int getMax_damage() {
        return max_damage;
    }

    public void setMax_damage(int max_damage) {
        this.max_damage = max_damage;
    }

    public int getMax_frags() {
        return max_frags;
    }

    public void setMax_frags(int max_frags) {
        this.max_frags = max_frags;
    }

    @Override
    public String toString() {
        return "StrongholdStatistic{" +
                "max_xp=" + max_xp +
                ", max_xp_tank_id=" + max_xp_tank_id +
                ", max_frags_tank_id=" + max_frags_tank_id +
                ", max_damage_tank_id=" + max_damage_tank_id +
                ", max_damage=" + max_damage +
                ", max_frags=" + max_frags +
                ", statisticSectionName='" + statisticSectionName + '\'' +
                ", spotted=" + spotted +
                ", battles_on_stunning_vehicles=" + battles_on_stunning_vehicles +
                ", direct_hits_received=" + direct_hits_received +
                ", explosion_hits=" + explosion_hits +
                ", piercings_received=" + piercings_received +
                ", piercings=" + piercings +
                ", xp=" + xp +
                ", survived_battles=" + survived_battles +
                ", dropped_capture_polongs=" + dropped_capture_polongs +
                ", hits_percents=" + hits_percents +
                ", draws=" + draws +
                ", battles=" + battles +
                ", damage_received=" + damage_received +
                ", frags=" + frags +
                ", stun_number=" + stun_number +
                ", capture_polongs=" + capture_polongs +
                ", stun_assisted_damage=" + stun_assisted_damage +
                ", hits=" + hits +
                ", battle_avg_xp=" + battle_avg_xp +
                ", wins=" + wins +
                ", losses=" + losses +
                ", damage_dealt=" + damage_dealt +
                ", no_damage_direct_hits_received=" + no_damage_direct_hits_received +
                ", shots=" + shots +
                ", explosion_hits_received=" + explosion_hits_received +
                ", tanking_factor=" + tanking_factor +
                '}';
    }
}

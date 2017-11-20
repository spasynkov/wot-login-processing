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

    public Integer getMax_xp_tank_id() {
        return max_xp_tank_id;
    }

    public Integer getMax_frags_tank_id() {
        return max_frags_tank_id;
    }

    public Integer getMax_damage_tank_id() {
        return max_damage_tank_id;
    }

    public int getMax_damage() {
        return max_damage;
    }

    public int getMax_frags() {
        return max_frags;
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
                ", dropped_capture_points=" + dropped_capture_points +
                ", hits_percents=" + hits_percents +
                ", draws=" + draws +
                ", battles=" + battles +
                ", damage_received=" + damage_received +
                ", frags=" + frags +
                ", stun_number=" + stun_number +
                ", capture_points=" + capture_points +
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        if (!(o instanceof StrongholdStatistic)) return false;


        StrongholdStatistic that = (StrongholdStatistic) o;

        if (max_xp != that.max_xp) return false;
        if (max_damage != that.max_damage) return false;
        if (max_frags != that.max_frags) return false;
        if (max_xp_tank_id != null ? !max_xp_tank_id.equals(that.max_xp_tank_id) : that.max_xp_tank_id != null)
            return false;
        if (max_frags_tank_id != null ? !max_frags_tank_id.equals(that.max_frags_tank_id) : that.max_frags_tank_id != null)
            return false;
        return max_damage_tank_id != null ? max_damage_tank_id.equals(that.max_damage_tank_id) : that.max_damage_tank_id == null;
    }

    @Override
    public int hashCode() {
        int result = max_xp;
        result = 31 * result + (max_xp_tank_id != null ? max_xp_tank_id.hashCode() : 0);
        result = 31 * result + (max_frags_tank_id != null ? max_frags_tank_id.hashCode() : 0);
        result = 31 * result + (max_damage_tank_id != null ? max_damage_tank_id.hashCode() : 0);
        result = 31 * result + max_damage;
        result = 31 * result + max_frags;
        return result;
    }
}

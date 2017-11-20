package net.ukrtel.ddns.ff.tanki.entities.account.statistics;

import java.util.Map;

public class CompanyAndClanStatistic extends AbstractStatistic {
    protected double avg_damage_blocked;
    protected double avg_damage_assisted;
    protected double avg_damage_assisted_track;
    protected double avg_damage_assisted_radio;

    public CompanyAndClanStatistic(String statisticSectionName, Map<String, Double> stats) {
        super(statisticSectionName, stats);
    }

    public double getAvg_damage_blocked() {
        return avg_damage_blocked;
    }

    public double getAvg_damage_assisted() {
        return avg_damage_assisted;
    }

    public double getAvg_damage_assisted_track() {
        return avg_damage_assisted_track;
    }

    public double getAvg_damage_assisted_radio() {
        return avg_damage_assisted_radio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        if (!(o instanceof CompanyAndClanStatistic)) return false;

        CompanyAndClanStatistic that = (CompanyAndClanStatistic) o;

        if (Double.compare(that.avg_damage_blocked, avg_damage_blocked) != 0) return false;
        if (Double.compare(that.avg_damage_assisted, avg_damage_assisted) != 0) return false;
        if (Double.compare(that.avg_damage_assisted_track, avg_damage_assisted_track) != 0) return false;
        return Double.compare(that.avg_damage_assisted_radio, avg_damage_assisted_radio) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(avg_damage_blocked);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(avg_damage_assisted);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(avg_damage_assisted_track);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(avg_damage_assisted_radio);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "CompanyAndClanStatistic{" +
                "avg_damage_blocked=" + avg_damage_blocked +
                ", avg_damage_assisted=" + avg_damage_assisted +
                ", avg_damage_assisted_track=" + avg_damage_assisted_track +
                ", avg_damage_assisted_radio=" + avg_damage_assisted_radio +
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
}

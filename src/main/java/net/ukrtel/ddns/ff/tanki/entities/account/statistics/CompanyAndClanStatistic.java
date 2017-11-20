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

    public void setAvg_damage_blocked(double avg_damage_blocked) {
        this.avg_damage_blocked = avg_damage_blocked;
    }

    public double getAvg_damage_assisted() {
        return avg_damage_assisted;
    }

    public void setAvg_damage_assisted(double avg_damage_assisted) {
        this.avg_damage_assisted = avg_damage_assisted;
    }

    public double getAvg_damage_assisted_track() {
        return avg_damage_assisted_track;
    }

    public void setAvg_damage_assisted_track(double avg_damage_assisted_track) {
        this.avg_damage_assisted_track = avg_damage_assisted_track;
    }

    public double getAvg_damage_assisted_radio() {
        return avg_damage_assisted_radio;
    }

    public void setAvg_damage_assisted_radio(double avg_damage_assisted_radio) {
        this.avg_damage_assisted_radio = avg_damage_assisted_radio;
    }
}

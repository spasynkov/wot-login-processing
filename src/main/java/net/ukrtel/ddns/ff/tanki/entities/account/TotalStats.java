package net.ukrtel.ddns.ff.tanki.entities.account;

import net.ukrtel.ddns.ff.tanki.entities.account.statistics.AbstractStatistic;

import java.util.List;

public class TotalStats {
    private int trees_cut;
    private List<AbstractStatistic> statistics;
    private List<Frag> frags;

    public TotalStats(int trees_cut, List<AbstractStatistic> statistics, List<Frag> frags) {
        this.trees_cut = trees_cut;
        this.statistics = statistics;
        this.frags = frags;
    }

    public int getTrees_cut() {
        return trees_cut;
    }

    public void setTrees_cut(int trees_cut) {
        this.trees_cut = trees_cut;
    }

    public List<AbstractStatistic> getStatisticsList() {
        return statistics;
    }

    public void setStatistics(List<AbstractStatistic> statistics) {
        this.statistics = statistics;
    }

    public List<Frag> getFrags() {
        return frags;
    }

    public void setFrags(List<Frag> frags) {
        this.frags = frags;
    }
}

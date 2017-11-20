package net.ukrtel.ddns.ff.tanki.entities.account;

import net.ukrtel.ddns.ff.tanki.entities.account.statistics.Statistics;

import java.util.List;

public class TotalStats {
    private int trees_cut;
    private List<Statistics> statistics;
    private List<Frag> frags;

    public TotalStats(int trees_cut, List<Statistics> statistics, List<Frag> frags) {
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

    public List<Statistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistics> statistics) {
        this.statistics = statistics;
    }

    public List<Frag> getFrags() {
        return frags;
    }

    public void setFrags(List<Frag> frags) {
        this.frags = frags;
    }
}

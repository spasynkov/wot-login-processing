package net.ukrtel.ddns.ff.tanki.entities.account;

import net.ukrtel.ddns.ff.tanki.entities.account.statistics.AbstractStatistic;

import java.util.List;

public class TotalStats {
    private int trees_cut;
    private List<AbstractStatistic> statistics;
    private List<Frag> frags;

    public TotalStats() {
    }

    public TotalStats(int trees_cut, List<AbstractStatistic> statistics, List<Frag> frags) {
        this.trees_cut = trees_cut;
        this.statistics = statistics;
        this.frags = frags;
    }

    public int getTrees_cut() {
        return trees_cut;
    }

    public List<AbstractStatistic> getStatisticsList() {
        return statistics;
    }

    public List<Frag> getFrags() {
        return frags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TotalStats)) return false;

        TotalStats that = (TotalStats) o;

        if (trees_cut != that.trees_cut) return false;
        if (statistics != null ? !statistics.equals(that.statistics) : that.statistics != null) return false;
        return frags != null ? frags.equals(that.frags) : that.frags == null;
    }

    @Override
    public int hashCode() {
        int result = trees_cut;
        result = 31 * result + (statistics != null ? statistics.hashCode() : 0);
        result = 31 * result + (frags != null ? frags.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TotalStats{" +
                "trees_cut=" + trees_cut +
                ", statistics=" + statistics +
                ", frags=" + frags +
                '}';
    }
}

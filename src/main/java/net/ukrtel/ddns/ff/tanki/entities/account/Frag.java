package net.ukrtel.ddns.ff.tanki.entities.account;

public class Frag {
    private int tankId;
    private int kills;

    public Frag(int tankId, int kills) {
        this.tankId = tankId;
        this.kills = kills;
    }

    public int getTankId() {
        return tankId;
    }

    public int getKills() {
        return kills;
    }

    @Override
    public String toString() {
        return "Frag{" +
                "tankId=" + tankId +
                ", kills=" + kills +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Frag frag = (Frag) o;

        if (tankId != frag.tankId) return false;
        return kills == frag.kills;
    }

    @Override
    public int hashCode() {
        int result = tankId;
        result = 31 * result + kills;
        return result;
    }
}

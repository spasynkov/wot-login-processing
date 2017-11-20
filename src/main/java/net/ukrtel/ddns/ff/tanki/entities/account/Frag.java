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

    public void setTankId(int tankId) {
        this.tankId = tankId;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }
}

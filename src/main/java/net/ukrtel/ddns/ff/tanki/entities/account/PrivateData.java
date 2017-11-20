package net.ukrtel.ddns.ff.tanki.entities.account;

public class PrivateData {
    private Restrictions restrictions;
    private Long gold;
    private Long free_xp;
    private Long ban_time;
    private boolean is_bound_to_phone;
    private boolean is_premium;
    private Long credits;
    private Long premium_expires_at;
    private Long bonds;
    private Integer battle_life_time;
    private String ban_info;

    public Restrictions getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }

    public Long getGold() {
        return gold;
    }

    public void setGold(Long gold) {
        this.gold = gold;
    }

    public Long getFree_xp() {
        return free_xp;
    }

    public void setFree_xp(Long free_xp) {
        this.free_xp = free_xp;
    }

    public Long getBan_time() {
        return ban_time;
    }

    public void setBan_time(Long ban_time) {
        this.ban_time = ban_time;
    }

    public boolean isBoundToPhone() {
        return is_bound_to_phone;
    }

    public void setIs_bound_to_phone(boolean is_bound_to_phone) {
        this.is_bound_to_phone = is_bound_to_phone;
    }

    public boolean isPremium() {
        return is_premium;
    }

    public void setIs_premium(boolean is_premium) {
        this.is_premium = is_premium;
    }

    public Long getCredits() {
        return credits;
    }

    public void setCredits(Long credits) {
        this.credits = credits;
    }

    public Long getPremium_expires_at() {
        return premium_expires_at;
    }

    public void setPremium_expires_at(Long premium_expires_at) {
        this.premium_expires_at = premium_expires_at;
    }

    public Long getBonds() {
        return bonds;
    }

    public void setBonds(Long bonds) {
        this.bonds = bonds;
    }

    public Integer getBattle_life_time() {
        return battle_life_time;
    }

    public void setBattle_life_time(Integer battle_life_time) {
        this.battle_life_time = battle_life_time;
    }

    public String getBan_info() {
        return ban_info;
    }

    public void setBan_info(String ban_info) {
        this.ban_info = ban_info;
    }

    @Override
    public String toString() {
        return "{" +
                "restrictions=" + restrictions +
                ", gold=" + gold +
                ", free_xp=" + free_xp +
                ", ban_time=" + ban_time +
                ", is_bound_to_phone=" + is_bound_to_phone +
                ", is_premium=" + is_premium +
                ", credits=" + credits +
                ", premium_expires_at=" + premium_expires_at +
                ", bonds=" + bonds +
                ", battle_life_time=" + battle_life_time +
                ", ban_info=" + ban_info +
                '}';
    }
}
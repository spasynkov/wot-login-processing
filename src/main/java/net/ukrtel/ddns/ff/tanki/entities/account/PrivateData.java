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

    public Long getGold() {
        return gold;
    }

    public Long getFree_xp() {
        return free_xp;
    }

    public Long getBan_time() {
        return ban_time;
    }

    public boolean isBoundToPhone() {
        return is_bound_to_phone;
    }

    public boolean isPremium() {
        return is_premium;
    }

    public Long getCredits() {
        return credits;
    }

    public Long getPremium_expires_at() {
        return premium_expires_at;
    }

    public Long getBonds() {
        return bonds;
    }

    public Integer getBattle_life_time() {
        return battle_life_time;
    }

    public String getBan_info() {
        return ban_info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrivateData)) return false;

        PrivateData that = (PrivateData) o;

        if (is_bound_to_phone != that.is_bound_to_phone) return false;
        if (is_premium != that.is_premium) return false;
        if (restrictions != null ? !restrictions.equals(that.restrictions) : that.restrictions != null) return false;
        if (gold != null ? !gold.equals(that.gold) : that.gold != null) return false;
        if (free_xp != null ? !free_xp.equals(that.free_xp) : that.free_xp != null) return false;
        if (ban_time != null ? !ban_time.equals(that.ban_time) : that.ban_time != null) return false;
        if (credits != null ? !credits.equals(that.credits) : that.credits != null) return false;
        if (premium_expires_at != null ? !premium_expires_at.equals(that.premium_expires_at) : that.premium_expires_at != null)
            return false;
        if (bonds != null ? !bonds.equals(that.bonds) : that.bonds != null) return false;
        if (battle_life_time != null ? !battle_life_time.equals(that.battle_life_time) : that.battle_life_time != null)
            return false;
        return ban_info != null ? ban_info.equals(that.ban_info) : that.ban_info == null;
    }

    @Override
    public int hashCode() {
        int result = restrictions != null ? restrictions.hashCode() : 0;
        result = 31 * result + (gold != null ? gold.hashCode() : 0);
        result = 31 * result + (free_xp != null ? free_xp.hashCode() : 0);
        result = 31 * result + (ban_time != null ? ban_time.hashCode() : 0);
        result = 31 * result + (is_bound_to_phone ? 1 : 0);
        result = 31 * result + (is_premium ? 1 : 0);
        result = 31 * result + (credits != null ? credits.hashCode() : 0);
        result = 31 * result + (premium_expires_at != null ? premium_expires_at.hashCode() : 0);
        result = 31 * result + (bonds != null ? bonds.hashCode() : 0);
        result = 31 * result + (battle_life_time != null ? battle_life_time.hashCode() : 0);
        result = 31 * result + (ban_info != null ? ban_info.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PrivateData{" +
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
                ", ban_info='" + ban_info + '\'' +
                '}';
    }
}
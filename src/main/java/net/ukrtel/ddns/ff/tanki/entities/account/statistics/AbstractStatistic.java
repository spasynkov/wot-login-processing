package net.ukrtel.ddns.ff.tanki.entities.account.statistics;

import java.lang.reflect.Field;
import java.util.*;

public abstract class AbstractStatistic {
    protected String statisticSectionName;

    protected long spotted;
    protected long battles_on_stunning_vehicles;
    protected long direct_hits_received;
    protected long explosion_hits;
    protected long piercings_received;
    protected long piercings;
    protected long xp;
    protected long survived_battles;
    protected long dropped_capture_points;
    protected long hits_percents;
    protected long draws;
    protected long battles;
    protected long damage_received;
    protected long frags;
    protected long stun_number;
    protected long capture_points;
    protected long stun_assisted_damage;
    protected long hits;
    protected long battle_avg_xp;
    protected long wins;
    protected long losses;
    protected long damage_dealt;
    protected long no_damage_direct_hits_received;
    protected long shots;
    protected long explosion_hits_received;
    protected double tanking_factor;

    public AbstractStatistic(String statisticSectionName, Map<String, Double> stats) {
        this.statisticSectionName = statisticSectionName;
        populateFields(stats);
    }

    public String getStatisticSectionName() {
        return statisticSectionName;
    }

    public long getSpotted() {
        return spotted;
    }

    public long getBattles_on_stunning_vehicles() {
        return battles_on_stunning_vehicles;
    }

    public long getDirect_hits_received() {
        return direct_hits_received;
    }

    public long getExplosion_hits() {
        return explosion_hits;
    }

    public long getPiercings_received() {
        return piercings_received;
    }

    public long getPiercings() {
        return piercings;
    }

    public long getXp() {
        return xp;
    }

    public long getSurvived_battles() {
        return survived_battles;
    }

    public long getDropped_capture_points() {
        return dropped_capture_points;
    }

    public long getHits_percents() {
        return hits_percents;
    }

    public long getDraws() {
        return draws;
    }

    public long getBattles() {
        return battles;
    }

    public long getDamage_received() {
        return damage_received;
    }

    public long getFrags() {
        return frags;
    }

    public long getStun_number() {
        return stun_number;
    }

    public long getCapture_points() {
        return capture_points;
    }

    public long getStun_assisted_damage() {
        return stun_assisted_damage;
    }

    public long getHits() {
        return hits;
    }

    public long getBattle_avg_xp() {
        return battle_avg_xp;
    }

    public long getWins() {
        return wins;
    }

    public long getLosses() {
        return losses;
    }

    public long getDamage_dealt() {
        return damage_dealt;
    }

    public long getNo_damage_direct_hits_received() {
        return no_damage_direct_hits_received;
    }

    public long getShots() {
        return shots;
    }

    public long getExplosion_hits_received() {
        return explosion_hits_received;
    }

    public double getTanking_factor() {
        return tanking_factor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractStatistic)) return false;

        AbstractStatistic that = (AbstractStatistic) o;

        if (spotted != that.spotted) return false;
        if (battles_on_stunning_vehicles != that.battles_on_stunning_vehicles) return false;
        if (direct_hits_received != that.direct_hits_received) return false;
        if (explosion_hits != that.explosion_hits) return false;
        if (piercings_received != that.piercings_received) return false;
        if (piercings != that.piercings) return false;
        if (xp != that.xp) return false;
        if (survived_battles != that.survived_battles) return false;
        if (dropped_capture_points != that.dropped_capture_points) return false;
        if (hits_percents != that.hits_percents) return false;
        if (draws != that.draws) return false;
        if (battles != that.battles) return false;
        if (damage_received != that.damage_received) return false;
        if (frags != that.frags) return false;
        if (stun_number != that.stun_number) return false;
        if (capture_points != that.capture_points) return false;
        if (stun_assisted_damage != that.stun_assisted_damage) return false;
        if (hits != that.hits) return false;
        if (battle_avg_xp != that.battle_avg_xp) return false;
        if (wins != that.wins) return false;
        if (losses != that.losses) return false;
        if (damage_dealt != that.damage_dealt) return false;
        if (no_damage_direct_hits_received != that.no_damage_direct_hits_received) return false;
        if (shots != that.shots) return false;
        if (explosion_hits_received != that.explosion_hits_received) return false;
        if (Double.compare(that.tanking_factor, tanking_factor) != 0) return false;
        return statisticSectionName.equals(that.statisticSectionName);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = statisticSectionName.hashCode();
        result = 31 * result + (int) (spotted ^ (spotted >>> 32));
        result = 31 * result + (int) (battles_on_stunning_vehicles ^ (battles_on_stunning_vehicles >>> 32));
        result = 31 * result + (int) (direct_hits_received ^ (direct_hits_received >>> 32));
        result = 31 * result + (int) (explosion_hits ^ (explosion_hits >>> 32));
        result = 31 * result + (int) (piercings_received ^ (piercings_received >>> 32));
        result = 31 * result + (int) (piercings ^ (piercings >>> 32));
        result = 31 * result + (int) (xp ^ (xp >>> 32));
        result = 31 * result + (int) (survived_battles ^ (survived_battles >>> 32));
        result = 31 * result + (int) (dropped_capture_points ^ (dropped_capture_points >>> 32));
        result = 31 * result + (int) (hits_percents ^ (hits_percents >>> 32));
        result = 31 * result + (int) (draws ^ (draws >>> 32));
        result = 31 * result + (int) (battles ^ (battles >>> 32));
        result = 31 * result + (int) (damage_received ^ (damage_received >>> 32));
        result = 31 * result + (int) (frags ^ (frags >>> 32));
        result = 31 * result + (int) (stun_number ^ (stun_number >>> 32));
        result = 31 * result + (int) (capture_points ^ (capture_points >>> 32));
        result = 31 * result + (int) (stun_assisted_damage ^ (stun_assisted_damage >>> 32));
        result = 31 * result + (int) (hits ^ (hits >>> 32));
        result = 31 * result + (int) (battle_avg_xp ^ (battle_avg_xp >>> 32));
        result = 31 * result + (int) (wins ^ (wins >>> 32));
        result = 31 * result + (int) (losses ^ (losses >>> 32));
        result = 31 * result + (int) (damage_dealt ^ (damage_dealt >>> 32));
        result = 31 * result + (int) (no_damage_direct_hits_received ^ (no_damage_direct_hits_received >>> 32));
        result = 31 * result + (int) (shots ^ (shots >>> 32));
        result = 31 * result + (int) (explosion_hits_received ^ (explosion_hits_received >>> 32));
        temp = Double.doubleToLongBits(tanking_factor);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    protected void populateFields(Map<String, Double> stats) {
        List<Field> fields = new LinkedList<>();
        Class classs = this.getClass();
        while (classs.getSuperclass() != null) {
            fields.addAll(Arrays.asList(classs.getDeclaredFields()));
            classs = classs.getSuperclass();
        }

        Map<String, Class> fieldsMap = new HashMap<>();
        for (Field f : fields) {
            fieldsMap.put(f.getName(), f.getType());
        }

        String fieldName;
        Class fieldType;
        for (Map.Entry<String, Class> fieldsEntry : fieldsMap.entrySet()) {
            fieldName = fieldsEntry.getKey();
            fieldType = fieldsEntry.getValue();
            if (stats.containsKey(fieldName)) {
                Field field = findField(fieldName);
                try {
                    setFieldValue(field, fieldType, stats.get(fieldName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void setFieldValue(Field field, Class type, Double value) throws IllegalAccessException {
        String typeName = type.getName();
        if ("java.lang.Long".equalsIgnoreCase(typeName)
                || "long".equalsIgnoreCase(typeName)) {
            field.set(this, value == null ? null : value.longValue());
        } else if ("java.lang.Integer".equalsIgnoreCase(typeName)
                || "int".equalsIgnoreCase(typeName)) {
            field.set(this, value == null ? null : value.intValue());
        } else {
            field.set(this, value);
        }
    }

    private Field findField(String fieldName) {
        Field result;
        Class classs = getClass();
        do {
            try {
                result = classs.getDeclaredField(fieldName);
                return result;
            } catch (NoSuchFieldException ignored) {
            }
        } while ((classs = classs.getSuperclass()) != null);

        throw new RuntimeException("Cant find field '" + fieldName + "'!");
    }
}

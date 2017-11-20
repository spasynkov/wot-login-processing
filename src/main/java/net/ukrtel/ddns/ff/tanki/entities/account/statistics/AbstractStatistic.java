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
    protected long dropped_capture_polongs;
    protected long hits_percents;
    protected long draws;
    protected long battles;
    protected long damage_received;
    protected long frags;
    protected long stun_number;
    protected long capture_polongs;
    protected long stun_assisted_damage;
    protected long hits;
    protected long battle_avg_xp;
    protected long wins;
    protected long losses;
    protected long damage_dealt;
    protected long no_damage_direct_hits_received;
    protected long shots;
    protected long explosion_hits_received;
    protected long tanking_factor;

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

    public long getDropped_capture_polongs() {
        return dropped_capture_polongs;
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

    public long getCapture_polongs() {
        return capture_polongs;
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

    public long getTanking_factor() {
        return tanking_factor;
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
            } catch (NoSuchFieldException e) {
                //e.printStackTrace();
            }
        } while ((classs = classs.getSuperclass()) != null);

        throw new RuntimeException("Cant find field '" + fieldName + "'!");
    }
}

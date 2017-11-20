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
        if (type == Long.TYPE) {
            field.set(this, value.longValue());
        } else if (type == Integer.TYPE) {
            field.set(this, value.intValue());
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

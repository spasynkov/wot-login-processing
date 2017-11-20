package net.ukrtel.ddns.ff.tanki.entities.account;

import com.google.gson.Gson;
import net.ukrtel.ddns.ff.tanki.entities.account.statistics.Statistics;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WotAccountInfoResponse {
    private String status;
    private Meta meta;
    private Map<String, UserDetails> data;

    public static void main(String[] args) {
        String fullJson = "{\"status\":\"ok\",\"meta\":{\"count\":1},\"data\":{\"6853373\":{\"client_language\":\"ru\",\"last_battle_time\":1437752133,\"account_id\":6853373,\"created_at\":1338151261,\"updated_at\":1502231920,\"private\":{\"restrictions\":{\"chat_ban_time\":null},\"gold\":315,\"free_xp\":5600,\"ban_time\":null,\"is_bound_to_phone\":false,\"is_premium\":false,\"credits\":204747,\"premium_expires_at\":0,\"bonds\":0,\"battle_life_time\":191089,\"ban_info\":null},\"global_rating\":1229,\"clan_id\":null,\"statistics\":{\"clan\":{\"spotted\":0,\"battles_on_stunning_vehicles\":0,\"avg_damage_blocked\":0.0,\"direct_hits_received\":0,\"explosion_hits\":0,\"piercings_received\":0,\"piercings\":0,\"xp\":0,\"survived_battles\":0,\"dropped_capture_points\":0,\"hits_percents\":0,\"draws\":0,\"battles\":0,\"damage_received\":0,\"avg_damage_assisted\":0.0,\"avg_damage_assisted_track\":0.0,\"frags\":0,\"stun_number\":0,\"avg_damage_assisted_radio\":0.0,\"capture_points\":0,\"stun_assisted_damage\":0,\"hits\":0,\"battle_avg_xp\":0,\"wins\":0,\"losses\":0,\"damage_dealt\":0,\"no_damage_direct_hits_received\":0,\"shots\":0,\"explosion_hits_received\":0,\"tanking_factor\":0.0},\"all\":{\"spotted\":924,\"battles_on_stunning_vehicles\":0,\"max_xp\":779,\"avg_damage_blocked\":37.77,\"direct_hits_received\":3278,\"explosion_hits\":70,\"piercings_received\":2236,\"piercings\":1288,\"max_damage_tank_id\":6401,\"xp\":140490,\"survived_battles\":155,\"dropped_capture_points\":212,\"hits_percents\":36,\"draws\":10,\"max_xp_tank_id\":6401,\"battles\":991,\"damage_received\":154498,\"avg_damage_assisted\":60.37,\"max_frags_tank_id\":2353,\"avg_damage_assisted_track\":4.52,\"frags\":456,\"stun_number\":0,\"avg_damage_assisted_radio\":55.86,\"capture_points\":1139,\"stun_assisted_damage\":0,\"max_damage\":868,\"hits\":3326,\"battle_avg_xp\":142,\"wins\":442,\"losses\":539,\"damage_dealt\":107983,\"no_damage_direct_hits_received\":1042,\"max_frags\":5,\"shots\":9288,\"explosion_hits_received\":29,\"tanking_factor\":0.21},\"regular_team\":{\"spotted\":0,\"battles_on_stunning_vehicles\":0,\"max_xp\":0,\"avg_damage_blocked\":0.0,\"direct_hits_received\":0,\"explosion_hits\":0,\"piercings_received\":0,\"piercings\":0,\"max_damage_tank_id\":null,\"xp\":0,\"survived_battles\":0,\"dropped_capture_points\":0,\"hits_percents\":0,\"draws\":0,\"max_xp_tank_id\":null,\"battles\":0,\"damage_received\":0,\"avg_damage_assisted\":0.0,\"max_frags_tank_id\":null,\"avg_damage_assisted_track\":0.0,\"frags\":0,\"stun_number\":0,\"avg_damage_assisted_radio\":0.0,\"capture_points\":0,\"stun_assisted_damage\":0,\"max_damage\":0,\"hits\":0,\"battle_avg_xp\":0,\"wins\":0,\"losses\":0,\"damage_dealt\":0,\"no_damage_direct_hits_received\":0,\"max_frags\":0,\"shots\":0,\"explosion_hits_received\":0,\"tanking_factor\":0.0},\"trees_cut\":226,\"company\":{\"spotted\":0,\"battles_on_stunning_vehicles\":0,\"avg_damage_blocked\":0.0,\"direct_hits_received\":0,\"explosion_hits\":0,\"piercings_received\":0,\"piercings\":0,\"xp\":0,\"survived_battles\":0,\"dropped_capture_points\":0,\"hits_percents\":0,\"draws\":0,\"battles\":0,\"damage_received\":0,\"avg_damage_assisted\":0.0,\"avg_damage_assisted_track\":0.0,\"frags\":0,\"stun_number\":0,\"avg_damage_assisted_radio\":0.0,\"capture_points\":0,\"stun_assisted_damage\":0,\"hits\":0,\"battle_avg_xp\":0,\"wins\":0,\"losses\":0,\"damage_dealt\":0,\"no_damage_direct_hits_received\":0,\"shots\":0,\"explosion_hits_received\":0,\"tanking_factor\":0.0},\"stronghold_skirmish\":{\"spotted\":0,\"battles_on_stunning_vehicles\":0,\"max_xp\":0,\"direct_hits_received\":0,\"explosion_hits\":0,\"piercings_received\":0,\"piercings\":0,\"xp\":0,\"survived_battles\":0,\"dropped_capture_points\":0,\"hits_percents\":0,\"draws\":0,\"max_xp_tank_id\":null,\"battles\":0,\"damage_received\":0,\"max_frags_tank_id\":null,\"frags\":0,\"stun_number\":0,\"capture_points\":0,\"stun_assisted_damage\":0,\"max_damage_tank_id\":null,\"max_damage\":0,\"hits\":0,\"battle_avg_xp\":0,\"wins\":0,\"losses\":0,\"damage_dealt\":0,\"no_damage_direct_hits_received\":0,\"max_frags\":0,\"shots\":0,\"explosion_hits_received\":0,\"tanking_factor\":0.0},\"stronghold_defense\":{\"spotted\":0,\"battles_on_stunning_vehicles\":0,\"max_xp\":0,\"direct_hits_received\":0,\"explosion_hits\":0,\"piercings_received\":0,\"piercings\":0,\"xp\":0,\"survived_battles\":0,\"dropped_capture_points\":0,\"hits_percents\":0,\"draws\":0,\"max_xp_tank_id\":null,\"battles\":0,\"damage_received\":0,\"max_frags_tank_id\":null,\"frags\":0,\"stun_number\":0,\"capture_points\":0,\"stun_assisted_damage\":0,\"max_damage_tank_id\":null,\"max_damage\":0,\"hits\":0,\"battle_avg_xp\":0,\"wins\":0,\"losses\":0,\"damage_dealt\":0,\"no_damage_direct_hits_received\":0,\"max_frags\":0,\"shots\":0,\"explosion_hits_received\":0,\"tanking_factor\":0.0},\"historical\":{\"spotted\":0,\"battles_on_stunning_vehicles\":0,\"max_xp\":0,\"avg_damage_blocked\":0.0,\"direct_hits_received\":0,\"explosion_hits\":0,\"piercings_received\":0,\"piercings\":0,\"max_damage_tank_id\":null,\"xp\":0,\"survived_battles\":0,\"dropped_capture_points\":0,\"hits_percents\":0,\"draws\":0,\"max_xp_tank_id\":null,\"battles\":0,\"damage_received\":0,\"avg_damage_assisted\":0.0,\"max_frags_tank_id\":null,\"avg_damage_assisted_track\":0.0,\"frags\":0,\"stun_number\":0,\"avg_damage_assisted_radio\":0.0,\"capture_points\":0,\"stun_assisted_damage\":0,\"max_damage\":0,\"hits\":0,\"battle_avg_xp\":0,\"wins\":0,\"losses\":0,\"damage_dealt\":0,\"no_damage_direct_hits_received\":0,\"max_frags\":0,\"shots\":0,\"explosion_hits_received\":0,\"tanking_factor\":0.0},\"team\":{\"spotted\":0,\"battles_on_stunning_vehicles\":0,\"max_xp\":0,\"avg_damage_blocked\":0.0,\"direct_hits_received\":0,\"explosion_hits\":0,\"piercings_received\":0,\"piercings\":0,\"max_damage_tank_id\":null,\"xp\":0,\"survived_battles\":0,\"dropped_capture_points\":0,\"hits_percents\":0,\"draws\":0,\"max_xp_tank_id\":null,\"battles\":0,\"damage_received\":0,\"avg_damage_assisted\":0.0,\"max_frags_tank_id\":null,\"avg_damage_assisted_track\":0.0,\"frags\":0,\"stun_number\":0,\"avg_damage_assisted_radio\":0.0,\"capture_points\":0,\"stun_assisted_damage\":0,\"max_damage\":0,\"hits\":0,\"battle_avg_xp\":0,\"wins\":0,\"losses\":0,\"damage_dealt\":0,\"no_damage_direct_hits_received\":0,\"max_frags\":0,\"shots\":0,\"explosion_hits_received\":0,\"tanking_factor\":0.0},\"frags\":{\"8257\":3,\"769\":17,\"6721\":2,\"8017\":3,\"3329\":8,\"17169\":1,\"15361\":5,\"289\":13,\"1377\":1,\"5905\":2,\"4865\":2,\"4881\":9,\"10529\":4,\"6993\":1,\"6913\":5,\"3409\":1,\"54801\":1,\"1825\":7,\"4401\":5,\"3841\":6,\"2145\":7,\"7681\":1,\"2065\":9,\"11777\":2,\"5153\":5,\"4897\":6,\"52497\":3,\"81\":5,\"833\":2,\"2385\":8,\"54529\":5,\"11281\":3,\"8209\":1,\"53537\":1,\"2881\":1,\"6673\":9,\"52481\":2,\"6177\":10,\"2833\":4,\"5121\":7,\"785\":2,\"3393\":1,\"33\":1,\"60433\":2,\"5409\":2,\"2049\":5,\"9793\":1,\"3121\":2,\"15121\":2,\"3617\":3,\"577\":2,\"18193\":4,\"51985\":3,\"5665\":8,\"545\":7,\"6161\":1,\"52737\":2,\"257\":1,\"7713\":2,\"1633\":1,\"6433\":6,\"12561\":11,\"3089\":12,\"2369\":4,\"3601\":5,\"4369\":3,\"2401\":2,\"3073\":21,\"4609\":9,\"14145\":2,\"6481\":5,\"1025\":20,\"5953\":2,\"6401\":13,\"56577\":12,\"2897\":1,\"865\":1,\"51729\":1,\"7761\":3,\"2353\":3,\"51489\":3,\"10273\":1,\"609\":1,\"5649\":1,\"12817\":1,\"849\":2,\"53505\":4,\"10577\":3,\"6945\":1,\"55073\":2,\"15105\":3,\"13585\":2,\"3105\":2,\"3345\":5,\"1\":4,\"321\":8,\"52769\":1,\"11553\":1,\"17937\":1,\"9041\":2,\"1041\":4,\"1601\":1,\"2081\":7,\"1537\":7,\"1809\":4,\"7505\":10}},\"nickname\":\"lizo4ka1997\",\"logout_at\":1437751771}}}";
        String json = "{\"status\": \"ok\",\"meta\": {\"count\": 1},\"data\":{\"6853373\":{\"client_language\": \"ru\",\"last_battle_time\": 1437752133,\"account_id\": 6853373,\"created_at\": 1338151261,\"updated_at\": 1502231920,\"private\": {\"restrictions\": {},\"gold\": 315,\"free_xp\": 5600,\"ban_time\": null,\"is_bound_to_phone\": false,\"is_premium\": false,\"credits\": 204747,\"premium_expires_at\": 0,\"bonds\": 0,\"battle_life_time\": 191089,\"ban_info\": null},\"global_rating\": 1229,\"clan_id\": null,\"statistics\": {},\"nickname\": \"lizo4ka1997\",\"logout_at\": 1437751771}}}";
        //System.out.println(fullJson + "\n");

        Gson gson = new Gson();
        WotAccountInfoResponse parsedResponse = gson.fromJson(fullJson, WotAccountInfoResponse.class);

        //LinkedTreeMap map = gson.fromJson(json, LinkedTreeMap.class);
        //System.out.println(parsedResponse);

        Statistics stat = parsedResponse.getData().get(0).getDetails().getStatistics().getStatistics().get(3);
        //System.out.println(stat.statisticSectionName);
        //System.out.println(stat.battles);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<User> getData() {
        return data.entrySet().stream()
                .map(x -> new User(x.getKey(), x.getValue()))
                .collect(Collectors.toList());
    }

    public void setData(Map<String, UserDetails> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WotAccountInfoResponse{" +
                "status='" + status + '\'' +
                ", meta=" + meta +
                ", users=" + getData() +
                '}';
    }
















}

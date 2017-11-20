package net.ukrtel.ddns.ff.tanki.entities.account;

import com.google.gson.Gson;
import net.ukrtel.ddns.ff.tanki.entities.account.statistics.AbstractStatistic;
import net.ukrtel.ddns.ff.tanki.entities.account.statistics.TeamAndHistoricalStatistic;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class JsonToWotAccountInfoResponseTest {

    private final String jsonString = "{\"status\":\"ok\",\"meta\":{\"count\":1},\"data\":{\"6853373\":{\"client_language\":\"ru\",\"last_battle_time\":1437752133,\"account_id\":6853373,\"created_at\":1338151261,\"updated_at\":1502231920,\"private\":{\"restrictions\":{\"chat_ban_time\":null},\"gold\":315,\"free_xp\":5600,\"ban_time\":null,\"is_bound_to_phone\":false,\"is_premium\":false,\"credits\":204747,\"premium_expires_at\":0,\"bonds\":0,\"battle_life_time\":191089,\"ban_info\":null},\"global_rating\":1229,\"clan_id\":null,\"statistics\":{\"clan\":{\"spotted\":0,\"battles_on_stunning_vehicles\":0,\"avg_damage_blocked\":0.0,\"direct_hits_received\":0,\"explosion_hits\":0,\"piercings_received\":0,\"piercings\":0,\"xp\":0,\"survived_battles\":0,\"dropped_capture_points\":0,\"hits_percents\":0,\"draws\":0,\"battles\":0,\"damage_received\":0,\"avg_damage_assisted\":0.0,\"avg_damage_assisted_track\":0.0,\"frags\":0,\"stun_number\":0,\"avg_damage_assisted_radio\":0.0,\"capture_points\":0,\"stun_assisted_damage\":0,\"hits\":0,\"battle_avg_xp\":0,\"wins\":0,\"losses\":0,\"damage_dealt\":0,\"no_damage_direct_hits_received\":0,\"shots\":0,\"explosion_hits_received\":0,\"tanking_factor\":0.0},\"all\":{\"spotted\":924,\"battles_on_stunning_vehicles\":0,\"max_xp\":779,\"avg_damage_blocked\":37.77,\"direct_hits_received\":3278,\"explosion_hits\":70,\"piercings_received\":2236,\"piercings\":1288,\"max_damage_tank_id\":6401,\"xp\":140490,\"survived_battles\":155,\"dropped_capture_points\":212,\"hits_percents\":36,\"draws\":10,\"max_xp_tank_id\":6401,\"battles\":991,\"damage_received\":154498,\"avg_damage_assisted\":60.37,\"max_frags_tank_id\":2353,\"avg_damage_assisted_track\":4.52,\"frags\":456,\"stun_number\":0,\"avg_damage_assisted_radio\":55.86,\"capture_points\":1139,\"stun_assisted_damage\":0,\"max_damage\":868,\"hits\":3326,\"battle_avg_xp\":142,\"wins\":442,\"losses\":539,\"damage_dealt\":107983,\"no_damage_direct_hits_received\":1042,\"max_frags\":5,\"shots\":9288,\"explosion_hits_received\":29,\"tanking_factor\":0.21},\"regular_team\":{\"spotted\":0,\"battles_on_stunning_vehicles\":0,\"max_xp\":0,\"avg_damage_blocked\":0.0,\"direct_hits_received\":0,\"explosion_hits\":0,\"piercings_received\":0,\"piercings\":0,\"max_damage_tank_id\":null,\"xp\":0,\"survived_battles\":0,\"dropped_capture_points\":0,\"hits_percents\":0,\"draws\":0,\"max_xp_tank_id\":null,\"battles\":0,\"damage_received\":0,\"avg_damage_assisted\":0.0,\"max_frags_tank_id\":null,\"avg_damage_assisted_track\":0.0,\"frags\":0,\"stun_number\":0,\"avg_damage_assisted_radio\":0.0,\"capture_points\":0,\"stun_assisted_damage\":0,\"max_damage\":0,\"hits\":0,\"battle_avg_xp\":0,\"wins\":0,\"losses\":0,\"damage_dealt\":0,\"no_damage_direct_hits_received\":0,\"max_frags\":0,\"shots\":0,\"explosion_hits_received\":0,\"tanking_factor\":0.0},\"trees_cut\":226,\"company\":{\"spotted\":0,\"battles_on_stunning_vehicles\":0,\"avg_damage_blocked\":0.0,\"direct_hits_received\":0,\"explosion_hits\":0,\"piercings_received\":0,\"piercings\":0,\"xp\":0,\"survived_battles\":0,\"dropped_capture_points\":0,\"hits_percents\":0,\"draws\":0,\"battles\":0,\"damage_received\":0,\"avg_damage_assisted\":0.0,\"avg_damage_assisted_track\":0.0,\"frags\":0,\"stun_number\":0,\"avg_damage_assisted_radio\":0.0,\"capture_points\":0,\"stun_assisted_damage\":0,\"hits\":0,\"battle_avg_xp\":0,\"wins\":0,\"losses\":0,\"damage_dealt\":0,\"no_damage_direct_hits_received\":0,\"shots\":0,\"explosion_hits_received\":0,\"tanking_factor\":0.0},\"stronghold_skirmish\":{\"spotted\":0,\"battles_on_stunning_vehicles\":0,\"max_xp\":0,\"direct_hits_received\":0,\"explosion_hits\":0,\"piercings_received\":0,\"piercings\":0,\"xp\":0,\"survived_battles\":0,\"dropped_capture_points\":0,\"hits_percents\":0,\"draws\":0,\"max_xp_tank_id\":null,\"battles\":0,\"damage_received\":0,\"max_frags_tank_id\":null,\"frags\":0,\"stun_number\":0,\"capture_points\":0,\"stun_assisted_damage\":0,\"max_damage_tank_id\":null,\"max_damage\":0,\"hits\":0,\"battle_avg_xp\":0,\"wins\":0,\"losses\":0,\"damage_dealt\":0,\"no_damage_direct_hits_received\":0,\"max_frags\":0,\"shots\":0,\"explosion_hits_received\":0,\"tanking_factor\":0.0},\"stronghold_defense\":{\"spotted\":0,\"battles_on_stunning_vehicles\":0,\"max_xp\":0,\"direct_hits_received\":0,\"explosion_hits\":0,\"piercings_received\":0,\"piercings\":0,\"xp\":0,\"survived_battles\":0,\"dropped_capture_points\":0,\"hits_percents\":0,\"draws\":0,\"max_xp_tank_id\":null,\"battles\":0,\"damage_received\":0,\"max_frags_tank_id\":null,\"frags\":0,\"stun_number\":0,\"capture_points\":0,\"stun_assisted_damage\":0,\"max_damage_tank_id\":null,\"max_damage\":0,\"hits\":0,\"battle_avg_xp\":0,\"wins\":0,\"losses\":0,\"damage_dealt\":0,\"no_damage_direct_hits_received\":0,\"max_frags\":0,\"shots\":0,\"explosion_hits_received\":0,\"tanking_factor\":0.0},\"historical\":{\"spotted\":0,\"battles_on_stunning_vehicles\":0,\"max_xp\":0,\"avg_damage_blocked\":0.0,\"direct_hits_received\":0,\"explosion_hits\":0,\"piercings_received\":0,\"piercings\":0,\"max_damage_tank_id\":null,\"xp\":0,\"survived_battles\":0,\"dropped_capture_points\":0,\"hits_percents\":0,\"draws\":0,\"max_xp_tank_id\":null,\"battles\":0,\"damage_received\":0,\"avg_damage_assisted\":0.0,\"max_frags_tank_id\":null,\"avg_damage_assisted_track\":0.0,\"frags\":0,\"stun_number\":0,\"avg_damage_assisted_radio\":0.0,\"capture_points\":0,\"stun_assisted_damage\":0,\"max_damage\":0,\"hits\":0,\"battle_avg_xp\":0,\"wins\":0,\"losses\":0,\"damage_dealt\":0,\"no_damage_direct_hits_received\":0,\"max_frags\":0,\"shots\":0,\"explosion_hits_received\":0,\"tanking_factor\":0.0},\"team\":{\"spotted\":0,\"battles_on_stunning_vehicles\":0,\"max_xp\":0,\"avg_damage_blocked\":0.0,\"direct_hits_received\":0,\"explosion_hits\":0,\"piercings_received\":0,\"piercings\":0,\"max_damage_tank_id\":null,\"xp\":0,\"survived_battles\":0,\"dropped_capture_points\":0,\"hits_percents\":0,\"draws\":0,\"max_xp_tank_id\":null,\"battles\":0,\"damage_received\":0,\"avg_damage_assisted\":0.0,\"max_frags_tank_id\":null,\"avg_damage_assisted_track\":0.0,\"frags\":0,\"stun_number\":0,\"avg_damage_assisted_radio\":0.0,\"capture_points\":0,\"stun_assisted_damage\":0,\"max_damage\":0,\"hits\":0,\"battle_avg_xp\":0,\"wins\":0,\"losses\":0,\"damage_dealt\":0,\"no_damage_direct_hits_received\":0,\"max_frags\":0,\"shots\":0,\"explosion_hits_received\":0,\"tanking_factor\":0.0},\"frags\":{\"8257\":3,\"769\":17,\"6721\":2,\"8017\":3,\"3329\":8,\"17169\":1,\"15361\":5,\"289\":13,\"1377\":1,\"5905\":2,\"4865\":2,\"4881\":9,\"10529\":4,\"6993\":1,\"6913\":5,\"3409\":1,\"54801\":1,\"1825\":7,\"4401\":5,\"3841\":6,\"2145\":7,\"7681\":1,\"2065\":9,\"11777\":2,\"5153\":5,\"4897\":6,\"52497\":3,\"81\":5,\"833\":2,\"2385\":8,\"54529\":5,\"11281\":3,\"8209\":1,\"53537\":1,\"2881\":1,\"6673\":9,\"52481\":2,\"6177\":10,\"2833\":4,\"5121\":7,\"785\":2,\"3393\":1,\"33\":1,\"60433\":2,\"5409\":2,\"2049\":5,\"9793\":1,\"3121\":2,\"15121\":2,\"3617\":3,\"577\":2,\"18193\":4,\"51985\":3,\"5665\":8,\"545\":7,\"6161\":1,\"52737\":2,\"257\":1,\"7713\":2,\"1633\":1,\"6433\":6,\"12561\":11,\"3089\":12,\"2369\":4,\"3601\":5,\"4369\":3,\"2401\":2,\"3073\":21,\"4609\":9,\"14145\":2,\"6481\":5,\"1025\":20,\"5953\":2,\"6401\":13,\"56577\":12,\"2897\":1,\"865\":1,\"51729\":1,\"7761\":3,\"2353\":3,\"51489\":3,\"10273\":1,\"609\":1,\"5649\":1,\"12817\":1,\"849\":2,\"53505\":4,\"10577\":3,\"6945\":1,\"55073\":2,\"15105\":3,\"13585\":2,\"3105\":2,\"3345\":5,\"1\":4,\"321\":8,\"52769\":1,\"11553\":1,\"17937\":1,\"9041\":2,\"1041\":4,\"1601\":1,\"2081\":7,\"1537\":7,\"1809\":4,\"7505\":10}},\"nickname\":\"lizo4ka1997\",\"logout_at\":1437751771}}}";

    private final Gson gson = new Gson();
    private final WotAccountInfoResponse parsedResponse = gson.fromJson(jsonString, WotAccountInfoResponse.class);

    private final User user = parsedResponse.getUsersData().get(0);
    private final PrivateData privateData = user.getDetails().getPrivateData();
    private final TotalStats stats = user.getDetails().getStats();

    private final double delta = 0.000000001;

    @Test
    public void statusAndMetaTest() throws Exception {
        String status = parsedResponse.getStatus();
        assertEquals("ok", status);

        Meta meta = parsedResponse.getMeta();
        assertEquals(1, meta.getCount());
    }

    @Test
    public void mainUserDataTest() throws Exception {
        assertEquals("6853373", user.getId());

        UserDetails userDetails = user.getDetails();
        assertEquals("ru", userDetails.getClient_language());
        assertEquals(1437752133, (long) userDetails.getLast_battle_time());
        assertEquals(6853373, (long) userDetails.getAccount_id());
        assertEquals(1338151261, (long) userDetails.getCreated_at());
        assertEquals(1502231920, (long) userDetails.getUpdated_at());
        assertEquals(1229, userDetails.getGlobal_rating());
        assertEquals(null, userDetails.getClan_id());
        assertEquals("lizo4ka1997", userDetails.getNickname());
        assertEquals(1437751771, (long) userDetails.getLogout_at());
    }

    @Test
    public void privateUserSectionTest() throws Exception {
        assertEquals(315, (long) privateData.getGold());
        assertEquals(5600, (long) privateData.getFree_xp());
        assertEquals(null, privateData.getBan_time());
        assertEquals(false, privateData.isBoundToPhone());
        assertEquals(false, privateData.isPremium());
        assertEquals(204747, (long) privateData.getCredits());
        assertEquals(0, (long) privateData.getPremium_expires_at());
        assertEquals(0, (long) privateData.getBonds());
        assertEquals(191089, (long) privateData.getBattle_life_time());
        assertEquals(null, privateData.getBan_info());

        Restrictions restrictions = privateData.getRestrictions();
        assertEquals(null, restrictions.getChat_ban_time());
    }

    @Test
    public void statisticTest() throws Exception {
        assertEquals(8, stats.getStatisticsList().size());
        assertEquals(226, stats.getTrees_cut());
    }

    @Test
    public void fragsInStatisticTest() throws Exception {
        List<Frag> frags = stats.getFrags();

        assertEquals(106, frags.size());

        assertEquals(new Frag(8017, 3), frags.get(3));
        assertEquals(new Frag(1825, 7), frags.get(17));
        assertEquals(new Frag(257, 1), frags.get(57));
        assertEquals(new Frag(7505, 10), frags.get(105));
    }

    @Test
    public void allSectionStatisticTest() throws Exception {
        AbstractStatistic s = stats.getStatisticsList().get(1);
        assertEquals(TeamAndHistoricalStatistic.class, s.getClass());

        TeamAndHistoricalStatistic stat = (TeamAndHistoricalStatistic) s;

        assertEquals("all", stat.getStatisticSectionName());

        assertEquals(924, stat.getSpotted());
        assertEquals(0, stat.getBattles_on_stunning_vehicles());
        assertEquals(779, stat.getMax_xp());
        assertEquals(37.77, stat.getAvg_damage_blocked(), delta);
        assertEquals(3278, stat.getDirect_hits_received());
        assertEquals(70, stat.getExplosion_hits());
        assertEquals(2236, stat.getPiercings_received());
        assertEquals(1288, stat.getPiercings());
        assertEquals(6401, (int) stat.getMax_damage_tank_id());
        assertEquals(140490, stat.getXp());
        assertEquals(155, stat.getSurvived_battles());
        assertEquals(212, stat.getDropped_capture_points());
        assertEquals(36, stat.getHits_percents());
        assertEquals(10, stat.getDraws());
        assertEquals(6401, (int) stat.getMax_xp_tank_id());
        assertEquals(991, stat.getBattles());
        assertEquals(154498, stat.getDamage_received());
        assertEquals(60.37, stat.getAvg_damage_assisted(), delta);
        assertEquals(2353, (long) stat.getMax_frags_tank_id());
        assertEquals(4.52, stat.getAvg_damage_assisted_track(), delta);
        assertEquals(456, stat.getFrags());
        assertEquals(0, stat.getStun_number());
        assertEquals(55.86, stat.getAvg_damage_assisted_radio(), delta);
        assertEquals(1139, stat.getCapture_points());
        assertEquals(0, stat.getStun_assisted_damage());
        assertEquals(868, stat.getMax_damage());
        assertEquals(3326, stat.getHits());
        assertEquals(142, stat.getBattle_avg_xp());
        assertEquals(442, stat.getWins());
        assertEquals(539, stat.getLosses());
        assertEquals(107983, stat.getDamage_dealt());
        assertEquals(1042, stat.getNo_damage_direct_hits_received());
        assertEquals(5, stat.getMax_frags());
        assertEquals(9288, stat.getShots());
        assertEquals(29, stat.getExplosion_hits_received());
        assertEquals(0.21, stat.getTanking_factor(), delta);
    }
}
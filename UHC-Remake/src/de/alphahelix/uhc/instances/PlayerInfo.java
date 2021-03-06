package de.alphahelix.uhc.instances;

import de.alphahelix.alphalibary.UUID.UUIDFetcher;
import org.bukkit.OfflinePlayer;

import java.util.UUID;

/**
 * Created by AlphaHelixDev.
 */
public class PlayerInfo {

    private String name;
    private UUID uuid;
    private long games, kills, deaths, coins, points, wins;
    private long normalC, uncommonC, rareC, superrareC, epicC, legendaryC;
    private String kits, achievements;

    public PlayerInfo(OfflinePlayer p, long games, long kills, long deaths, long coins, long points, long wins, long normalC, long uncommonC, long rareC, long superrareC, long epicC, long legendaryC, String kits, String achievements) {
        this.name = p.getName();
        this.uuid = UUIDFetcher.getUUID(p.getName());
        this.games = games;
        this.kills = kills;
        this.deaths = deaths;
        this.coins = coins;
        this.points = points;
        this.wins = wins;
        this.normalC = normalC;
        this.uncommonC = uncommonC;
        this.rareC = rareC;
        this.superrareC = superrareC;
        this.epicC = epicC;
        this.legendaryC = legendaryC;
        this.kits = kits;
        this.achievements = achievements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public long getGames() {
        return games;
    }

    public void setGames(long games) {
        this.games = games;
    }

    public long getKills() {
        return kills;
    }

    public void setKills(long kills) {
        this.kills = kills;
    }

    public long getDeaths() {
        return deaths;
    }

    public void setDeaths(long deaths) {
        this.deaths = deaths;
    }

    public long getCoins() {
        return coins;
    }

    public void setCoins(long coins) {
        this.coins = coins;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public long getWins() {
        return wins;
    }

    public void setWins(long wins) {
        this.wins = wins;
    }

    public long getNormalC() {
        return normalC;
    }

    public void setNormalC(long normalC) {
        this.normalC = normalC;
    }

    public long getUncommonC() {
        return uncommonC;
    }

    public void setUncommonC(long uncommonC) {
        this.uncommonC = uncommonC;
    }

    public long getRareC() {
        return rareC;
    }

    public void setRareC(long rareC) {
        this.rareC = rareC;
    }

    public long getSuperrareC() {
        return superrareC;
    }

    public void setSuperrareC(long superrareC) {
        this.superrareC = superrareC;
    }

    public long getEpicC() {
        return epicC;
    }

    public void setEpicC(long epicC) {
        this.epicC = epicC;
    }

    public long getLegendaryC() {
        return legendaryC;
    }

    public void setLegendaryC(long legendaryC) {
        this.legendaryC = legendaryC;
    }

    public String getKits() {
        return kits;
    }

    public void setKits(String kits) {
        this.kits = kits;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }
}

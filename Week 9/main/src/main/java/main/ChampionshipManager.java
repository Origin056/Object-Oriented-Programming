package main;

import java.util.List;

public class ChampionshipManager
{
    private static ChampionshipManager instance;
    private List<Driver> drivers;
    private List<RallyRaceResult> races;
    private static int totalDrivers = 0;
    private static int totalRaces = 0;

    private ChampionshipManager() {}

    public static ChampionshipManager getInstance() {
        if(instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
        totalDrivers++;
    }

    public void addRaceResult(RallyRaceResult result) {
        races.add(result);
        totalRaces++;
    }

    public List<Driver> getDriverStandings() {
        return drivers;
    }

    public static Driver getLeadingDriver() {
        ChampionshipManager manager = getInstance();

        Driver leader = null;

        for(Driver d : manager.drivers) {
            if (leader == null || d.getPoints() > leader.getPoints()) {
                leader = d;
            }
        }

        return leader;
    }

    public static int getTotalChampionshipPoints() {
        ChampionshipManager manager = getInstance();
        int total = 0;

        for (Driver d : manager.drivers) {
            total += d.getPoints();
        }

        return total;
    }

    public static int getTotalRaces() {
        return totalRaces;
    }

    public static int getTotalDrivers() {
        return totalDrivers;
    }
}
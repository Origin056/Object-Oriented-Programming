package main;

import java.util.ArrayList;
import java.util.List;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers;
    private List<RallyRaceResult> races;
    private static int totalDrivers = 0;
    private static int totalRaces = 0;

    private ChampionshipManager() {
        drivers = new ArrayList<>();
        races = new ArrayList<>();
    }

    public static ChampionshipManager getInstance() {
        if (instance == null) {
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
        List<Driver> standings = new ArrayList<>(drivers);
        standings.sort((d1, d2) -> Integer.compare(d2.getPoints(), d1.getPoints()));
        return standings;
    }

    public static Driver getLeadingDriver() {
        if (instance == null || instance.drivers.isEmpty()) return null;
        Driver leader = instance.drivers.get(0);
        for (Driver d : instance.drivers) {
            if (d.getPoints() > leader.getPoints()) {
                leader = d;
            }
        }
        return leader;
    }

    public static int getTotalChampionshipPoints() {
        if (instance == null) return 0;
        int total = 0;
        for (Driver d : instance.drivers) {
            total += d.getPoints();
        }
        return total;
    }
    
    public List<Driver> getDrivers() { return drivers; }
    public List<RallyRaceResult> getRaces() { return races; }
    public static int getTotalDrivers() { return totalDrivers; }
    public static int getTotalRaces() { return totalRaces; }
}

package main;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChampionshipStatistics
{
    public static double calculateAveragePointsPerDriver(List<Driver> drivers) {
        if(drivers.isEmpty()) return 0;

        int total = drivers.stream().mapToInt(Driver::getPoints).sum();
        return (double) total / drivers.size();
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        Map<String, Integer> countryPoints = new HashMap<>();

        for(Driver d : drivers) {
            countryPoints.put(d.getCountry(), countryPoints.getOrDefault(d.getCountry(), 0) + d.getPoints());
        }

        return Collections.max(countryPoints.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static int getTotalRacesHeld() {
        return ChampionshipManager.getTotalRaces();
    }
}
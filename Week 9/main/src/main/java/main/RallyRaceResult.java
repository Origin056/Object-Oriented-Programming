package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RallyRaceResult implements RaceResult
{
    private String raceName;
    private String location;
    private Map<Driver, Integer> results;

    public RallyRaceResult(String raceName, String location) {
        this.raceName = raceName;
        this.location = location;
    }

    public String getRaceName() {
        return raceName;
    }

    public String gatLocation() {
        return location;
    }

    @Override
    public void recordResult(Driver driver, int position, int points) {
        results.put(driver, points);
        driver.addPoints(points);
    }

    @Override
    public int getDriverPoints(Driver driver) {
        return results.getOrDefault(driver, 0);
    }

    @Override
    public List<Driver> getResults() {
        return new ArrayList<>(results.keySet());
    }
}
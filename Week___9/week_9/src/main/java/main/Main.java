package main;

import java.util.List;
public class Main {

    public static void main(String[] args) {
        ChampionshipManager manager = ChampionshipManager.getInstance();

        GravelCar toyotaGravel = new GravelCar("Toyota", "Yaris Rally1", 380, 233.5);
        AsphaltCar hyundaiAsphalt = new AsphaltCar("Hyundai", "i20 N Rally1", 380, 560.0);
        GravelCar fordGravel = new GravelCar("Ford", "Puma Rally1", 370, 250.0);
        AsphaltCar toyotaAsphalt = new AsphaltCar("Toyota", "Yaris Rally1", 380, 560.0);

        Driver ogier = new Driver("Sébastien Ogier", "France", toyotaGravel);
        Driver rovanpera = new Driver("Kalle Rovanperä", "Finland", toyotaGravel);
        Driver tanak = new Driver("Ott Tänak", "Estonia", fordGravel);
        Driver neuville = new Driver("Thierry Neuville", "Belgium", hyundaiAsphalt);

        manager.registerDriver(ogier);
        manager.registerDriver(rovanpera);
        manager.registerDriver(tanak);
        manager.registerDriver(neuville);

        RallyRaceResult finlandRally = new RallyRaceResult("Rally Finland", "Jyväskylä");
        finlandRally.recordResult(ogier, 1, 25);
        finlandRally.recordResult(tanak, 2, 18);
        finlandRally.recordResult(rovanpera, 3, 15);
        finlandRally.recordResult(neuville, 4, 12);
        manager.addRaceResult(finlandRally);

        ogier.setCar(toyotaAsphalt);
        rovanpera.setCar(toyotaAsphalt);

        RallyRaceResult monteCarlo = new RallyRaceResult("Monte Carlo Rally", "Monaco");
        monteCarlo.recordResult(rovanpera, 1, 25);
        monteCarlo.recordResult(neuville, 2, 18);
        monteCarlo.recordResult(ogier, 3, 15);
        monteCarlo.recordResult(tanak, 4, 12);
        manager.addRaceResult(monteCarlo);

        List<Driver> standings = manager.getDriverStandings();
        for (int i = 0; i < standings.size(); i++) {
            Driver d = standings.get(i);
            System.out.println((i + 1) + ". " + d.getName() + " (" + d.getCountry() + "): " + d.getPoints() + " points");
        }

        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        Driver leader = ChampionshipManager.getLeadingDriver();
        if (leader != null) {
            System.out.println(leader.getName() + " with " + leader.getPoints() + " points");
        }

        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + ChampionshipManager.getTotalDrivers());
        System.out.println("Total Races: " + ChampionshipStatistics.getTotalRacesHeld());
        System.out.printf("Average Points Per Driver: %.2f\n", ChampionshipStatistics.calculateAveragePointsPerDriver(manager.getDrivers()));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(manager.getDrivers()));
        System.out.println("Total Championship Points: " + ChampionshipManager.getTotalChampionshipPoints());

        System.out.println("\n===== RACE RESULTS =====");
        for (RallyRaceResult race : manager.getRaces()) {
            System.out.println("Race: " + race.getRaceName() + " (" + race.getLocation() + ")");
            int pos = 1;
            for (Driver d : race.getResults()) {
                System.out.println("Position " + pos + ": " + d.getName() + " - " + race.getDriverPoints(d) + " points");
                pos++;
            }
        }

        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + toyotaGravel.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + toyotaAsphalt.calculatePerformance());
    }
}
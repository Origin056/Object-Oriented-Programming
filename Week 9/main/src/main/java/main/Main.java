package main;

public class Main 
{
    public static void main( String[] args )
    {
        ChampionshipManager manager = ChampionshipManager.getInstance();

        RallyCar gravelCar = new GravelCar("Toyota", "GR Yaris", 380, 12.5);
        RallyCar asphaltCar = new AsphaltCar("Hyundai", "i20 N", 380, 30);

        Driver ogier = new Driver("Sebastien Ogier", "France", gravelCar);
        Driver rovanpera = new Driver("Kalle Rovanpera", "Finland", asphaltCar);
        Driver tanak = new Driver("Ott Tanak", "Estonia", gravelCar);
        Driver neuville = new Driver("Thierry Neuville", "Belgium", asphaltCar);

        manager.registerDriver(ogier);
        manager.registerDriver(rovanpera);
        manager.registerDriver(tanak);
        manager.registerDriver(neuville);

        RallyRaceResult finland = new RallyRaceResult("Rally Finland", "Jyväskylä");

        finland.recordResult(ogier, 1, 25);
        finland.recordResult(tanak, 2, 18);
        finland.recordResult(rovanpera, 3, 15);
        finland.recordResult(neuville, 4, 12);

        manager.addRaceResult(finland);

        RallyRaceResult monaco = new RallyRaceResult("monte Carlo Rally", "Monaco");

        monaco.recordResult(rovanpera, 1, 25);
        monaco.recordResult(neuville, 2, 18);
        monaco.recordResult(ogier, 3, 15);
        monaco.recordResult(tanak, 4, 12);

        manager.addRaceResult(monaco);

        System.out.println("===== CHAMPIONSHIP STANDINGS =====");
        for (Driver d : manager.getDriverStandings()) {
            System.out.println(d.getName() + " (" + d.getCountry() + "): " + d.getPoints() + " points");
        }

        Driver leader = manager.getLeadingDriver();
        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        System.out.println(leader.getName() + " with " + leader.getPoints() + " points");

        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + ChampionshipManager.getTotalDrivers());
        System.out.println("Total Races: " + ChampionshipManager.getTotalRaces());
        System.out.println("Average Points Per Driver: " + ChampionshipStatistics.calculateAveragePointsPerDriver(manager.getDriverStandings()));
        System.out.println("Most Successful Country: " +
                ChampionshipStatistics.findMostSuccessfulCountry(manager.getDriverStandings()));
        System.out.println("Total Championship Points: " +
                manager.getTotalChampionshipPoints());

        // Performance
        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + gravelCar.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + asphaltCar.calculatePerformance());
    }
}

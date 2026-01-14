package Controller;

import Model.Fine;
import Model.Vehicle;
import Model.TrafficEvent;
import Service.TrafficEventService;

import java.util.List;
import java.util.Scanner;

public class ConsoleController {

    private final TrafficEvent TrafficEventService;
    private final Vehicle VehicleService;
    private final Fine FineService;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleController( TrafficEvent trafficEventService,  Fine fineService, Vehicle vehicleService) {
        TrafficEventService = trafficEventService;
        VehicleService = vehicleService;
        FineService = fineService;
    }

    public void run() {
        while (true) {
            printMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showAllData();

                case 0 -> {
                    return;
                }
            }
        }
    }

    private void printMenu() {
    }

    public void showAllData() {
        List<Fine> drivers = FineService.getAllDrivers();
        List<TrafficEvent> TrafficEvent = TrafficEventService.getAllEvent();
        List<Vehicle> Vehicle = VehicleService.getAllVehicle();

        System.out.println("Drivers loaded: " + fines.size());
        System.out.println("Events loaded: " + events.size());
        System.out.println("Penalties loaded: " + vehicles.size() + "\n");

        drivers.forEach(System.out::println);
    }
}

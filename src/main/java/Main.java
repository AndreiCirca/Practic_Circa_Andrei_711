import Controller.ConsoleController;
import Model.Fine;
import Model.TrafficEvent;
import Model.Vehicle;
import Repository.VehicleRepository;
import Repository.TrafficEventRepository;
import Repository.FineRepository;
import Service.VehicleService;
import Service.TrafficEventService;
import Service.FineService;

public class Main {

    public static void main(String[] args) {
        run();
    }

    public static void run() {

        VehicleRepository VehicleRepository =
                new VehicleRepository("src/data/vehicles.json");
        VehicleService vehicleService =
                new VehicleService(VehicleRepository);

        TrafficEventRepository eventRepository =
                new TrafficEventRepository("src/data/events.json");
        TrafficEventService EventService =
                new TrafficEventService(eventRepository);

        FineRepository FineRepository =
                new FineRepository("src/data/fines.json");
        FineService fineService =
                new FineService(FineRepository);




    }
}
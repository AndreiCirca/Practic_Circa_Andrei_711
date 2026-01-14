package Service;

import Model.VehicleType;
import Repository.VehicleRepository;

import java.util.List;

public class VehicleService {

    private final VehicleService VehicleRepository;


    public VehicleService(VehicleRepository vehicleRepository) {
        VehicleRepository = vehicleRepository;
    }

    public List<VehicleType> getAllVehicles() {
        return VehicleRepository.getAllVehicles();
    }
}
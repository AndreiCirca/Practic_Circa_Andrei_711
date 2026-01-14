package Repository;

import Model.Fine;
import Model.FineReason;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepository {

    private final String filePath;

    public VehicleRepository(String filePath) {
        this.filePath = filePath;
    }

    public List<Fine> getAllFine() {
        List<Fine> fines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int id = 0;
            int vehicleId = 0;
            int amount = 0;
            int timeslot = 0;
            int reason = 0;
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("\"id\"")) {
                    id = Integer.parseInt(extractValue(line));
                } else if (line.startsWith("\"vehicleId\"")) {
                    vehicleId = Integer.parseInt(extractValue(line));
                } else if (line.startsWith("\"reason\"")) {
                    reason = FineReason.valueOf(extractValue(line)).ordinal();
                } else if (line.startsWith("\"amount\"")) {
                    amount = Integer.parseInt(extractValue(line));
                } else if (line.startsWith("\"timeslot\"")) {
                    timeslot = Integer.parseInt(extractValue(line));
                }

                if (line.equals("},") || line.equals("}")) {
                    fines.add(new Fine(id, vehicleId, amount, timeslot, reason));
                    id = 0;
                    vehicleId = 0;
                    amount = 0;
                    timeslot = 0;
                    reason = 0;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return fines;
    }

    private String extractValue(String line) {
        String[] parts = line.split(":", 2);
        return parts.length > 1 ? parts[1].replace(",", "").replace("\"", "").trim() : "";
    }
}

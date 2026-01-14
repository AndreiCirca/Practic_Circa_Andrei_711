// java
package Repository;

import Model.Fine;
import Model.FineReason;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FineRepository {

    private final String filePath;

    public FineRepository(String filePath) {
        this.filePath = filePath;
    }

    public List<Fine> getAllFines() {
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
                    id = parseIntSafe(extractValue(line), 0);
                } else if (line.startsWith("\"vehicleId\"")) {
                    vehicleId = parseIntSafe(extractValue(line), 0);
                } else if (line.startsWith("\"reason\"")) {
                    String val = extractValue(line);
                    reason = parseReasonSafe(val);
                } else if (line.startsWith("\"amount\"")) {
                    amount = parseIntSafe(extractValue(line), 0);
                } else if (line.startsWith("\"timeslot\"")) {
                    timeslot = parseIntSafe(extractValue(line), 0);
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

    public Optional<Fine> findById(int searchId) {
        return getAllFines().stream().filter(f -> f.getId() == searchId).findFirst();
    }

    private int parseIntSafe(String s, int defaultVal) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return defaultVal;
        }
    }

    private int parseReasonSafe(String s) {
        if (s == null || s.isEmpty()) return 0;
        // Try as enum name
        try {
            return FineReason.valueOf(s).ordinal();
        } catch (Exception ignored) {
        }
        // Try as integer
        try {
            return Integer.parseInt(s);
        } catch (Exception ignored) {
        }
        return 0;
    }

    private String extractValue(String line) {
        String[] parts = line.split(":", 2);
        return parts.length > 1 ? parts[1].replace(",", "").replace("\"", "").trim() : "";
    }
}

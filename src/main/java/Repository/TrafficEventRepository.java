package Repository;

import Model.TrafficEvent;
import Model.EventType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TrafficEventRepository {

    private final String filePath;

    public TrafficEventRepository(String filePath) {
        this.filePath = filePath;
    }

    public List<TrafficEvent> getAllEvents() {

        List<TrafficEvent> events = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            int id = 0, vehicleId = 0, severity = 0;
            EventType eventType = null;

            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("\"id\"")) {
                    id = Integer.parseInt(extractValue(line));

                } else if (line.startsWith("\"vehicleId\"")) {
                    vehicleId = Integer.parseInt(extractValue(line));

                } else if (line.startsWith("\"severity\"")) {
                    severity = Integer.parseInt(extractValue(line));

                } else if (line.startsWith("\"eventType\"")) {
                    eventType = EventType.valueOf(extractValue(line));
                }

                if (line.equals("},") || line.equals("}")) {
                    events.add(new TrafficEvent(id, vehicleId, eventType, severity));

                    id = 0;
                    vehicleId = 0;
                    severity = 0;
                    eventType = null;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return events;
    }

    private String extractValue(String line) {
        return line.split(":")[1]
                .replace(",", "")
                .replace("\"", "")
                .trim();
    }

    public void saveReport(Map<EventType, Integer> report) {

        try (FileWriter writer = new FileWriter("src/data/traffic_report.txt")) {

            for (Map.Entry<EventType, Integer> entry : report.entrySet()) {
                writer.write(entry.getKey() + " -> " + entry.getValue() + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package Model;

public class TrafficEvent {
    private int id;
    private int VehicleId;
    private EventType type;
    private int severity;
    private int timeslot;

    public TrafficEvent(int id, int vehicleId, int eventtype, int severity, int timeslot) {
        this.id = id;
        VehicleId = vehicleId;
        EventType = eventtype;
        this.severity = severity;
        this.timeslot = timeslot;
    }

    public TrafficEvent(int id, int vehicleId, EventType eventType, int severity) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(int vehicleId) {
        VehicleId = vehicleId;
    }

    public int getEventtype() {
        return EventType;
    }

    public void setEventtype(int eventtype) {
        EventType = eventtype;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public int getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(int timeslot) {
        this.timeslot = timeslot;
    }

    @Override
    public String toString() {
        return "TrafficEvent{" +
                "id=" + id +
                ", VehicleId=" + VehicleId +
                ", EventType=" + EventType +
                ", severity=" + severity +
                ", timeslot=" + timeslot +
                '}';
    }
}

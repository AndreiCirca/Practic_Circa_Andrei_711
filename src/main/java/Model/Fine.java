package Model;

import java.util.List;

public class Fine {
    private int id;
    private int vehicleId;
    private FineReason reason;
    private int amount;
    private int timeslot;

    public Fine(int id, int vehicleId, int reason, int amount, int timeslot) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.reason = reason;
        this.amount = amount;
        this.timeslot = timeslot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public FineReason getReason() {
        return reason;
    }

    public void setReason(FineReason reason) {
        this.reason = reason;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(int timeslot) {
        this.timeslot = timeslot;
    }

    @Override
    public String toString() {
        return "Fine{" +
                "id=" + id +
                ", vehicleId=" + vehicleId +
                ", reason=" + reason +
                ", amount=" + amount +
                ", timeslot=" + timeslot +
                '}';
    }



}

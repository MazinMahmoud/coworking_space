package coworking_space;

public class Slot {
    private String time;
    private String date;
    private double fees;

    public Slot(String time, String date, double fees) {
        this.time = time;
        this.date = date;
        this.fees = fees;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public double getFees() {
        return fees;
    }
}
interface Reservable {
    boolean reserveSlot(Slot slot, Vistor visitor);
    boolean cancelReservation(Slot slot, Vistor visitor);
    boolean updateReservation(Slot oldSlot, Slot newSlot, Vistor visitor);
    void displayAvailableSlots();
}

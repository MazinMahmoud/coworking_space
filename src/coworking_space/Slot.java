package coworking_space;
import org.w3c.dom.ls.LSOutput;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class Slot {
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate date;
    private double fees;
    private boolean isReserved;
    private String roomID;
    public Slot(LocalTime startTime, LocalTime endTime, LocalDate date, double fees, boolean isReserved,String roomID) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.fees = fees;
        this.isReserved = false;
        this.roomID = roomID;
   }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getFees() {
        return fees;
    }
    public void reserve() {
        if (!this.isReserved) {
            this.isReserved = true;
            System.out.println("Slot reserved");
        } else {
            System.out.println("Slot is already reserved.");
        }
    }
    public void cancelReservation() {
        if (this.isReserved) {
            this.isReserved = false;
            System.out.println("Reservation cancelled");
        } else {
            System.out.println("There is no reservation to cancel");
        }
    }
    public void updateSlot(LocalTime newStartTime, LocalTime newEndTime, LocalDate newDate, double newFees) {
        if (!isReserved) {
            setStartTime(newStartTime);
            setEndTime(newEndTime);
            setFees(newFees);
            setDate(newDate);
            System.out.println("Slot updated");

        } else {

            System.out.println("Slot update failed");
        }
    }
    }

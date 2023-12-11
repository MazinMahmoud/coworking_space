package coworking_space;
import org.w3c.dom.ls.LSOutput;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class Slot {
    private LocalTime time;
    private LocalDate date;
    private double fees;
    //public static int counter;
    //private static int array_of_slots[][]= new int [8][25];
    //private static String dayName;
    private boolean isReserved;
    public Slot(LocalTime time, LocalDate date, double fees, boolean isReserved) {
        this.time = time;
        this.date = date;
        this.fees = fees;
        this.isReserved = false;
        //counter=0;

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

    public void updateSlot(LocalTime newTime, LocalDate newDate, double newFees) {
        if (newTime != null) {
            this.time = newTime;
        }
        if (newDate != null) {
            this.date = newDate;
        }
        if (newFees >= 0) {
            this.fees = newFees;
        }
        System.out.println("Slot updated");
    }
    /*public static void reserve_aslot(int day,int from_h,int to_h){
        for (int i=from_h;i<=to_h;i++){

            array_of_slots[day][i]=counter;


        }
        counter++;
    }
    public static void display_slots(int day,int from_h,int to_h) {
        switch (day) {
            case 1:
                dayName = "Saturday";
                break;
            case 2:
                dayName = "Sunday";
                break;
            case 3:
                dayName = "Monday";
                break;
            case 4:
                dayName = "Tuesday";
            case 5:
                dayName = "Wednesday";
                break;
            case 6:
                dayName = "Thursday";
                break;
            case 7:
                dayName = "Friday";
                break;
        }
        System.out.println("we have on" + dayName);
        for (int i = from_h; i <= to_h; i++) {

            if (array_of_slots[day][i] <20) {

                System.out.println("in " + i + ":00" +array_of_slots[day][i]+"person");


            }

        }
    }*/
        public LocalTime getTime() {
        return time;
    }

        public LocalDate getDate() {
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
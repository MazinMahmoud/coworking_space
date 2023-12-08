package coworking_space;

import java.util.Arrays;

public class Slot {
    private String time;
    private String date;
    private double fees;
    private boolean array_of_slots[][]= new boolean[8][25];
    private String dayName;
    public Slot(String time, String date, double fees) {
        this.time = time;
        this.date = date;
        this.fees = fees;
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 24; j++) {
                array_of_slots[i][j] = true;
            }
        }

    }
    public void reserve_aslot(int day,int from_h,int to_h){
        for (int i=from_h;i<=to_h;i++){

            array_of_slots[day][i]=false;

        }
    }
    public void display_slots(int day,int from_h,int to_h)
    {
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
        }
        System.out.println("we have on"+dayName);
        for(int i=from_h;i<=to_h;i++)
        {
            if (array_of_slots[day][i]){

                System.out.println("in "+i+":00");

                }

            }



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
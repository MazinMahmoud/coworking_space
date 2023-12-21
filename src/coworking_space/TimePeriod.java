package coworking_space;
import java.util.ArrayList;

public class TimePeriod {
    private ArrayList<String> userName;
    private int hour;
    public boolean reserved;


    public TimePeriod(int hour) {
       userName=new ArrayList<>();

        this.hour = hour;

        this.reserved = false;


    }

    public void cancel_reservation( String name) {
        this.userName.remove(name);


    }


    public ArrayList<String> getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName.add(userName);
    }

    public int getHour() {
        return hour;
    }

    public void setTimeSlot(int newHour) {
        this.hour = newHour;
    }


}


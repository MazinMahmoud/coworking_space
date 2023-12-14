package coworking_space;
import org.w3c.dom.ls.LSOutput;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Slot {
    private ArrayList<String> userName;
    private int hour;
    public boolean reserved;


    public Slot(int hour) {
       userName=new ArrayList<>();

        this.hour = hour;

        this.reserved = false;


    }

    public void cancel_reservation( String name) {
        this.userName.remove(name );


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


package coworking_space;
import org.w3c.dom.ls.LSOutput;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Slot {
    private String userName;
    private int hour;
    public boolean reserved;
    public int number_of_reservation;

    public Slot (String userName, int hour) {

        this.userName = userName;
        this.hour= hour;
        number_of_reservation=0;
        this.reserved=false;


    }
    public void setNumber_of_reservation(){
       ++ number_of_reservation;
    }
    public void cansle_reservation(){
        this.userName="";

        number_of_reservation-=1;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int gethour() {
        return hour;
    }

    public void setTimeSlot(int newhour) {
        this.hour = newhour;
    }
    }




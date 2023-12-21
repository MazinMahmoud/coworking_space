package coworking_space;

import java.util.ArrayList;

public abstract class Room {
    protected String name;
    protected int ID;
    int maxVisitors;

    public TimePeriod schedule[][]=new TimePeriod[31][25];



    //constructors
    public Room(String name, int ID, int maxVisitors) {
        this.name = name;
        this.ID = ID;
        this.maxVisitors = maxVisitors;


        for (int day=0;day<=30;day++)
        {
            for (int h = 8; h <= 24; h++)
            {
                schedule[day][h] = new TimePeriod(h);
            }
        }
    }

    abstract int  calc_fees(String name);
    void reserve_range (int day,int from_h,int to_h,String username){
        for (int res=from_h ;res<to_h;res++){
            reserve_hours(day,res,username);
        }
    }
    void reserve_hours(int day,int h,String name){
        if (!check_reserve(day,h))
        {
            schedule[day][h].reserved=true;
            schedule[day][h].getUserName().add(name);
        }
        else System.out.println("there is no place !");

    }
    boolean check_reserve(int day ,int h){

        if (schedule[day][h].getUserName().size()>=maxVisitors) {
            return true;
        }
        return false ;

    }


    void cancel_reservation(int day,int h,String name_user){
        schedule[day][h].cancel_reservation(name_user);
    }
    void cancel_reservation(String name ){
        for (int day=1;day<30;day++){
            for (int h=8;h<24;h++){
                if (schedule[day][h].getUserName().contains(name)){
                    schedule[day][h].cancel_reservation(name);
                    System.out.println("canceled successfully");
                }

            }
        }
    }


    public void display_avaliable_reservation(int day){
        for (int i=8;i<=24;i++){
            int next_hour = i+1;
            if (!check_reserve(day,i)) System.out.println(i+" - "+next_hour+" On " + day);
        }
    }
    void update(int day,int from_h,int to_h, String name ){
        cancel_reservation(name);
        reserve_range(day, from_h, to_h, name);
    }
//    public abstract boolean IsAvailable();
}
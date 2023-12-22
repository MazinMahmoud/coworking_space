package coworking_space;

import java.util.ArrayList;

public abstract class Room {
    protected final String name;
    protected int ID;
    final int maxVisitors;
    static  int  fees;
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
    boolean flag=true;

    void reserve_range (int day,int from_h,int to_h,String username){
        for (int res=from_h ;res<to_h;res++){
            reserve_hours(day,res,username);
        }
        if (flag)
        System.out.println("reservation done to "+username);
        else System.out.println("there is no place !");
    }
    void reserve_hours(int day,int h,String name){
        if (!check_reserve(day,h))
        {
            schedule[day][h].reserved=true;
            schedule[day][h].getUserName().add(name);
            flag=true;
        }
        else flag=false;

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
//    public int calcfeesforallusers(String name) {
//        int count_hours = 0;
//        if (name.equals(this.name)) {
//            for (int day = 0; day < 30; day++) {
//                for (int hour = 8; hour <= 24; hour++) {
//                    for (int i = 0; i < schedule[day][hour].getUserName().size(); ++i) {
//                        if (schedule[day][hour].getUserName().get(i) != null) {
//                            count_hours++;
//                        }
//                    }
//                }
//            }
//        }
//
//
//
//        return count_hours*fees;
//    }


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
    public int calcNoOfReservations(String username) {
        int noOfReservations=0;
            for (int day = 0; day < 30; day++) {
                for (int hour = 8; hour <= 24; hour++) {
                    for (int i = 0; i < schedule[day][hour].userName.size(); ++i) {
                        if (schedule[day][hour].userName.get(i).equals(username) ) {
                            noOfReservations++;
                        }
                    }
                }
            }




        return noOfReservations;
    }

    public int calcfeesforallusers(String name) {
        int count_hours = 0;
        if (name.equals(this.name)) {
            for (int day = 0; day < 30; day++) {
                for (int hour = 8; hour <= 24; hour++) {
                    for (int i = 0; i < schedule[day][hour].userName.size(); ++i) {
                        if (schedule[day][hour].userName.get(i) != null) {
                            count_hours++;
                        }
                    }
                }
            }
        }



        return count_hours*fees;
    }
//    public abstract boolean IsAvailable();
}
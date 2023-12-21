package coworking_space;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
Scanner scan = new Scanner(System.in);
   public void Display_available_slots_rooms(Room room){


      System.out.println("Enter the day you want to see the availabe slots on:\n");
      int day = scan.nextInt();
      room.display_avaliable_reservation(day);
      }

    public void display_visitors(ArrayList<Visitor> visitors, Room [] rooms) {
        System.out.println("Visitor ID\tVisitor type\tVisitor username\tVisitor password\tNumber of reservations\t");
        for (Visitor vis : visitors) {
            System.out.println(vis.getId() + "\t" + vis.VistorType + "\t" + vis.username + "\t" + vis.password + "\t" +);
        }
    }
    public int calcFeesForAUser(Room room,String username){
           return room.calc_fees(username);
        }
    public int calcFeesForACertainRoom(Room room){
       return room.calcfeesforallusers;
    }




}

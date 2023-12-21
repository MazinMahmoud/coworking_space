package coworking_space;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
Scanner scan = new Scanner(System.in);
   public void Display_available_slots_rooms(Room room){
//fix

      System.out.println("Enter the day you want to see the availabe slots on:\n");
      int day = scan.nextInt();
      room.display_avaliable_reservation(day);
      }

    public void display_visitors(ArrayList<Visitor> visitors, Room  rooms) {
        System.out.println("Visitor ID\tVisitor type\tVisitor username\tVisitor password\tNumber of reservations\t");
        for (Visitor vis : visitors) {
            System.out.println(vis.getId() + "\t" + vis.VistorType + "\t" + vis.username + "\t" + vis.password + "\t"+ rooms.calcNoOfReservations(vis.getUsername()));
        }
    }
    public int calcFeesForAUser(Room room,String username){
           return room.calc_fees(username);
        }
    public int calcFeesForGeneralRoom(General_room[] generalRooms){
       int totalAmount =0;
       System.out.println("The total amount of money from the general room:\n");
       for(General_room general:generalRooms){
           totalAmount+=general.calcfeesforallusers("General");
       }
       return totalAmount;
    }
    public int calcFeesForMeetingRoom(Meeting_Room[] meetingRooms){
        int totalAmount =0;
        System.out.println("The total amount of money from the meeting room:\n");
        for(Meeting_Room general:meetingRooms){
            totalAmount+=general.calcfeesforallusers("Meeting");
        }
        return totalAmount;
    }
    public int calcFeesForTeachingRoom(Teaching_Room[] teachingRooms){
        int totalAmount =0;
        System.out.println("The total amount of money from the Teaching room:\n");
        for(Teaching_Room teaching:teachingRooms){
            totalAmount+=teaching.calcfeesforallusers("Teaching");
        }
        return totalAmount;
    }




}

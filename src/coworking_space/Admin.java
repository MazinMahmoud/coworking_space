
package coworking_space;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    Scanner scan = new Scanner(System.in);

    public void Display_available_slots_rooms(Room room) {
//fix

        System.out.println("Enter the day you want to see the availabe slots on:\n");
        int day = scan.nextInt();
        room.display_avaliable_reservation(day);
    }

//    public void display_visitors(ArrayList<Visitor> visitors, Room rooms) {
//        System.out.println("Visitor ID\tVisitor type\tVisitor username\tVisitor password\tNumber of reservations\t");
//        for (Visitor vis : visitors) {
//            System.out.println(vis.getId() + "\t" + vis.VistorType + "\t" + vis.username + "\t" + vis.password + "\t" + rooms.calcNoOfReservations(vis.getUsername()));
//        }
//    }

    public int calcFeesForAUser(Room room, String username) {
        return room.calc_fees(username);
    }

    public int calcFeesForGeneralRoom(General_room[] generalRooms) {
        int totalAmount = 0;
        System.out.println("The total amount of money from the general room:\n");
        for (General_room general : generalRooms) {
            totalAmount += general.calcfeesforallusers("General");
        }
        return totalAmount;
    }

    public int calcFeesForMeetingRoom(Meeting_Room[] meetingRooms) {
        int totalAmount = 0;
        System.out.println("The total amount of money from the meeting room:\n");
        for (Meeting_Room general : meetingRooms) {
            totalAmount += general.calcfeesforallusers("Meeting");
        }
        return totalAmount;
    }

    public int calcFeesForTeachingRoom(Teaching_Room[] teachingRooms) {
        int totalAmount = 0;
        System.out.println("The total amount of money from the Teaching room:\n");
        for (Teaching_Room teaching : teachingRooms) {
            totalAmount += teaching.calcfeesforallusers("Teaching");
        }
        return totalAmount;
    }

    void admin_update_any_entity(ArrayList<Visitor> user, General_room[] generalRooms, Teaching_Room[] teachingRooms) {
        System.out.println("Enter the user'id  ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println("Which entity you want to update:\n 1-user name  \n2-password\n3-Visitor type \n4-update \n5-cancel reservation");
        int choice = scanner.nextInt();
        int choice_room =
                user.get(id - 1).choice_room;
        switch (choice) {
            case 1:
                System.out.println("Enter new username :");
                String new_usernam = scanner.next();
                user.get(id - 1).username = new_usernam;
                break;
            case 2:
                System.out.println("Enter new password :");
                String new_password = scanner.next();
                user.get(id - 1).password = new_password;
                break;
            case 3:
                boolean flag = true;
                while (flag) {
                    System.out.println("Enter new Visitor type: \n 1- General\n2-Formal\n3-Instructor");
                    int visitor_type = scanner.nextInt();
                    switch (visitor_type) {
                        case 1:
                            user.get(id - 1).VistorType = "General";
                            flag = false;
                            break;
                        case 2:
                            user.get(id - 1).VistorType = "Formal";
                            flag = false;
                            break;
                        case 3:
                            user.get(id - 1).VistorType = "Instructor";
                            flag = false;
                            break;
                        default:
                            System.out.println("invalid choice!\nif  you want to continue =>press y");
                            String choic = scanner.next();
                            if (choic == "y") flag = true;
                            else flag = false;

                    }
                }
            case 4:

                System.out.println("Enter the new day \n");
                int day = scanner.nextInt();
                System.out.println("Enter start hour:");
                int starthour = scanner.nextInt();
                System.out.println("Enter end hour:");
                int endhour = scanner.nextInt();
                if (user.get(id - 1).VistorType == "General") {
                    generalRooms[choice_room].update(day, starthour, endhour, user.get(id - 1).username);
                    System.out.println("updated successfully:)");
                } else if (user.get(id - 1).VistorType == "Formal") {
                    //  meetingRooms[choice_room].update(day,starthour,endhour,user.get(id-1).username);
                    System.out.println("updated successfully:)");

                } else {
                    teachingRooms[choice_room].update(day, starthour, endhour, user.get(id - 1).username);
                    System.out.println("updated successfully:)");

                }
                break;


            case 5:


                if (user.get(id - 1).VistorType == "General") {
                    generalRooms[choice_room].cancel_reservation(user.get(id - 1).username);
                    System.out.println("updated successfully:)");
                } else if (user.get(id - 1).VistorType == "Formal") {
                    //meetingRooms[choice_room].cancel_reservation(user.get(id-1).username);
                    System.out.println("updated successfully:)");

                } else {
                    teachingRooms[choice_room].cancel_reservation(user.get(id - 1).username);
                    System.out.println("updated successfully:)");
                }
                break;


        }


    }


}
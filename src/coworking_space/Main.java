/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package coworking_space;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    private static void WriteUserFile(File file, ArrayList<Visitor> Users) throws IOException {


        // this function is implemented to abide with the document's requirments.
        FileWriter writer1 = new FileWriter(file);

        writer1.write(Users.get(0).getUsername() + ":" + Users.get(0).getPassword() + '\n');
        writer1.close();

        for (int i = 1; i < Users.size(); ++i) {
            FileWriter writer2 = new FileWriter(file, true);

            writer2.append(Users.get(i).getUsername() + ":" + Users.get(i).getPassword() + '\n');
            writer2.close();
        }


    }
    private static ArrayList<Visitor> ReadUserFile(File file) {
        String path = file.getAbsolutePath();
        ArrayList<Visitor> Users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length >= 2) {
                    Visitor takingUser = new Visitor(parts[0], parts[1],parts[2]);
                    Users.add(takingUser);
                }
            }

        } catch (IOException eslam) {
            eslam.printStackTrace();
        }

        return Users;
    }
    private static Teaching_Room[]  ReadTeachingRooms(File file){
        String path = file.getAbsolutePath();
        Teaching_Room [] teachingRooms  = {
                new Teaching_Room("laser", "white_board", 1, 10, "teaching room", 200),
                new Teaching_Room("DLP", "white_board", 2, 10, "teaching room", 200),
                new Teaching_Room("laser", "white_board", 3, 10, "teaching room", 200)
        };

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(":");
                if (parts.length >= 2) {
                    teachingRooms[Integer.parseInt(parts[0])-1].reserve_hours(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),parts[3]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return teachingRooms;
    }
    private static General_room[]  ReadGeneralRooms(File file){
        String path = file.getAbsolutePath();
        General_room [] generalRooms  = {
                new General_room("General", 1),
                new General_room("General", 2),
                new General_room("General", 3)
        };

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(":");
                if (parts.length >= 2) {
                    generalRooms[Integer.parseInt(parts[0])-1].reserve_hours(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),parts[3]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return generalRooms;
    }
    private static Meeting_Room[]  ReadMeetingRooms(File file){
        String path = file.getAbsolutePath();
        Meeting_Room [] meetingRooms  = {
                new Meeting_Room("Meeting", 1),
                new Meeting_Room("Meeting", 2),
                new Meeting_Room("General", 3)
        };

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(":");
                if (parts.length >= 2) {
                    meetingRooms[Integer.parseInt(parts[0])-1].reserve_hours(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),parts[3]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return meetingRooms;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("info.txt");
        File file2 = new File("Teaching_Rooms.txt");
        File file3 = new File("General_Rooms.txt");
        File file4 = new File("Meeting_Rooms.txt");
        Scanner scan = new Scanner(System.in);
        //READING

        ArrayList<Visitor> Users = ReadUserFile(file);
        Teaching_Room [] teachingRooms  = ReadTeachingRooms(file2);
        General_room [] generalRooms    = ReadGeneralRooms(file3);
        Meeting_Room[] meetingRooms = ReadMeetingRooms(file4);
        String username;
        String password;
        int Reserve_day;
        boolean admin=false;
        String VisitorType = null;

        while (true) {
            System.out.println("If you are new user press R to register ,otherwise press any key to login"); //should be fixed when implementing javafx
            boolean Register = true;
            boolean LoggedIn = false;
            String c = scan.nextLine();
            if (c.equalsIgnoreCase("R")) {
                System.out.println("Enter your new username: ");
                username = scan.nextLine();
                System.out.println("Enter your new password:");
                password = scan.nextLine();
                System.out.println("Which type of visitor are you?\n"+
                                    "1. Instructor\n"+
                                    "2. Formal\n"+
                                    "3. General\n");

                int choice = scan.nextInt();
                switch(choice){
                    case 1 ->{
                        VisitorType = "Instructor";
                    }
                    case 2 ->{
                        VisitorType = "Formal";
                    }
                    case 3->{
                        VisitorType = "General";
                    }
                    default -> {
                        System.out.println("Invalid number, Please try again!");
                        continue;
                    }
                }



                for (Visitor users : Users) {
                    if (users.getUsername().equals(username)) {
                        System.out.println("This username is already taken, please enter another one!");
                        Register = false;
                        break;
                    }
                }
                if (Register) {
                    Visitor newUser = new Visitor(username, password,VisitorType);
                    Users.add(newUser);
                    System.out.println("You're now registered!");
                    continue;
                }

            } else {
                System.out.println("Please enter your username:");
                username = scan.nextLine();
                System.out.println("Please enter your password:");
                password = scan.nextLine();
                for (Visitor user : Users) {
                    if (username.equals("admin")&& password.equals("admin"))
                    {
                        admin=true;
                        LoggedIn = true;
                        System.out.println("Welcome admin!\n");
                        break;
                    }

                    if (user.getUsername().equals(username)) {
                        if (user.getPassword().equals(password)) {
                            System.out.println("Welcome " + username + "!\n");
                            LoggedIn = true;
                            VisitorType = user.VistorType;
                            break;
                        }
                    }
                }


                if (!LoggedIn) {
                    System.out.println("Invalid username or password! please try again!\n");
                }


            }
            if (LoggedIn)
                break;


        }
        if(admin)
        {
            Admin admins = new Admin ();
        }
        else
        {
            int choice;
            while(true)
            {
                System.out.println("Press 1 to make new Reservation");
                System.out.println("Press 2 to Update Reservation");
                System.out.println("Press 3 to Cancel Reservation");
                choice = scan.nextInt();
                switch (choice)
                {
                    case 1 -> {
                        System.out.println("Enter the day you want to reserve on\n");
                        Reserve_day=scan.nextInt();

                        switch (VisitorType) {
                            case "General" ->                             {
                                for(int i = 1;i<=2;++i)
                                {
                                    System.out.println("Here are the available reservation times for General room"+ i);
                                    generalRooms[i-1].display_avaliable_reservation(Reserve_day);

                                }   System.out.println("Which room do you want to reserve?");
                                    int roomchoice=scan.nextInt();

                                System.out.println("Starting hour");
                                int Starthour=scan.nextInt();
                                System.out.println("Ending hour");
                                int endhour=scan.nextInt();
                                generalRooms[roomchoice-1].reserve_range (Reserve_day, Starthour,endhour, username);
                            }
                            case "Instructor" ->                             {
                                for(int i = 1;i<=3;++i)
                                {
                                    System.out.println("Here are the available reservation times for Teaching room "+ i);
                                    teachingRooms[i-1].display_avaliable_reservation(Reserve_day);

                                }   System.out.println("which room do you want to reserve?");
                                int roomchoice=scan.nextInt();
                                Users.get(Users.indexOf(username)).choice_room=roomchoice;
                                System.out.println("Starting hour");
                                int Starthour=scan.nextInt();
                                System.out.println("ending hour");
                                int endhour=scan.nextInt();
                                teachingRooms[roomchoice-1].reserve_range (Reserve_day, Starthour,endhour, username);
                            }
                            default ->                             {
                                for(int i = 1;i<=3;i++)
                                {
                                    System.out.println("Here are the available reservation times for Meeting room"+ i);
                                    generalRooms[i-1].display_avaliable_reservation(Reserve_day);

                                }   System.out.println("which room do you want to reserve?" );
                                int roomchoice=scan.nextInt();
                                System.out.println("Starting hour" );
                                int Starthour=scan.nextInt();
                                System.out.println("Ending hour" );
                                int endhour=scan.nextInt();
                               meetingRooms [roomchoice-1].reserve_range (Reserve_day, Starthour,endhour, username);                            }
                        }
                    }
                    case 2 -> System.out.println(3);


                }
            }


        }


        WriteUserFile(file, Users);






//
//test el method|
//   Teaching_Room room1=new Teaching_Room("","",1,3,"",100);
//    int today=1;
//    room1.display_avaliable_reservation(today);
//  int t=new Scanner(System.in).nextInt();
//    room1.reserve_range(today,t,24,"m");
//        System.out.println(room1.calc_fees("m"));
//       int v=new Scanner(System.in).nextInt();
//       room1.reserve_hours(today,v,"mostafa");
//       int n=new Scanner(System.in).nextInt();
//       room1.reserve_hours(today,n,"mohamed");
//       room1.display_avliable_reservation(today);
//       room1.cansle_reservationrby_username("m");
//       room1.display_avliable_reservation(today);
//
//        }


    }
}
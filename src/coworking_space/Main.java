/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package coworking_space;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Visitor> ReadUserFile(File file) {
        String path = file.getAbsolutePath();
        ArrayList<Visitor> Users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length >= 2) {
                    Visitor takingUser = new Visitor(parts[0], parts[1], parts[2]);
                    Users.add(takingUser);
                }
            }

        } catch (IOException eslam) {
            eslam.printStackTrace();
        }

        return Users;
    }

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

    public static Teaching_Room[] ReadTeachingRooms(File file) {
        String path = file.getAbsolutePath();
        Teaching_Room[] teachingRooms = {
                new Teaching_Room("laser", "white_board", 1, 10, "Teaching", 200),
                new Teaching_Room("DLP", "white_board", 2, 10, "Teaching", 200),
                new Teaching_Room("laser", "white_board", 3, 10, "Teaching", 200)
        };
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(":");
                if (parts.length >= 2) {
                    teachingRooms[Integer.parseInt(parts[0])].reserve_hours(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), parts[3]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return teachingRooms;
    }


    public static void main(String[] args) throws IOException {
        File file = new File("info.txt");
        File file2 = new File("Teaching_Rooms.txt");
        Scanner scan = new Scanner(System.in);
        ArrayList<Visitor> Users = ReadUserFile(file);

        String username;
        String password;
        String VisitorType = "General";
        int Reserve_day;
        boolean admin = false;
        Teaching_Room[] teachingRooms = ReadTeachingRooms(file2);
        General_room generalRooms[] = {
                new General_room("general room", 1, 20, 10),
                new General_room("general room", 2, 20, 10)
        };

        while (true) {
            System.out.println("If you are new user, press R to register otherwise press any key to login"); //should be fixed when implementing javafx
            boolean Register = true;
            boolean LoggedIn = false;
            String c = scan.nextLine();
            if (c.equalsIgnoreCase("R")) {
                System.out.println("Enter your new username: ");
                username = scan.nextLine();


                System.out.println("Enter your new password:");
                password = scan.nextLine();
                System.out.println("Are you a formal visitor or a an instructor or a general vis");
                VisitorType = scan.nextLine();

                for (User users : Users) {
                    if (users.getUsername().equals(username)) {
                        System.out.println("This username has been taken before, please enter another valid one!");
                        Register = false;
                        break;

                    }
                }
                if (Register) {
                    User newUser = new Visitor(username, password, VisitorType);
                    Users.add((Visitor) newUser);

                    System.out.println("You're now registered!");
                    break;
                }
            } else {
                System.out.println("Please enter your username:");
                username = scan.nextLine();
                System.out.println("Please enter your password:");
                password = scan.nextLine();
                for (User user : Users) {
                    if (username.equals("admin") && password.equals("admin")) {
                        admin = true;
                        LoggedIn = true;
                        System.out.println("Welcome admin");
                        break;
                    }

                    if (user.getUsername().equals(username)) {
                        if (user.getPassword().equals(password)) {
                            System.out.println("Welcome " + username);
                            LoggedIn = true;
                            break;
                        }
                    }
                }


                if (!LoggedIn) {
                    System.out.println("Error: Invalid Username or password! please try again!");
                }


            }
            if (LoggedIn)
                break;


        }
        if (admin) {
            Admin admins = new Admin();
            int choice;
            while (true) {
                System.out.println("Press 1 to Calculate total income from General Rooms");
                System.out.println("Press 2 to Calculate total income from Meeting Rooms");
                System.out.println("Press 3 to Calculate total income from Teaching Rooms");
                System.out.println("Press 4 to display visitors' data:");
                try {
                    choice = Integer.parseInt(scan.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }
                switch (choice) {
                    case 1 -> {
                        System.out.println(admins.calcFeesForGeneralRoom(generalRooms)/2);
                        break;
                    }
                    case 2->{
                        break;
                    }
                    case 3 ->{
                        System.out.println(admins.calcFeesForTeachingRoom(teachingRooms)/2);
                        break;
                    }
                    case 4 ->{
                        if(VisitorType.equalsIgnoreCase("general"))
                        for(int i =0;i<3;++i)
                        admins.display_visitors(Users,generalRooms[i]);
                        else if(VisitorType.equalsIgnoreCase("Instructor"))
                            for(int i = 0;i<2;++i)
                            admins.display_visitors(Users,teachingRooms[i]);
                    }
                }
                break;
            }
        } else {

            int choice;

            while (true) {
                System.out.println("Press 1 to make new Resarvation");
                System.out.println("Press 2 to Update Resarvation");
                System.out.println("Press 3 to Cancel Resarvation");
                choice = scan.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("ENTER the day");
                        Reserve_day = scan.nextInt();

                        switch (VisitorType) {
                            case "General" -> {
                                for (int i = 1; i <= 2; ++i) {
                                    System.out.println("here is the avalble slots for General room" + i);
                                    generalRooms[i - 1].display_avaliable_reservation(Reserve_day);

                                }
                                System.out.println("choose roomnumber u want to reserve in");
                                int roomchoice = scan.nextInt();
                                System.out.println("Starting hour");
                                int Starthour = scan.nextInt();
                                System.out.println("ending hour");
                                int endhour = scan.nextInt();
                                for (int i = Starthour; i <= endhour; i++)
                                    generalRooms[roomchoice - 1].reserve_hours(Reserve_day, i, username);
                                System.out.println("reservation done successfully to :" + username);
                            }
                            case "Instructor" -> {
                                for (int i = 1; i <= 3; ++i) {
                                    System.out.println("here is the avalble slots for Teaching room" + i);
                                    teachingRooms[i - 1].display_avaliable_reservation(Reserve_day);

                                }
                                System.out.println("choose roomnumber u want to reserve in");
                                int roomchoice = scan.nextInt();
                                System.out.println("Starting hour");
                                int Starthour = scan.nextInt();
                                System.out.println("ending hour");
                                int endhour = scan.nextInt();
                                for (int i = Starthour; i <= endhour; i++)
                                    teachingRooms[roomchoice - 1].reserve_hours(Reserve_day, i, username);
                                System.out.println("reservation done successfully to :" + username);
                            }
                            default -> {
                                for (int i = 1; i <= 3; ++i) {
                                    System.out.println("here is the avalble slots for Meeting room" + i);
                                    generalRooms[i - 1].display_avaliable_reservation(Reserve_day);

                                }
                                System.out.println("choose roomnumber u want to reserve in");
                                int roomchoice = scan.nextInt();
                                System.out.println("Starting hour");
                                int Starthour = scan.nextInt();
                                System.out.println("ending hour");
                                int endhour = scan.nextInt();
                                for (int i = Starthour; i <= endhour; i++)
                                    generalRooms[roomchoice - 1].reserve_hours(Reserve_day, i, username);
                                System.out.println("reservation done successfully to :" + username);
                            }
                        }
                    }
                    case 2 -> System.out.println(3);


                }
            }
        }




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
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package coworking_space;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Main {
//    private static ArrayList<User> ReadUserFile(File file) {
//        String path = file.getAbsolutePath();
//        ArrayList<User> Users = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(":");
//                if (parts.length >= 2) {
//                    User takingUser = new User(parts[0], parts[1]);
//                    Users.add(takingUser);
//                }
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return Users;
//    }
//
//    private static void WriteUserFile(File file, ArrayList<User> Users) throws IOException {
//
//
//        // this function is implemented to abide with the document's requirments.
//        FileWriter writer1 = new FileWriter(file);
//
//        writer1.write(Users.get(0).getUsername() + ":" + Users.get(0).getPassword() + '\n');
//        writer1.close();
//
//        for (int i = 1; i < Users.size(); ++i) {
//            FileWriter writer2 = new FileWriter(file, true);
//
//            writer2.append(Users.get(i).getUsername() + ":" + Users.get(i).getPassword() + '\n');
//            writer2.close();
//        }
//
//
//    }
//

    public static void main(String[] args) throws IOException {
//        File file = new File("C:\\Users\\Ismail\\IdeaProjects\\coworking_space\\src\\info.txt");
//        Scanner scan = new Scanner(System.in);
//        ArrayList<User> Users = ReadUserFile(file);
//        String username;
//        String password;
//
//        while (true) {
//            System.out.println("If you are new user, press R to register otherwise press any key to login"); //should be fixed when implementing javafx
//            boolean Register = true;
//            boolean LoggedIn = false;
//            String c = scan.nextLine();
//            if (c.equalsIgnoreCase("R")) {
//                System.out.println("Enter your new username: ");
//                username = scan.nextLine();
//
//
//                System.out.println("Enter your new password:");
//                password = scan.nextLine();
//
//                for (User users : Users) {
//                    if (users.getUsername().equals(username)) {
//                        System.out.println("This username has been taken before, please enter another valid one!");
//                        Register = false;
//                        break;
//
//                    }
//                }
//                if (Register) {
//                    User newUser = new User(username, password);
//                    Users.add(newUser);
//                    System.out.println("You're now registered!");
//                    break;
//                }
//            } else {
//                System.out.println("Please enter your username:");
//                username = scan.nextLine();
//                System.out.println("Please enter your password:");
//                password = scan.nextLine();
//                for (User user : Users) {
//                    if (user.getUsername().equals(username)) {
//                        if (user.getPassword().equals(password)) {
//                            System.out.println("Welcome " + username);
//                            LoggedIn = true;
//                            break;
//                        }
//                    }
//                }
//
//
//                if (!LoggedIn) {
//                    System.out.println("Error: Invalid Username or password! please try again!");
//                }
//
//
//            }
//            if (LoggedIn)
//                break;
//
//        }
//        WriteUserFile(file, Users);

//test el method|
    Teaching_Room room1=new Teaching_Room("","","",3,"",10);
    int today=1;
    room1.display_avliable_reservation(today);
    int t=new Scanner(System.in).nextInt();
    room1.reserve_hours(today,t,"m");
       int v=new Scanner(System.in).nextInt();
       room1.reserve_hours(today,v,"mostafa");
       int n=new Scanner(System.in).nextInt();
       room1.reserve_hours(today,n,"mohamed");
       room1.display_avliable_reservation(today);
       room1.cansle_reservationrby_username("m");
       room1.display_avliable_reservation(today);

        }


       }


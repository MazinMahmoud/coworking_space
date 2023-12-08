/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package coworking_space;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("info.txt");
        Scanner scan = new Scanner(System.in);


        while(true) {
            System.out.println("If you are new user, press r to register otherwise press any key to login"); //should be fixed when implementing javafx

            String c = scan.nextLine();
            if (c.toUpperCase().equals("R")) {
                System.out.println("Enter your new username: ");
                String username = scan.nextLine();

                System.out.println("Enter your new password:");//should fix it as *** with JavaFX
                String password = scan.nextLine();

                if (User.Register(password, username, file)) {
                    System.out.println("You are now registered!");
                    break;
                } else {
                    System.out.println("This username has been taken before, please enter another one!");
                }
            } else {
                System.out.println("Please enter your username:");
                String username = scan.nextLine();
                System.out.println("Please enter your password:");//should fix it as *** with JavaFX
                String password = scan.nextLine();
                User.Login(username, password, file);
                if (User.Login(username, password, file)) {
                    System.out.println("Welcome!");
                    break;
                } else{ System.out.println("Please try again");
                }


            }
        }

//bgrb el method
//        Slot s1=new Slot("","",0);
//        s1.reserve_aslot(2,5,24);
//        s1.display_slots(2,1,12);



    }
    
}

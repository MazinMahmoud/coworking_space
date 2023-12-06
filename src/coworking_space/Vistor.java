package coworking_space;

import java.util.Scanner;

public class Vistor extends User {
    public String VistorType;
    // General = 1, Formal = 2, Instructor = 3
    public int ID;

    //ID will be used by admin to get vistor info
    public Vistor(int ID) {
        this.ID = ID;
    }


    public void Reserve() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a username");
        this.username = scanner.next();
        System.out.println("Please enter a password");
        this.password = scanner.next();
        System.out.println("Would you like to reserve a (1-General \n 2-Meeting \n 3-Teaching) Room ?");
        int numberTEMP = scanner.nextInt();

        // User was not supposed to enter string to avoid spelling mistakes and errors also to be easier for him


        if(numberTEMP == 1){
            this.VistorType = "General";
        }
        else if(numberTEMP == 2) {
            this.VistorType = "Formal";
        }
        else {
            this.VistorType = "Instructor";
        }
    }

    public void MakeReservation(){
        if(this.VistorType.equals("General"))
        {
            //available slots in general rooms + slots class usage
        }
        else if(this.VistorType.equals("Formal")){

        }
        else{

        }

    }

    public void CancelReservation(){

    }

    public void UpdateReservation(){

    }

    public void DisplayReservation(){

    }
}
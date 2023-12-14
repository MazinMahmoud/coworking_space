package coworking_space;

import java.util.Scanner;

public class Vistor  {
    protected String VistorType;
    // General = 1, Formal = 2, Instructor = 3
    //ID will be used by admin to get vistor info



    public void Reserve(User s) {
        Scanner scanner = new Scanner(System.in);


        // User was not supposed to enter string to avoid spelling mistakes and errors also to be easier for him

    while(true) {
        System.out.println("Would you like to reserve a (1-General \n 2-Meeting \n 3-Teaching Room ?");
        int numberTEMP = scanner.nextInt();
        if (numberTEMP == 1) {
            this.VistorType = "General";break;
        } else if (numberTEMP == 2) {
            this.VistorType = "Formal";break;
        } else if (numberTEMP == 3) {
            this.VistorType = "Instructor";break;
        } else System.out.println("Invalid number, try again.");
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
package coworking_space;

public class General_room extends Room{


     int fees = 20;

    public General_room(String name, int ID ){
        super("General", ID,20);
    }

    int calc_fees (String name){
        int count_hours=0;
        for (int day =0;day<30;day ++){
            for (int hour =8;hour<=24;hour++ ){

                if (schedule[day][hour].getUserName().contains(name)){


                    count_hours++;
                }
            }
        }

        return (fees *count_hours);

    }

}

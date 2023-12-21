package coworking_space;

public class General_room extends Room{



    public General_room(String name, int ID, int maxVisitors, int fees ){
        super(name, ID, maxVisitors);
     this.fees=fees;
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

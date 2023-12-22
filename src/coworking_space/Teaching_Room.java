package coworking_space;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Teaching_Room extends Room {

    private String projector_Type ;
    private String board_Type;




    Teaching_Room(String pro_Type,String board_type, int ID, int max,String room_name,int room_fees ){
        super(room_name, ID,max);
        this.projector_Type=pro_Type;
        this.board_Type=board_type;
        this .fees=room_fees;

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


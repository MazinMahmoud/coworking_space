package coworking_space;

public class Teaching_Room extends Room {
    private String projector_Type ;
    private String board_Type;
    protected String instructor_name ;

    Teaching_Room(String pro_Type,String board_type,String name, int ID, int max,String room_name,double room_fees ){
        super(room_name, ID,max,room_fees);
        this.projector_Type=pro_Type;
        this.board_Type=board_type;
        this.instructor_name=name;
    }
    public boolean IsAvaliable(){
        boolean avaliable =true;

        return avaliable;
    }

}

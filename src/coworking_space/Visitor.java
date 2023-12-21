package coworking_space;

import java.util.ArrayList;

public class Visitor extends User {
    protected String VistorType;
    public int choice_room;
    public Visitor(String username, String password, String VistorType){
        super(username,password);
        this.VistorType = VistorType;
    }


    public String getVistorType(){
        return VistorType;
    }


}
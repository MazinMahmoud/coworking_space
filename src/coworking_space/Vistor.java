package coworking_space;

import java.util.Scanner;

public class Vistor extends User {
    protected String VistorType;
    public Vistor(String username,String password,String VistorType){
        super(username,password);
        this.VistorType = VistorType;
    }
    public String getVistorType(){
        return VistorType;
    }


}
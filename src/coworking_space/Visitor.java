package coworking_space;

public class Visitor extends User {
    protected String VistorType;
    public Visitor(String username, String password, String VistorType){
        super(username,password);
        this.VistorType = VistorType;
    }


    public String getVistorType(){
        return VistorType;
    }


}
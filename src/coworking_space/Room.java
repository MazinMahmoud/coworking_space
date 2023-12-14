package coworking_space;

public class Room extends Reserve{
    public String name ;
    protected int maxVisitors;
    Room (String n,int m,double f){
        super(m,f);
        this.name=n;

    }




}

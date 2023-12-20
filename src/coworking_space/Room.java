package coworking_space;

import java.util.ArrayList;

public abstract class Room {
    protected String name;
    protected int ID;
    int maxVisitors;
    double fees;
    public TimePeriod schedule[][]=new TimePeriod[31][25];



    //constructors
    public Room(String name, int ID, int maxVisitors, double fees) {
        super(maxVisitors, fees);
        this.name = name;
        this.ID = ID;

    }
//    public abstract boolean IsAvailable();
}


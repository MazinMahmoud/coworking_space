package coworking_space;

public abstract class Room extends Reserve{
    protected String name;
    protected int ID;

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    //getters
    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }


    //constructors
    public Room(String name, int ID, int maxVisitors, double fees) {
        super(maxVisitors, fees);
        this.name = name;
        this.ID = ID;

    }
//    public abstract boolean IsAvailable();
}


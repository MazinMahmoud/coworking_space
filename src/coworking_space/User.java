package coworking_space;

public abstract class User {
    protected String username;
    protected String password;
    protected int ID;

    public User(String username,String password){
        this.username = username;
        this.password = password;
    }
    public User(){

    }

    public abstract void Register();
    public static String Login(String password, String username){
        if(username.equals("admin") && password.equals("admin")){
            return "admin";
        }
        else return "";// katb ay 7aga a4an error

    }



}

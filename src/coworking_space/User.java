package coworking_space;
import java.io.*;
import java.util.Scanner;

public class User {
    protected String username;
    protected String password;
    protected static int ID=0;


    public User(String username,String password,int ID){
        this.username = username;
        this.password = password;
    }
    public User(String username,String password){
        this(username,password,ID);
        ID++;

    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }

    public static int getId() {

        return ID;
    }

    public static boolean Login(String password, String username, File file) throws IOException {
       return checkCredintials(file,username,password,false);
    }
    public static boolean Register(String password,String username,File file) throws IOException{
            if (checkCredintials(file,username,password,true)){
                FileWriter writer = new FileWriter(file,true);

                return true;
            }
             return false;

    }


       private static boolean checkCredintials(File file,String username,String password,boolean register) throws IOException {
           BufferedReader reader = new BufferedReader(new FileReader(file));
           String line;
           while ((line = reader.readLine()) != null) {
               String[] parts = line.split("\\s+");


               if(register){

                   if (parts.length == 2 && parts[0].equals(username)){
                       reader.close();
                       return false;
                   }

               }
               else {
                   if (parts.length == 2 && parts[0].equals(username)) {
                       if (parts[1].equals(password)) {
                           reader.close();
                           return true;
                       }
                   }

               }
           }
           if(register)
           return true;
           return false;
       }




}

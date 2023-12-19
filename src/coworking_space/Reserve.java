package coworking_space;

public class Reserve {

int maxVisitor;
double fees;
    public Slot schedule[][]=new Slot[31][25];
public Reserve(int max,double fees){
    this.maxVisitor=max;
    this.fees= fees;

    for (int day=0;day<=30;day++) {
        for (int h = 0; h <= 24; h++) {
            schedule[day][h] = new Slot(h);
        }
    }
}
void reserve_range (int day,int from_h,int to_h,String username){
    for (int res=from_h ;res<to_h;res++){
        reserve_hours(day,res,username);
    }
}
void reserve_hours(int day,int h,String name){
    if (!check_reserve(day,h))
        {
    schedule[day][h].reserved=true;
    schedule[day][h].getUserName().add(name);
    System.out.println("reservation done successfully to :"+name);
        }
    else System.out.println("there is no place !");

}
boolean check_reserve(int day ,int h){

    if (schedule[day][h].getUserName().size()>=maxVisitor) {
        return true;
    }
    return false ;

    }

    void cancel_reservation(int day,int h,String name_user){
    schedule[day][h].cancel_reservation(name_user);
    }
    void cancel_reservation(String name ){
    for (int day=1;day<30;day++){
        for (int h=8;h<24;h++){
            if (schedule[day][h].getUserName().contains(name)){
                schedule[day][h].cancel_reservation(name);
                System.out.println("canceled successfully");
            }

        }
    }

    }

void display_avliable_reservation(int day){
    for (int i=8;i<=24;i++ ){
        if (!check_reserve(day,i)) System.out.println(i+"valid"+(maxVisitor-schedule[day][i].getUserName().size()));
    }
}
void update(int day,int from_h,int to_h, String name ){
    cancel_reservation(name);
    reserve_range(day, from_h, to_h, name);
}
}

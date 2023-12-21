package coworking_space;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.*;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
public class Slots {
    LocalTime time;
    LocalDate date;
    float fees;
    static int number_of_visitors = 0;
    public Slots(LocalTime time,LocalDate date){
        this.time = time;
        this.date = date;
    }



}

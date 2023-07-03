import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class date {
    public static void main(String[] args) {
        LocalDate date=LocalDate.of(2022,5,12);
        System.out.println(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String d="12/02/2022";
        LocalDate localDate=LocalDate.parse(d,formatter);
    }
}

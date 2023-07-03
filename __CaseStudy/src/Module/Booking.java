package Module;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Booking {
    private int idCustomer;
    private LocalDate start;
    private LocalDate end;
    private String idService;

    public Booking() {
    }

    public Booking(int idCustomer, LocalDate start, LocalDate end, String idService) {
        this.idCustomer = idCustomer;
        this.start = start;
        this.end = end;
        this.idService = idService;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.idCustomer+", "+formatter.format(this.start)+", "+formatter.format(this.end)+", "+this.idService;
    }
}

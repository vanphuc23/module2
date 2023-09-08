package Module;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Constract implements Comparable<Constract> {
    private int idConstract;
    private int idCustomer;
    private LocalDate startDB;
    private LocalDate endDB;
    private String idService;

    public Constract() {
    }

    public Constract(int idConstract, int idCustomer, LocalDate startDB, LocalDate endDB, String idService) {
        this.idConstract = idConstract;
        this.idCustomer = idCustomer;
        this.startDB = startDB;
        this.endDB = endDB;
        this.idService = idService;
    }

    public int getIdConstract() {
        return idConstract;
    }

    public void setIdConstract(int idConstract) {
        this.idConstract = idConstract;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public LocalDate getStartDB() {
        return startDB;
    }

    public void setStartDB(LocalDate startDB) {
        this.startDB = startDB;
    }

    public LocalDate getEndDB() {
        return endDB;
    }

    public void setEndDB(LocalDate endDB) {
        this.endDB = endDB;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.idConstract + ", " + this.idCustomer + ", " + formatter.format(this.startDB) + ", " + formatter.format(this.endDB) + ", " + this.idService;
    }

    @Override
    public int compareTo(Constract o) {
        if (this.getStartDB().isBefore(o.getStartDB())) {
            return -1;
        } else {
            return 1;
        }
    }
}

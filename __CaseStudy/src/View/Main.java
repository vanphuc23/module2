package View;

import Controller.FuramaController;
import Exception.NotFoundEmployeeException;
public class Main {
    public static void main(String[] args) throws NotFoundEmployeeException {
        FuramaController furamaController=new FuramaController();
        furamaController.displayMainMenu();
    }
}
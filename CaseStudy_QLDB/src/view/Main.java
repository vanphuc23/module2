package view;

import controller.DBController;

public class Main {
    public static void main(String[] args) {
        DBController dbController=new DBController();
        dbController.menu();
    }
}

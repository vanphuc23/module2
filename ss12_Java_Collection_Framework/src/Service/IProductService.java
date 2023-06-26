package Service;

import Model.Product;

import java.util.ArrayList;

public interface IProductService {
    void display();

    ArrayList<Product> add();

    ArrayList<Product> editId();

    ArrayList<Product> removeId();

    void searchName();

    void sortUp();

    void sortDown();
}

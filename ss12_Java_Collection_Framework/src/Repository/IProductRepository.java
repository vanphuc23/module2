package Repository;

import Model.Product;

import java.util.ArrayList;

public interface IProductRepository {
    ArrayList<Product> findAll();

    void sortUp();

    void sortDown();
}

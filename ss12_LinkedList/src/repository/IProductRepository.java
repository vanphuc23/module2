package repository;

import model.Product;

import java.util.LinkedList;

public interface IProductRepository {
    LinkedList<Product> displayAll();

    void sortUp();

    void sortDown();
}

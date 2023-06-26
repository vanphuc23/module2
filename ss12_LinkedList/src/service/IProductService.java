package service;

import java.util.LinkedList;

import model.Product;

public interface IProductService {
    void display();

    LinkedList<Product> addProduct();

    LinkedList<Product> remove();

    LinkedList<Product> repairName();

    void searchName();

    void up();

    void down();
}

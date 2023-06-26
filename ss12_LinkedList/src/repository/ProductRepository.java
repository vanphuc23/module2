package repository;

import model.Product;

import java.util.Comparator;
import java.util.LinkedList;

public class ProductRepository implements IProductRepository {
    static LinkedList<Product> products = new LinkedList<>();
    static {
        products.add(new Product(1, "Keo", 5000));
        products.add(new Product(2, "Banh", 2000));
        products.add(new Product(3, "Nuoc", 10000));
    }

    @Override
    public LinkedList<Product> displayAll() {
        return products;
    }

    @Override
    public void sortUp() {
        Comparator<Product> comparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice() > o2.getPrice() ? 1 : -1;
            }
        };
        products.sort(comparator);
    }

    @Override
    public void sortDown() {
        Comparator<Product> comparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice() < o2.getPrice() ? 1 : -1;
            }
        };
        products.sort(comparator);
    }
}

package Repository;

import Model.Product;

import java.util.ArrayList;
import java.util.Comparator;

public class ProductRepository implements IProductRepository {
    static ArrayList<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Kẹo", 5000));
        products.add(new Product(2, "Bánh", 2000));
        products.add(new Product(3, "Nước", 10000));
    }

    @Override
    public ArrayList<Product> findAll() {
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

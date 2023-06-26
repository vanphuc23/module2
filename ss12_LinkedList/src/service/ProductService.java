package service;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

import model.Product;
import repository.IProductRepository;
import repository.ProductRepository;

public class ProductService implements IProductService {
    private IProductRepository repository = new ProductRepository();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        System.out.println(repository.displayAll());
    }

    @Override
    public LinkedList<Product> addProduct() {
        System.out.println("Nhap id: ");
        int newId = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap ten san pham: ");
        String newName = scanner.nextLine();
        System.out.println("Nhap gia san pham: ");
        double newPrice = Double.parseDouble(scanner.nextLine());
        Product product = new Product(newId, newName, newPrice);
        for (int i = 0; i < repository.displayAll().size(); i++) {
            if (newId == repository.displayAll().get(i).getId()) {
                System.out.println("San pham bi trung id!!!");
                return null;
            }
        }
        repository.displayAll().add(product);
        return repository.displayAll();
    }

    @Override
    public LinkedList<Product> remove() {
        System.out.println("Nhap id muon xoa: ");
        int removeId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < repository.displayAll().size(); i++) {
            if (removeId == repository.displayAll().get(i).getId()) {
                repository.displayAll().remove(i);
                return repository.displayAll();
            }
        }
        System.out.println("Khong ton tai id " + removeId + " trong danh sach!!!");
        return null;
    }

    @Override
    public LinkedList<Product> repairName() {
        System.out.println("Nhap id ban muon sua: ");
        int repairId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < repository.displayAll().size(); i++) {
            if (repairId == repository.displayAll().get(i).getId()) {
                System.out.println("Nhap ten san pham: ");
                String newName = scanner.nextLine();
                System.out.println("Nhap gia san pham: ");
                double newPrice = Double.parseDouble(scanner.nextLine());
                Product product = new Product(repairId, newName, newPrice);
                repository.displayAll().set(i, product);
                return repository.displayAll();
            }
        }
        System.out.println("Khong tim thay id trong danh sach:");
        return null;
    }

    @Override
    public void searchName() {
        System.out.println("Nhap ten san pham ban muon tim kiem: ");
        String name = scanner.nextLine();
        for (int i = 0; i < repository.displayAll().size(); i++) {
            if (repository.displayAll().get(i).getProductName().toLowerCase(Locale.ROOT).equals(name)) {
                System.out.println(repository.displayAll().get(i).toString());
                return;
            }
        }
        System.out.println("Khong tim thay ten san pham trong danh sach!!!");
    }

    @Override
    public void up() {
        repository.sortUp();
    }

    @Override
    public void down() {
        repository.sortDown();
    }
}

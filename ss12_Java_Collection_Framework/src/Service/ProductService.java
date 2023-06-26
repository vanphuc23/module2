package Service;

import Model.Product;
import Repository.IProductRepository;
import Repository.ProductRepository;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ProductService implements IProductService {

    private IProductRepository iProductRepository = new ProductRepository();
    Scanner scanner = new Scanner(System.in);


    @Override
    public void display() {
        for (Product p : iProductRepository.findAll()
        ) {
            System.out.println(p.toString());
        }
    }

    @Override
    public ArrayList<Product> add() {
        System.out.println("Nhập id: ");
        int newId = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập sản phẩm: ");
        String newProduct = scanner.nextLine();
        System.out.println("Nhập giá: ");
        double newPrice = Double.parseDouble(scanner.nextLine());
        Product product = new Product(newId, newProduct, newPrice);
        for (int i = 0; i < iProductRepository.findAll().size(); i++) {
            if (iProductRepository.findAll().get(i).getId() == product.getId()) {
                System.out.println("Trùng id ko thể thêm sản phẩm vào!!!");
                return null;
            } else if (iProductRepository.findAll().get(i).getProductName().toLowerCase().equals(product.getProductName())) {
                System.out.println("Trùng tên sản phẩm ko thể thêm sản phẩm vào!!!");
                return null;
            }
        }
        iProductRepository.findAll().add(product);
        return iProductRepository.findAll();
    }

    @Override
    public ArrayList<Product> editId() {
        System.out.println("Nhập id sản phẩm muốn sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < iProductRepository.findAll().size(); i++) {
            if (iProductRepository.findAll().get(i).getId() == id) {
                System.out.println(iProductRepository.findAll().get(i).getProductName() + " Bạn muốn sửa thành: ");
                String newProduct = scanner.nextLine();
                System.out.println(iProductRepository.findAll().get(i).getPrice() + " Bạn muốn sửa thành: ");
                double newPrice = Double.parseDouble(scanner.nextLine());
                Product product = new Product(id, newProduct, newPrice);
                iProductRepository.findAll().set(i, product);
                return iProductRepository.findAll();
            }
        }
        System.out.println("Không tìm thấy id trùng khớp!!!");
        return null;
    }

    @Override
    public ArrayList<Product> removeId() {
        System.out.println("Nhập id sản phẩm muốn xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < iProductRepository.findAll().size(); i++) {
            if (iProductRepository.findAll().get(i).getId() == id) {
                iProductRepository.findAll().remove(i);
                return iProductRepository.findAll();
            }
        }
        System.out.println("Không tìm thấy Id trùng khớp");
        return null;
    }

    @Override
    public void searchName() {
        System.out.println("Nhập tên muốn tìm kiếm: ");
        String name = scanner.nextLine();
        for (int i = 0; i < iProductRepository.findAll().size(); i++) {
            if (iProductRepository.findAll().get(i).getProductName().toLowerCase(Locale.ROOT).equals(name)) {
                System.out.println(iProductRepository.findAll().get(i).toString());
                return;
            }
        }
        System.out.println("Không tìm thấy tên sản phẩm");
    }

    @Override
    public void sortUp() {
        iProductRepository.sortUp();
    }

    @Override
    public void sortDown() {
        iProductRepository.sortDown();
    }
}

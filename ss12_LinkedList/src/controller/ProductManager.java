package controller;

import java.util.Scanner;

import service.IProductService;
import service.ProductService;

public class ProductManager {
	IProductService productService = new ProductService();
	Scanner scanner = new Scanner(System.in);

	public void display() {
		int choose;
		do {
			System.out.println("========== Menu ==========");
			System.out.println("1. Tạo Sản Phẩm");
			System.out.println("2. Xem Danh Sách Sản Phẩm");
			System.out.println("3. Sửa thông tin sản phẩm theo id");
			System.out.println("4. Xoá sản phẩm theo id");
			System.out.println("5. Tìm kiếm sản phẩm theo tên");
			System.out.println("6. Sắp xếp sản phẩm tăng dần theo giá");
			System.out.println("7. Sắp xếp sản phẩm giảm dần theo giá");
			System.out.println("Mời chọn chức năng: ");
			choose = Integer.parseInt(scanner.nextLine());
			switch (choose) {
				case 1:
					productService.addProduct();
					break;
				case 2:
					productService.display();
					break;
				case 3:
					productService.repairName();
					break;
				case 4:
					productService.remove();
					break;
				case 5:
					productService.searchName();
					break;
				case 6:
					productService.up();
					break;
				case 7:
					productService.down();
					break;
			}
		} while (choose >= 1 && choose <= 7);
	}
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        ProductManager productManager = new ProductManager();
        do {
            System.out.println("========= PRODUCT MANAGEMENT SYSTEM =========");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Cập nhật số lượng theo ID");
            System.out.println("4. Xóa sản phẩm đã hết hàng");
            System.out.println("5. Thoát chương trình");
            System.out.println("=============================================");
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Category: ");
                    String category = sc.nextLine();

                    Product p = new Product(id, name, price, quantity, category);
                    productManager.addProduct(p);
                    break;

                case 2:
                    productManager.displayProducts();
                    break;

                case 3:
                    System.out.print("Nhập ID: ");
                    int updateId = sc.nextInt();

                    System.out.print("Số lượng mới: ");
                    int newQuantity = sc.nextInt();

                    productManager.updateQuantity(updateId, newQuantity);
                    break;

                case 4:
                    productManager.deleteProduct();
                    break;

                case 5:
                    System.out.println("Thoát chương trình");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }

        } while (choice != 5);
    }
}

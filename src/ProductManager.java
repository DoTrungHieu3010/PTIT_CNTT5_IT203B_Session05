import java.util.*;
import java.util.stream.*;

public class ProductManager {
    private final ArrayList<Product> products = new ArrayList<>();
    public void addProduct(Product p) throws InvalidProductException {
        boolean exists = products.stream().anyMatch(product -> product.getId() == p.getId());

        if (exists) {
            throw new InvalidProductException("Sản phẩm đã tồn tại");
        }

        products.add(p);
        System.out.println("Thêm thành công");
    }

    public void displayProducts() {
        System.out.printf("%-5s %-10s %-10s %-10s %-10s\n", "ID", "Name", "Price", "Quantity", "Category");

        products.forEach(p ->
                System.out.printf("%-5d %-10s %-10.2f %-10d %-10s\n", p.getId(), p.getName(), p.getPrice(), p.getQuantity(), p.getCategory())
        );
    }

    public void updateQuantity(int id, int newQuantity) throws InvalidProductException {
        Optional<Product> result = products.stream().filter(p -> p.getId() == id).findFirst();

        if (result.isPresent()) {
            result.get().setQuantity(newQuantity);
            System.out.println("Cập nhật thành công");
        } else {
            throw new InvalidProductException("Không tìm thấy sản phẩm");
        }
    }

    public void deleteProduct() {
        products.removeIf(p -> p.getQuantity() == 0);
        System.out.println("Đã xóa sản phẩm hết");
    }
}

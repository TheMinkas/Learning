package ProductSystem;

import java.util.List;

public interface ProductRepozitory {
    void addNewProduct(Product product);
    List<Product> getProductList();
    Product addProductList();
}

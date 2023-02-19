package MyPrograms.ProductSystem;

import java.util.List;

public interface ProductRepository {
    void addNewProduct(Product product);
    List<Product> getProductList();
    List<String> getTempList();
    Product addProductList();
    void overWritingProduct();
    void deleteProduct();
    void fileWriter();
    void fileReader();
    void showProductListForUser();
}
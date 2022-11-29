package ProductSystem;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryMemory implements ProductRepozitory {
    private ArrayList<Product> productList = new ArrayList<>();
    //Добавление продукта в productList
    @Override
    public void addNewProduct(Product product) {
        productList.add(product);
    }
    //Доступ к листу productList
    @Override
    public List<Product> getProductList() {
        return productList;
    }
    //Создание нового продукта
    @Override
    public Product addProductList() {
        System.out.print("Введите id: ");
        int id = UserInput.readUserInputInt();
        String name = "null";

        if(checkOverlapId(id) == true) {

            do {
                System.out.print("Введите название товара: ");
                String tempName = UserInput.readUserInputString();
                if(checkOverlapName(tempName) == true) {
                    name = tempName;
                }
            } while (name.equals("null"));

            System.out.print("Введите количество товара: ");
            int quantity = UserInput.readUserInputInt();
            System.out.print("Введите вес товара: ");
            double weight = UserInput.readUserInputDouble();
            return new Product(id, name, quantity, weight);

        } else {
            return addProductList();
        }

    }
    //Проверка на совпадение ID
    public boolean checkOverlapId(int id) {
        boolean isNewId = true;

        for (int i=0; i<productList.size(); i++) {
            if(productList.get(i).getId() == id) {
                System.out.println("\nТакой id уже используется.\n");
                isNewId = false;
                break;
            }
        }

        return isNewId;
    }
    //Проверка на совпадение названий товара
    public boolean checkOverlapName(String name) {
        boolean isNewName = true;

        for (int i=0; i<productList.size(); i++) {
            if(productList.get(i).getName().equals(name)) {
                System.out.println("\nТакой название товара уже используется.\n");
                isNewName = false;
                break;
            }
        }

        return isNewName;
    }

}

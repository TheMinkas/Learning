package ProductSystem;

import java.util.Collections;

public class UserMenu {
    public static void main(String[] args) {


        ProductRepository productRepository = new ProductRepositoryMemory();

//        productRepository.addNewProduct(new Product(1, "Гречка", 10, 10));
//        productRepository.addNewProduct(new Product(2, "Арбуз", 2, 20));
//        productRepository.addNewProduct(new Product(3, "Чашка", 5, 3));
//        productRepository.addNewProduct(new Product(4, "Вилка", 20, 2));

        productRepository.fileReader();

        while (true) {
            System.out.println("\nМЕНЮ: ");
            System.out.println("1. Список продуктов. \n" +
                    "2. Добавление товара. \n" +
                    "3. Изменение товара. \n" +
                    "4. Удаление товара.");
            System.out.print("\nВыберите необходимый пункт МЕНЮ: ");
            int userInputMenu = UserInput.readUserInputInt();
            switch (userInputMenu) {
                case 1:
                    if (productRepository.getProductList().isEmpty()) {
                        System.out.println("\nСписок пуст!");
                    } else {
                        System.out.println("\nСписок продуктов: ");
                        productRepository.getProductList().forEach(System.out::println);
                    }
                    break;
                case  2:
                    System.out.println("\nДобавление товара.");
                    productRepository.addNewProduct(productRepository.addProductList());
                    break;
                case 3:
                    System.out.println("\nИзменение товара.");
                    productRepository.overWritingProduct();
                    break;
                case 4:
                    System.out.println("\nУдаление товара.");
                    productRepository.deleteProduct();
                    break;
                default:
                    System.out.println("\nТакого пункта меню нет, повторите попытку!");
                    break;
            }
        }
    }
}

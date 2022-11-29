package ProductSystem;

import java.util.ArrayList;
import java.util.List;

public class UserMenu {
    public static void main(String[] args) {


        ProductRepozitory productRepozitory = new ProductRepositoryMemory();
        productRepozitory.addNewProduct(new Product(1, "Гречка", 10, 10));
        productRepozitory.addNewProduct(new Product(2, "Арбуз", 2, 20));
        productRepozitory.addNewProduct(new Product(3, "Чашка", 5, 3));
        productRepozitory.addNewProduct(new Product(4, "Вилка", 20, 2));

        while (true){
            System.out.println("\nМЕНЮ: ");
            System.out.println("1. Список продуктов. \n" +
                    "2. Добавление товара. \n" +
                    "3. Изменение товара. \n" +
                    "4. Удаление товара.");
            System.out.print("\nВыберите необходимый пункт МЕНЮ: ");
            int userInputMenu = UserInput.readUserInputInt();
            switch (userInputMenu) {
                case 1:
                    System.out.println("\nСписок продуктов: ");
                    productRepozitory.getProductList().forEach(System.out::println);
                    break;
                case  2:
                    System.out.println("\nДобавление товара.");
                    productRepozitory.addNewProduct(productRepozitory.addProductList());
                    break;
                case 3:
                    System.out.println("\nИзменение товара.");
                    break;
                case 4:
                    System.out.println("\nУдаление товара.");
                    break;
                default:
                    System.out.println("\nТакого пункта меню нет, повторите попытку!");
                    break;
            }


        }
    }
}

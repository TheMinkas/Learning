package ProductSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepositoryMemory implements ProductRepository {
    private List<Product> productList = new ArrayList<>();
    private File myFile = new File("Products.txt");
    private List<String> tempList = new ArrayList<>();
    private static String tempInt = "";
    //Добавление продукта в productList
    @Override
    public void addNewProduct(Product product) {
        productList.add(product);
        Collections.sort(productList);
        fileWriter();
    }
    //Доступ к листу productList
    @Override
    public List<Product> getProductList() {
        return productList;
    }

    public List<String> getTempList() { return tempList; }

    @Override
    public void overWritingProduct() {
        System.out.print("Введите id товара, который следует изменить: ");
        int idProduct = UserInput.readUserInputInt();
        Product tempProduct = productList.get(idProduct-1);

        System.out.println("Введите название товара: ");
        String tempName = UserInput.readUserInputString();
        tempProduct.setName(tempName);

        System.out.println("Введите количество товара: ");
        int quantity = UserInput.readUserInputInt();
        tempProduct.setQuantity(quantity);

        System.out.println("Введите вес товара: ");
        double weight = UserInput.readUserInputDouble();
        tempProduct.setWeight(weight);

        productList.set((idProduct-1), tempProduct);
        fileWriter();
        System.out.println("Товар изменен!");

    }

    @Override
    public void deleteProduct() {
        tempInt = "";
        System.out.print("Введите id товара, который следует удалить: ");
        int idProduct = UserInput.readUserInputInt();
        productList.remove(idProduct -1);
        tempInt = String.valueOf(idProduct);
        fileWriter();
        System.out.println("Товар удалён!");
        //А на это ещё 2 часа....
        int x = 1;
        for(int i = 0; i<productList.size(); i++) {
           Product tempProduct = productList.get(i);
           tempProduct.setId(x);
           x++;
           productList.set(i, tempProduct);
        }
    }

    @Override
    public void fileWriter() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(myFile));
            writer.write(String.valueOf(productList));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fileReader() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(myFile));
            while (reader.ready()) {
                tempList.add(reader.readLine());
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        if(getTempList().isEmpty()) {

        } else {
            //Эту ХУЕТУ я писал 4 часа!!!!! Я ТАК ЗАЕБАЛСЯ!!!!!! ЭТО АВТОРСКАЙ ХУЕТА!!!!!!
            //После чтения фала,
            //в данном фрагменте кода происходит запись из List<String> tempList в List<Student>
            String[] tempArrayString = tempList.get(0).split(", ");
            for (int i = 0; i<tempArrayString.length; i++){
                String tempString = tempArrayString[i]
                        .replaceAll("\\[", "")
                        .replaceAll("]", "");
                String[] tempArrayString2 = tempString.split("\\|");

                addNewProduct(
                    new Product(
                    Integer.parseInt(tempArrayString2[0]),
                    tempArrayString2[1],
                    Integer.parseInt(tempArrayString2[2]),
                    Double.parseDouble(tempArrayString2[3])));
            }
        }


    }

    @Override
    public void productSearch() {
        //Попробовать реализовать
    }

    //Создание нового продукта
    @Override
    public Product addProductList() {
        System.out.print("Введите id: ");
        int id = UserInput.readUserInputInt();
        String name = "null";

        if(checkOverlapId(id) == true && id <= productList.size()+1) {

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
                System.out.println("Введите следующий ID по списку: " + (productList.size()+1));
            return addProductList();
        }

    }
    //Проверка на совпадение ID
    public boolean checkOverlapId(int id) {
        boolean isNewId = true;

        for (int i=0; i<productList.size(); i++) {
            if(productList.get(i).getId() == id) {
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

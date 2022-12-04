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
    //���������� �������� � productList
    @Override
    public void addNewProduct(Product product) {
        productList.add(product);
        Collections.sort(productList);
        fileWriter();
    }
    //������ � ����� productList
    @Override
    public List<Product> getProductList() {
        return productList;
    }

    public List<String> getTempList() { return tempList; }

    @Override
    public void overWritingProduct() {
        System.out.print("������� id ������, ������� ������� ��������: ");
        int idProduct = UserInput.readUserInputInt();
        Product tempProduct = productList.get(idProduct-1);

        System.out.println("������� �������� ������: ");
        String tempName = UserInput.readUserInputString();
        tempProduct.setName(tempName);

        System.out.println("������� ���������� ������: ");
        int quantity = UserInput.readUserInputInt();
        tempProduct.setQuantity(quantity);

        System.out.println("������� ��� ������: ");
        double weight = UserInput.readUserInputDouble();
        tempProduct.setWeight(weight);

        productList.set((idProduct-1), tempProduct);
        fileWriter();
        System.out.println("����� �������!");

    }

    @Override
    public void deleteProduct() {
        System.out.print("������� id ������, ������� ������� �������: ");
        int idProduct = UserInput.readUserInputInt();
        productList.remove(idProduct -1);
        System.out.println("����� �����!");
        //� �� ��� ��� 2 ����....
        //����� ������� ���, ����� ����� �������� ������, ���������� ����� �� id
        int x = 1;
        for(int i = 0; i<productList.size(); i++) {
           Product tempProduct = productList.get(i);
           tempProduct.setId(x);
           x++;
           productList.set(i, tempProduct);
        }
        fileWriter();
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
            //��� ����� � ����� 4 ����!!!!! � ��� ��������!!!!!! ��� ��������� �����!!!!!!
            //����� ������ ����, ���������� ������������ ���������� �� tempList � productList
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
    public void showProductListForUser() {
        if(productList.isEmpty()) {
            System.out.println("\n������ ����!");
        } else {
            for (int i = 0; i < productList.size(); i++) {
                System.out.println("\nID: " + productList.get(i).getId()
                        + ".\n�������� ������: " + productList.get(i).getName()
                        + ". \n����������� ������: " + productList.get(i).getQuantity() + ". \n��� ������: " + productList.get(i).getWeight());
            }
        }
    }

    //�������� ������ ��������
    @Override
    public Product addProductList() {
        System.out.print("������� id: ");
        int id = UserInput.readUserInputInt();
        String name = "null";
        //����� ������� ���, ����� ������ ���� ������� id �� �� ������
        if(checkOverlapId(id) == true && id <= productList.size()+1) {
            //�������� �������� �� ���������� ��� � �����
            do {
                System.out.print("������� �������� ������: ");
                String tempName = UserInput.readUserInputString();
                if(checkOverlapName(tempName) == true) {
                    name = tempName;
                }
            } while (name.equals("null"));
            System.out.print("������� ���������� ������: ");
            int quantity = UserInput.readUserInputInt();

            System.out.print("������� ��� ������: ");
            double weight = UserInput.readUserInputDouble();
            return new Product(id, name, quantity, weight);
        } else {
                System.out.println("������� ��������� �� ������ ID: " + (productList.size()+1));
            return addProductList();
        }

    }
    //�������� �� ���������� ID
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
    //�������� �� ���������� �������� ������
    public boolean checkOverlapName(String name) {
        boolean isNewName = true;

        for (int i=0; i<productList.size(); i++) {
            if(productList.get(i).getName().equals(name)) {
                System.out.println("\n����� �������� ������ ��� ������������.\n");
                isNewName = false;
                break;
            }
        }

        return isNewName;
    }

}

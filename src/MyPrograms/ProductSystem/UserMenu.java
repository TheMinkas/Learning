package MyPrograms.ProductSystem;

public class UserMenu {
    public static void main(String[] args) {


        ProductRepository productRepository = new ProductRepositoryMemory();

//        productRepository.addNewProduct(new Product(1, "������", 10, 10));
//        productRepository.addNewProduct(new Product(2, "�����", 2, 20));
//        productRepository.addNewProduct(new Product(3, "�����", 5, 3));
//        productRepository.addNewProduct(new Product(4, "�����", 20, 2));

        productRepository.fileReader();

        while (true) {
            System.out.println("\n����: ");
            System.out.println("1. ������ ���������. \n" +
                    "2. ���������� ������. \n" +
                    "3. ��������� ������. \n" +
                    "4. �������� ������. \n" +
                    "5. �����.");
            System.out.print("\n�������� ����������� ����� ����: ");
            int userInputMenu = UserInput.readUserInputInt();
            switch (userInputMenu) {
                case 1:
                    productRepository.showProductListForUser();
                    break;
                case  2:
                    System.out.println("\n���������� ������.");
                    productRepository.addNewProduct(productRepository.addProductList());
                    break;
                case 3:
                    System.out.println("\n��������� ������.");
                    productRepository.overWritingProduct();
                    break;
                case 4:
                    System.out.println("\n�������� ������.");
                    productRepository.deleteProduct();
                    break;
                case 5:
                    System.out.println("\n��������� ���������");
                    System.exit(0);
                default:
                    System.out.println("\n������ ������ ���� ���, ��������� �������!");
                    break;
            }
        }
    }
}

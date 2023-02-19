package MyPrograms.BankClient.DemoBank;

public class UserCommunication {
    RegistrationAndAuthorization registrationAndAuthorization = new RegistrationAndAuthorization();
    InputOutputMySQL inputOutputMySQL = new InputOutputMySQL();
    Verification verification = new Verification();

    public void primaryUserMenu() {
        while (true) {
            System.out.println("\nTest BAnk Client" +
                    "\n 1. �����������."
                    + "\n 2. �����������."
                    + "\n 3. ���������� ���������.");
            System.out.print("\n�������� ����������� ����� ����: ");
            int userInput = UserInput.readUserInputInt();

            switch (userInput) {
                case 1:
                    boolean checkFlag = userAuthorization();
                    if (checkFlag == true) {
                        startUserMenu();
                    }
                    break;
                case 2:
                    userRegistration();
                    break;
                case 3:
                    System.out.println("��������� ���������.");
                    System.exit(0);
                default:
                    System.out.println("����������� ������ ����� ����, ��������� �������.");
                    break;
            }
        }
    }

    public void startUserMenu() {
        while (true) {
            System.out.println("\n����� ���������� � DemoBank." +
                    "\n�� ������ ��������������� ���������� ���������: " +
                    "\n1. ��� �������." +
                    "\n2. ������."
                    + "\n3. ����������."
                    + "\n4. �����.");
            System.out.print("\n�������� ����������� ����� ����: ");
            int userInput = UserInput.readUserInputInt();
            switch (userInput) {
                case 1:
                    inputOutputMySQL.userOutputProfile();
                    boolean isContinue = true;
                    while (isContinue) {
                        System.out.println("\n1. �������� ������ �������. 2. �����.");
                        System.out.print("\n�������� ����������� ����� ����: ");
                        int userInputProfile = UserInput.readUserInputInt();
                        switch (userInputProfile) {
                            case 1:
                                System.out.println("\n1. ���: " + "2. �������: " + "3. ���� ��������: "
                                            + "4. ���������� �����: " + "5. ����� �����������: "
                                            + "6. ��������� �������: ");
                                System.out.print("�������� ����� �������, ������� ���������� ��������: ");
                                int userInputWorkWithProfile = UserInput.readUserInputInt();
                                switch (userInputWorkWithProfile) {
                                    case 1:
                                        System.out.println("������� ����� ���.");
                                        String userNewName = UserInput.readUserInputString();
                                        String changeName ="UPDATE clients SET name = ? WHERE phoneNumber = ? LIMIT 1000;";
                                        inputOutputMySQL.changeUserProfile(changeName, userNewName);
                                        break;
                                    case 2:
                                        System.out.println("������� �������.");
                                        String userNewSurname = UserInput.readUserInputString();
                                        String changeSurname ="UPDATE clients SET surname = ? WHERE phoneNumber = ? LIMIT 1000;";
                                        inputOutputMySQL.changeUserProfile(changeSurname, userNewSurname);
                                        break;
                                    case 3:
                                        System.out.println("������� ���� ��������.");
                                        String dateOfBirth = UserInput.readUserInputString();
                                        String changeDateOfBirth ="UPDATE clients SET dateOfBirth = ? WHERE phoneNumber = ? LIMIT 1000;";
                                        inputOutputMySQL.changeUserProfile(changeDateOfBirth, dateOfBirth);
                                        break;
                                    case 4:
                                        System.out.println("������� ���������� �����.");
                                        String passportNumber = UserInput.readUserInputString();
                                        String changePassportNumber ="UPDATE clients SET passportNumber = ? WHERE phoneNumber = ? LIMIT 1000;";
                                        inputOutputMySQL.changeUserProfile(changePassportNumber, passportNumber);
                                        break;
                                    case 5:
                                        System.out.println("������� ����� �����������.");
                                        String registration = UserInput.readUserInputString();
                                        String changeRegistration ="UPDATE clients SET registration = ? WHERE phoneNumber = ? LIMIT 1000;";
                                        inputOutputMySQL.changeUserProfile(changeRegistration, registration);
                                        break;
                                    case 6:
                                        System.out.println("������� ����� ������.");
                                        String password = UserInput.readUserInputString();
                                        String changePassword ="UPDATE clients SET password = ? WHERE phoneNumber = ? LIMIT 1000;";
                                        inputOutputMySQL.changeUserProfile(changePassword, password);
                                        break;
                                    default:
                                        System.out.println("����������� ������ ����� ����, ��������� �������.");
                                        break;
                                }
                            case 2:
                                isContinue = false;
                                //startUserMenu();
                                break;
                            default:
                                System.out.println("����������� ������ ����� ����, ��������� �������.");
                                break;
                        }
                    }
                    break;
                case 2:
                    inputOutputMySQL.userOutputBalance();
                    break;
                case 3:
                    while(true) {
                        System.out.println("\n1. ��������� ������. 2. ��������� �������� �� ������ ��������. 3. �����");
                        int userTransactionSelection = UserInput.readUserInputInt();
                        switch (userTransactionSelection) {
                            case 1:
                                System.out.println("������� �����, ������� ���������� ���������");
                                int userGetMoney = UserInput.readUserInputInt();
                                String selectSQL ="UPDATE clients SET balance = balance + ? WHERE phoneNumber = ? LIMIT 1000";
                                inputOutputMySQL.userUpDateBalance(userGetMoney, selectSQL);
                                startUserMenu();
                            case 2:
                                System.out.print("������� ����� ��������, �������� ���������� ��������� ��������: ");
                                String phoneNumber = UserInput.readUserInputString();
                                System.out.print("������� �����: ");
                                int money = UserInput.readUserInputInt();
                                inputOutputMySQL.userSendMoney(phoneNumber, money);
                                startUserMenu();
                            case 3:
                                startUserMenu();
                            default:
                                System.out.println("����������� ������ ����� ����, ��������� �������.");
                        }
                        break;
                    }
                case 4:
                    primaryUserMenu();
                default:
                    System.out.println("����������� ������ ����� ����, ��������� �������.");
                    break;
            }
        }
    }

    public boolean userAuthorization() {
        boolean checkFlag = false;
        System.out.print("������� �������: ");
        String phoneNumber = UserInput.readUserInputString();
        System.out.print("������� ������: ");
        String password = UserInput.readUserInputString();

        checkFlag = registrationAndAuthorization.userInputAuthorization(phoneNumber, password);
        return checkFlag;
    }
//������� ������� ����������� �������� �������� ����������
    public void userRegistration() {

        System.out.print("������� ���� ���: ");
        String name = UserInput.readUserInputString();
        System.out.print("������� ���� �������: ");
        String surname = UserInput.readUserInputString();
        String dateOfBirth = "";
        boolean dataCheck = false;

        while (dataCheck == false) {
            System.out.print("������� ���� �������� (������ ��.��.����): ");
            dateOfBirth = UserInput.readUserInputString();
            dataCheck = verification.isValidDate(dateOfBirth);
        }

        System.out.print("������� ����� ��������: ");
        String passportNumber = UserInput.readUserInputString();
        System.out.print("������� ����� �����������: ");
        String registration = UserInput.readUserInputString();
        System.out.print("������� ���������� �����: ");
        String phoneNumber = UserInput.readUserInputString();
        System.out.print("���������� ������ � ������� ������: ");
        String password = UserInput.readUserInputString();
        System.out.print("��������� ������: ");
        String repeatPassword = UserInput.readUserInputString();
        System.out.println("�� ������� ������������������: ");

        registrationAndAuthorization.userInputRegistration(name, surname, dateOfBirth, passportNumber, registration, phoneNumber, password);
    }
}

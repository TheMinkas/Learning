package MyPrograms.BankClient.DemoBank;

public class UserCommunication {
    RegistrationAndAuthorization registrationAndAuthorization = new RegistrationAndAuthorization();
    InputOutputMySQL inputOutputMySQL = new InputOutputMySQL();
    Verification verification = new Verification();

    public void primaryUserMenu() {
        while (true) {
            System.out.println("\nTest BAnk Client" +
                    "\n 1. Авторизация."
                    + "\n 2. Регистрация."
                    + "\n 3. Завершение программы.");
            System.out.print("\nВыберите необходимый пункт меню: ");
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
                    System.out.println("Программа завершена.");
                    System.exit(0);
                default:
                    System.out.println("Неправильно выбран пункт меню, повторите попытку.");
                    break;
            }
        }
    }

    public void startUserMenu() {
        while (true) {
            System.out.println("\nДобро пожаловать в DemoBank." +
                    "\nВы можете воспользоваться следующими функциями: " +
                    "\n1. Мой профиль." +
                    "\n2. Баланс."
                    + "\n3. Транзакции."
                    + "\n4. Выход.");
            System.out.print("\nВыберите необходимый пункт меню: ");
            int userInput = UserInput.readUserInputInt();
            switch (userInput) {
                case 1:
                    inputOutputMySQL.userOutputProfile();
                    boolean isContinue = true;
                    while (isContinue) {
                        System.out.println("\n1. Изменить данные профиля. 2. Назад.");
                        System.out.print("\nВыберите необходимый пункт меню: ");
                        int userInputProfile = UserInput.readUserInputInt();
                        switch (userInputProfile) {
                            case 1:
                                System.out.println("\n1. Имя: " + "2. Фамилия: " + "3. Дата Рождения: "
                                            + "4. Паспортный номер: " + "5. Место регистрации: "
                                            + "6. Мобильный телефон: ");
                                System.out.print("Выберите пункт профиля, который необходимо изменить: ");
                                int userInputWorkWithProfile = UserInput.readUserInputInt();
                                switch (userInputWorkWithProfile) {
                                    case 1:
                                        System.out.println("Введите новое имя.");
                                        String userNewName = UserInput.readUserInputString();
                                        String changeName ="UPDATE clients SET name = ? WHERE phoneNumber = ? LIMIT 1000;";
                                        inputOutputMySQL.changeUserProfile(changeName, userNewName);
                                        break;
                                    case 2:
                                        System.out.println("Введите фамилию.");
                                        String userNewSurname = UserInput.readUserInputString();
                                        String changeSurname ="UPDATE clients SET surname = ? WHERE phoneNumber = ? LIMIT 1000;";
                                        inputOutputMySQL.changeUserProfile(changeSurname, userNewSurname);
                                        break;
                                    case 3:
                                        System.out.println("Введите дату рождения.");
                                        String dateOfBirth = UserInput.readUserInputString();
                                        String changeDateOfBirth ="UPDATE clients SET dateOfBirth = ? WHERE phoneNumber = ? LIMIT 1000;";
                                        inputOutputMySQL.changeUserProfile(changeDateOfBirth, dateOfBirth);
                                        break;
                                    case 4:
                                        System.out.println("Введите паспортный номер.");
                                        String passportNumber = UserInput.readUserInputString();
                                        String changePassportNumber ="UPDATE clients SET passportNumber = ? WHERE phoneNumber = ? LIMIT 1000;";
                                        inputOutputMySQL.changeUserProfile(changePassportNumber, passportNumber);
                                        break;
                                    case 5:
                                        System.out.println("Введите адрес регистрации.");
                                        String registration = UserInput.readUserInputString();
                                        String changeRegistration ="UPDATE clients SET registration = ? WHERE phoneNumber = ? LIMIT 1000;";
                                        inputOutputMySQL.changeUserProfile(changeRegistration, registration);
                                        break;
                                    case 6:
                                        System.out.println("Введите новый пароль.");
                                        String password = UserInput.readUserInputString();
                                        String changePassword ="UPDATE clients SET password = ? WHERE phoneNumber = ? LIMIT 1000;";
                                        inputOutputMySQL.changeUserProfile(changePassword, password);
                                        break;
                                    default:
                                        System.out.println("Неправильно выбран пункт меню, повторите попытку.");
                                        break;
                                }
                            case 2:
                                isContinue = false;
                                //startUserMenu();
                                break;
                            default:
                                System.out.println("Неправильно выбран пункт меню, повторите попытку.");
                                break;
                        }
                    }
                    break;
                case 2:
                    inputOutputMySQL.userOutputBalance();
                    break;
                case 3:
                    while(true) {
                        System.out.println("\n1. Пополнить баланс. 2. Перевести средства по номеру телефона. 3. Назад");
                        int userTransactionSelection = UserInput.readUserInputInt();
                        switch (userTransactionSelection) {
                            case 1:
                                System.out.println("Введите сумму, которую необходимо пополнить");
                                int userGetMoney = UserInput.readUserInputInt();
                                String selectSQL ="UPDATE clients SET balance = balance + ? WHERE phoneNumber = ? LIMIT 1000";
                                inputOutputMySQL.userUpDateBalance(userGetMoney, selectSQL);
                                startUserMenu();
                            case 2:
                                System.out.print("Введите номер телефона, которому необходимо перевести средства: ");
                                String phoneNumber = UserInput.readUserInputString();
                                System.out.print("Введите сумму: ");
                                int money = UserInput.readUserInputInt();
                                inputOutputMySQL.userSendMoney(phoneNumber, money);
                                startUserMenu();
                            case 3:
                                startUserMenu();
                            default:
                                System.out.println("Неправильно выбран пункт меню, повторите попытку.");
                        }
                        break;
                    }
                case 4:
                    primaryUserMenu();
                default:
                    System.out.println("Неправильно выбран пункт меню, повторите попытку.");
                    break;
            }
        }
    }

    public boolean userAuthorization() {
        boolean checkFlag = false;
        System.out.print("Введите телефон: ");
        String phoneNumber = UserInput.readUserInputString();
        System.out.print("Введите пароль: ");
        String password = UserInput.readUserInputString();

        checkFlag = registrationAndAuthorization.userInputAuthorization(phoneNumber, password);
        return checkFlag;
    }
//Сделать жесткую регистрацию согласно правилам заполнения
    public void userRegistration() {

        System.out.print("Введите ваше имя: ");
        String name = UserInput.readUserInputString();
        System.out.print("Введите вашу фамилию: ");
        String surname = UserInput.readUserInputString();
        String dateOfBirth = "";
        boolean dataCheck = false;

        while (dataCheck == false) {
            System.out.print("Введите дату рождения (формат ДД.ММ.ГГГГ): ");
            dateOfBirth = UserInput.readUserInputString();
            dataCheck = verification.isValidDate(dateOfBirth);
        }

        System.out.print("Введите номер паспорта: ");
        String passportNumber = UserInput.readUserInputString();
        System.out.print("Введите место регистрации: ");
        String registration = UserInput.readUserInputString();
        System.out.print("Введите телефонный номер: ");
        String phoneNumber = UserInput.readUserInputString();
        System.out.print("Придумайте пароль к учётной записи: ");
        String password = UserInput.readUserInputString();
        System.out.print("Повторите пароль: ");
        String repeatPassword = UserInput.readUserInputString();
        System.out.println("Вы успешно зарегестрировались: ");

        registrationAndAuthorization.userInputRegistration(name, surname, dateOfBirth, passportNumber, registration, phoneNumber, password);
    }
}

package MyPrograms.BankClient.TEMP;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final List<BankAccount> bankAccountList= new ArrayList<>();
    private static ResultSet resultSets;

    public BankAccount createAccount(String name,
                                     String surname,
                                     String dateOfBirth,
                                     String passportNumber,
                                     String registration,
                                     String phoneNumber,
                                     String password) {
        System.out.println("Пользователь создан");
        return new BankAccount(name, surname, dateOfBirth, passportNumber, registration, phoneNumber, password);
    }

//    public String sqlConnect() throws SQLException {
//        String line = "select phoneNumber from clients";
//        String phoneNumber = "";
//
//        try {
//            Connection connection = ConnectionManager.openConnection();
//            Statement statement = connection.createStatement();
//            resultSets = statement.executeQuery(line);
//
//            while (resultSets.next()) {
//                phoneNumber = resultSets.getString(1);
//                System.out.println(phoneNumber);
//            }
//            } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return phoneNumber;
//    }


    public void createNewBankAccount(BankAccount bankAccount) {
        bankAccountList.add(bankAccount);
    }

    public List<BankAccount> getBankAccountList() {
        return bankAccountList;
    }


    public void showUser() {
        System.out.println(bankAccountList);
    }
}

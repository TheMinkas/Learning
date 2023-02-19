package MyPrograms.BankClient.DemoBank;

import MyPrograms.BankClient.AuthReg.BankRegistrationAndAuthorization;
import MyPrograms.BankClient.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationAndAuthorization implements BankRegistrationAndAuthorization {
    Verification verification = new Verification();
    private static String userPhoneNumber = "";

    public boolean userInputAuthorization(String phoneNumber, String password) {
        boolean checkFlag = false;
        userPhoneNumber = phoneNumber;
        boolean check = verification.checkPasswordAndNumber(phoneNumber, password);
        if (check == true) {
            return true;
        } else {
            System.out.println("\nНе правильно набран номер или пароль! Повторите попытку!\n");
            return false;
        }
    }
    public void userInputRegistration(String name, String surname,
                                      String dateOfBirth, String passportNumber,
                                      String registration, String phoneNumber, String password) {
        String line = "INSERT INTO clients (`name`, `surname`, `dateOfBirth`, `passportNumber`, `registration`, `phoneNumber`, `password`) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = ConnectionManager.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(line);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, dateOfBirth);
            preparedStatement.setString(4, passportNumber);
            preparedStatement.setString(5, registration);
            preparedStatement.setString(6, phoneNumber);
            preparedStatement.setString(7, password);

            preparedStatement.execute();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getUsePhoneNumber() {
        return this.userPhoneNumber;
    }
}

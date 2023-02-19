package MyPrograms.BankClient.DemoBank;

import MyPrograms.BankClient.util.ConnectionManager;

import java.sql.*;

public class InputOutputMySQL {
    RegistrationAndAuthorization registrationAndAuthorization = new RegistrationAndAuthorization();
    public void userOutputProfile() {
        String selectSQL ="SELECT idclients, name, surname, dateOfBirth, passportNumber, registration, phoneNumber FROM clients WHERE phoneNumber = ?";

        try {
            Connection connection = ConnectionManager.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, registrationAndAuthorization.getUsePhoneNumber());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(
                        "\nID: " + resultSet.getInt("idclients") +
                        "\nИмя: " + resultSet.getString("name") +
                        "\nФамилия: " + resultSet.getString("surname") +
                        "\nДата Рождения: " + resultSet.getString("dateOfBirth") +
                        "\nПаспортный номер: " + resultSet.getString("passportNumber") +
                        "\nМесто регистрации: " + resultSet.getString("registration") +
                        "\nМобильный телефон: " + resultSet.getString("phoneNumber"));
            }
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void userOutputBalance() {
        String selectSQL ="SELECT balance FROM clients WHERE phoneNumber = ?";

        try {
            Connection connection = ConnectionManager.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, registrationAndAuthorization.getUsePhoneNumber());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Баланс: " + resultSet.getInt("balance"));
            }
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void changeUserProfile(String userSearchString, String userNewString) {
        try {
            Connection connection = ConnectionManager.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(userSearchString);
            preparedStatement.setString(1, userNewString);
            preparedStatement.setString(2, registrationAndAuthorization.getUsePhoneNumber());
            preparedStatement.execute();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void userUpDateBalance(int addBalance, String selectSQL) {

        try {
            Connection connection = ConnectionManager.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, addBalance);
            preparedStatement.setString(2, registrationAndAuthorization.getUsePhoneNumber());
            preparedStatement.execute();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void userSendMoney(String phoneNumber, int transferAmount) {
        String selectSQL ="SELECT balance FROM clients WHERE phoneNumber = ?";
        int myBalance = 0;

        try {
            Connection connection = ConnectionManager.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, registrationAndAuthorization.getUsePhoneNumber());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                myBalance = resultSet.getInt("balance");
            }

            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (myBalance < transferAmount) {
            System.out.println("Ваш баланс = " + myBalance + ", перевод не возможен.");
        } else {
            String updateBalanceSQL1 ="UPDATE clients SET balance = balance + ? WHERE phoneNumber = ? LIMIT 1000";
            String updateBalanceSQL2 ="UPDATE clients SET balance = balance - ? WHERE phoneNumber = ? LIMIT 1000";
            String selectSQL2 ="SELECT phoneNumber FROM clients WHERE phoneNumber = ?";
            String checkCell = "";

            try {
                Connection connection = ConnectionManager.openConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(selectSQL2);
                preparedStatement.setString(1, phoneNumber);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    checkCell = resultSet.getString("phoneNumber");
                }
                preparedStatement.execute();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (checkCell.equals("")) {
                System.out.println("Такого номера не существует!");
            } else {
                try {
                    Connection connection = ConnectionManager.openConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(updateBalanceSQL1);
                    preparedStatement.setInt(1, transferAmount);
                    preparedStatement.setString(2, phoneNumber);
                    preparedStatement.execute();

                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                userUpDateBalance(transferAmount, updateBalanceSQL2);
            }
        }
    }
}

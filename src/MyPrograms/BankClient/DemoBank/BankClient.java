package MyPrograms.BankClient.DemoBank;

import MyPrograms.BankClient.TEMP.UserRepository;

import java.sql.SQLException;

public class BankClient {
    public static void main(String[] args) throws SQLException {
        UserCommunication userCommunication = new UserCommunication();
        userCommunication.primaryUserMenu();
    }
}

package MyPrograms.BankClient.DemoBank;

import MyPrograms.BankClient.util.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Verification {
    private static ResultSet resultSets;
    public boolean checkPasswordAndNumber(String phoneNumber, String password) {
        String line = "select phoneNumber, password from clients";
        boolean flag = false;

        try {
            Connection connection = ConnectionManager.openConnection();
            Statement statement = connection.createStatement();
            resultSets = statement.executeQuery(line);

            while (resultSets.next()) {
                String tempPhoneNumber = resultSets.getString(1);
                String tempPassword = resultSets.getString(2);
                if (tempPhoneNumber.equals(phoneNumber) && tempPassword.equals(password)) {
                    flag = true;
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}

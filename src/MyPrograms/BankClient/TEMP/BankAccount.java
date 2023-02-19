package MyPrograms.BankClient.TEMP;

public class BankAccount {
    private String name;
    private String surname;
    private String dateOfBirth;
    private String passportNumber;
    private String registration;
    private String phoneNumber;
    private int balance;
    private int previousTransactions;
    private String password;

    public BankAccount(String name, String surname, String dateOfBirth, String passportNumber, String registration, String phoneNumber, String password) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.passportNumber = passportNumber;
        this.registration = registration;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    @Override
    public String toString() {
        return this.name + "|"
                + this.surname + "|"
                + this.dateOfBirth + "|"
                + this.passportNumber + "|"
                + this.registration + "|"
                + this.phoneNumber + " ";
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

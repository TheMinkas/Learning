package MyPrograms.BankClient.TEMP;


public interface UserRepositoryInterface {
    void createNewBankAccount(BankAccount bankAccount);
    public BankAccount createAccount(String name,
                                     String surname,
                                     String dateOfBirth,
                                     String passportNumber,
                                     String registration,
                                     String phoneNumber);

}

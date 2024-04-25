/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package eiffelv.csc413_assignment5;

/**
 *
 * @author Eiffel
 */
public class DriverCode {

    public static void main(String[] args) {
        BankCustomer customer = new BankCustomerBuilder()
                .buildFirstName("Eiffel")
                .buildLastName("Valentino")
                .buildEmail("example@sfsu.edu")
                .buildPhoneNumber("4153381111")
                .buildAddress("1600 Holloway Ave")
                .build();

        System.out.println("Customer: " + customer.getFirstName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Phone: " + customer.getPhoneNumber());

        SavingsAccount account1 = new SavingsAccount(1000);
        SavingsAccount account2 = new SavingsAccount(500);

        TransactionCommand depositCommand = new DepositCommand(account1, 500);
        TransactionCommand withdrawalCommand = new WithdrawalCommand(account1, 200);
        TransactionCommand transferCommand = new TransferCommand(account1, account2, 300);

        depositCommand.execute();
        withdrawalCommand.execute();
        transferCommand.execute();

        System.out.println("Account 1 balance: " + account1.getBalance());
        System.out.println("Account 2 balance: " + account2.getBalance());
    }
}

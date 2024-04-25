/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiffelv.csc413_assignment5;

/**
 *
 * @author Eiffel
 */
class BankCustomer {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    
    public BankCustomer() {
        this.firstName = "John";
        this.lastName = "Doe";
        this.email = "john@example.com";
        this.phoneNumber = "9111111111";
        this.address = "123 Main St";
    }
    
    public BankCustomer(String firstName, String lastName, String email, 
            String phoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public String getAddress() {
        return this.address;
    }
}

class BankCustomerBuilder {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    
    public BankCustomerBuilder() {
        
    }

    public BankCustomerBuilder buildFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public BankCustomerBuilder buildLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BankCustomerBuilder buildEmail(String email) {
        this.email = email;
        return this;
    }

    public BankCustomerBuilder buildPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public BankCustomerBuilder buildAddress(String address) {
        this.address = address;
        return this;
    }
    
    public BankCustomer build() {
        return new BankCustomer(firstName, lastName, email, phoneNumber, address);
    }
}

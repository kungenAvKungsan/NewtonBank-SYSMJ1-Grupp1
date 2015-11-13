package BankAccount;

import java.util.ArrayList;

public class BankLogic {

    private ArrayList<Customer> customers = new ArrayList<>();

    public ArrayList<String> getCustomers() {
        ArrayList<String> custStrings = new ArrayList<>();
        for (Customer customer : customers) {
            custStrings.add(customer.pNr() + " " + customer.getName());
        }
        return custStrings;
    }

    public boolean addCustomer(String name, long pNr) {

        for (Customer customer : customers) {
            if (customer.pNr() == pNr)
                return false;
        }
            Customer newCust = new Customer(name, pNr, null);
            customers.add(newCust);
            return true;
        }
    }

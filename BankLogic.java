package BankAccount;

import java.util.ArrayList;

public class BankLogic {

    private ArrayList<Customer> customers = new ArrayList<>();
    private int accountNumberCounter = 1000;

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
        Customer newCust = new Customer(name, pNr);
        customers.add(newCust);
        return true;
    }

    public ArrayList<String> getCustomer(long pNr) {
        for (Customer customer : customers) {
            if (pNr == customer.pNr()) {
                ArrayList<String> infoList = new ArrayList<>();
                String info = customer.getName() + " " + customer.pNr();
                infoList.add(info);
                ArrayList<SavingsAccount> accounts = customer.getAccounts();
                for (SavingsAccount account : accounts) {
                    infoList.add(account.getBalance() + " " + account.getRate() + " " + account.getAccountNr());
                }

                return infoList;
            }

        }
        return null;
    }

    public boolean changeCustomerName(String name, long pNr) {
        for (Customer customer : customers) {
            if (pNr == customer.pNr()) {
                customer.setName(name);
                return true;
            }
        }

        return false;
    }

    public int addSavingsAccount(long pNr) {
        for (Customer customer : customers) {
            if (pNr == customer.pNr()) {
                SavingsAccount addSavingsAccount = new SavingsAccount(0, 1.5, accountNumberCounter++, "Assgoblin");
                customer.addAccount(addSavingsAccount);
                return addSavingsAccount.getAccountNr();
            }
        }
        return -1;
    }

    public ArrayList<String> removeCustomer(long pNr) {
        for (Customer customer : customers) {
            if (pNr == customer.pNr()) {
                ArrayList<String> infoList = new ArrayList<>();
                ArrayList<SavingsAccount> accounts = customer.getAccounts();
                for (SavingsAccount account : accounts) {
                    infoList.add(account.getAccountNr() + " " + account.getBalance() + " " + account.getBalanceInclusiveRate());
                }
                customers.remove(customer);
                return infoList;
            }
        }
        return null;
    }

    public String getAccount(long pNr, int accountId) {
        for (Customer customer : customers) {
            if (pNr == customer.pNr()) {
                SavingsAccount account = customer.getAccount(accountId);
                if (account == null) {
                    return null;
                }
                return account.getAccountNr() + " " + account.getBalance() + " " + account.getRate();
            }
        }
        return null;
    }

    public boolean deposit(long pNr, int accountId, double amount) {
        for (Customer customer : customers) {
            if (pNr == customer.pNr()) {
                SavingsAccount account = customer.getAccount(accountId);
                if (account == null) {
                    return false;
                }
                account.deposit(amount);
                return true;
            }
        }
        return false;
    }

    public boolean withdraw(long pNr, int accountId, double amount) {
        for (Customer customer : customers) {
            if (pNr == customer.pNr()) {
                SavingsAccount account = customer.getAccount(accountId);
                if (account == null) {
                    return false;
                }
                boolean wentOk = account.withdraw(amount);
                return wentOk;
            }
        }
        return false;
    }

    public String closeAccount(long pNr, int accountId) {
        for (Customer customer : customers) {
            if (pNr == customer.pNr()) {
                SavingsAccount account = customer.getAccount(accountId);
                if (account == null) {
                    return null;
                }
                customer.removeAccount(accountId);
                String accountInfo = account.getAccountNr() + " " + account.getBalance() + " " + account.getBalanceInclusiveRate();
                return accountInfo;
            }
        }
        return null;
    }



}

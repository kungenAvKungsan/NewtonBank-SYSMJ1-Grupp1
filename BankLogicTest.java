package BankAccount;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Created by Viktor on 2015-11-15.
 */
public class BankLogicTest {
    @Test
    public void TestingEverything() {
        BankLogic bl = new BankLogic();
        bl.addCustomer("Viktor", 123);
        assertTrue(bl.getCustomer(123) != null);
        bl.changeCustomerName("Dan Bilzerian", 123);
        ArrayList<String> bla =  bl.getCustomer(123);
        assertTrue(bla.get(0).equals("Dan Bilzerian 123"));
        assertTrue(bl.addSavingsAccount(123) == 1000);
        assertTrue(bl.addSavingsAccount(123) == 1001);
        bl.deposit(123, 1000, 5000);
        bl.deposit(123, 1001, 7000);
        String testOne = bl.getAccount(123, 1000);
        testOne = bl.getAccount(123, 1005);
        boolean testTwo = bl.withdraw(123, 1000, 4000);
        testTwo = bl.withdraw(123, 1000, 3000);
        String testThree = bl.closeAccount(123, 1000);
        testThree = bl.closeAccount(123, 1005);
        ArrayList<String> testFour = bl.removeCustomer(123);
    }
}

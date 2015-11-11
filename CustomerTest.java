package BankAccount;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void  personTest() {
		Customer.setPrsNbr(199406171996L);
	}
	@Test
	public void  namnSetTest() {
		Customer.setName("Marius");
	}
	@Test
	public void namnGetTest(){
		Customer.getName();
	}
}

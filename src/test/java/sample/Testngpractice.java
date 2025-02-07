package sample;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(genericUtility.ListenersImplimentation.class)
public class Testngpractice {
	@Test(priority=3)
	public void createuser() {
		System.out.println("user created");
		
	}
	
	@Test(priority=1)
	public void modifyuser() {
		System.out.println("user modified");
		
		
	}
	
	@Test(dependsOnMethods = {"modifyuser"},enabled=true)
	public void deleteuser() {
		System.out.println("user deleteted");
		
	}
	

}

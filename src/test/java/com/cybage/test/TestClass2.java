package com.cybage.test;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.main.Drivers;

public class TestClass2 {
	WebDriver driver;
	private final static Logger LOGGER = Logger.getLogger(TestClass.class.getName());

	@BeforeMethod
	public void setUp() {
		driver = Drivers.chooseDriver();
	}

	@Test
	public void firstTest() {
		driver.get("http://newtours.demoaut.com");
		LOGGER.info(driver.getTitle());
	}

	@Test
	public void secondTest() {
		driver.get("http://newtours.demoaut.com");
		Assert.assertEquals(driver.getTitle(), "Sopan");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
